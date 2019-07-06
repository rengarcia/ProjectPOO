package ec.edu.espe.schweitzer_revision.view;


import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.controller.FileManager;
import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Maintenance;
import ec.edu.espe.schweitzer_revision.model.OrderStatus;
import ec.edu.espe.schweitzer_revision.model.Repair;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhony Naranjo
 */
public class FRMClient extends javax.swing.JFrame {
 private static final Logger LOG = Logger.getLogger(FRMClient.class.getName());
    /**
     * Creates new form FRMClient
     */
    public FRMClient() {
        initComponents();
        setVisibility();
        setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());
    }
    
    public void clearTxtFiles(){
        txtName.setText("");
        txtAddress.setText("");
        txtId.setText("");
        txtPhoneNumber.setText("");
        txtMaintenanceAddress.setText("");
        txtMaintenanceDescription.setText("");
        txtSesionNumber.setText("");
        
        txtReparationDescription.setText("");
        txtReparationAddress.setText("");
 
    }
    
    public void setVisibility (){
        lblReparationAddress.setVisible(false);
        lblReparationDate.setVisible(false);
        lblReparationDescription.setVisible(false);
        lblReparationPriority.setVisible(false);
        txtReparationAddress.setVisible(false);
        jDateChooserRepair.setVisible(false);
        txtReparationDescription.setVisible(false);
        cbUrgencia.setVisible(false);
        jScrollPane4.setVisible(false);
        
        lblMaintenanceAddress.setVisible(false);
        lblMaintenanceDate.setVisible(false);
        lblMaintenanceDescription.setVisible(false);
        lblSesionNumber.setVisible(false);
        txtMaintenanceAddress.setVisible(false);
        jDateChooserMaintenance.setVisible(false);
        txtMaintenanceDescription.setVisible(false);
        txtSesionNumber.setVisible(false);
        jScrollPane2.setVisible(false);
           
        btnSave.setVisible(false);
    }

    public Client setData(){
              
        //Get Data for Client class
        Client clientData = new Client();
     
        clientData.setName(txtName.getText());
             
        clientData.setId(Long.valueOf(txtId.getText()));
             
        clientData.setAddress(txtAddress.getText());
        
        clientData.setPhone(Long.valueOf(txtPhoneNumber.getText()));
        
        //Data for Order Status is set these values for default
       
        
        OrderStatus orderStatusData= new OrderStatus();
        orderStatusData.setDescription("null");
        orderStatusData.setOrderCompletionDate("null");
        orderStatusData.setOrderCompleted("null");
        
        //temperol value for Combo Box
        String choice = (String)cmbType.getSelectedItem();
       
        if (choice.equals("Reparacion")){
                      
            clientData.flag=true;
        }
        
        else if (choice.equals("Mantenimiento")){

            clientData.flag=false;
        
            }
        return clientData;
    }  
    
    public Repair RepairOrder(){
        Repair repairData = new Repair();

            String formato = jDateChooserRepair.getDateFormatString();
            Date date = jDateChooserRepair.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            Long dateInLong = Long.valueOf(dateFormat.format(date));

            repairData.setDate(dateInLong);
    
            repairData.setAddress(txtReparationAddress.getText());
            
            repairData.setDescription(txtReparationDescription.getText());

            int priorityChoice = cmbType.getSelectedIndex();
            
            if(priorityChoice==1){
            repairData.setPriority(true);
            }
            else if(priorityChoice==2){
            repairData.setPriority(false);    
            }
            
            repairData.setId(repairData.generateID());
            repairData.setStatus(Status());
        
        return repairData;
    }
    
    public Maintenance MaitenanceOrder(){
        Maintenance maintenanceData = new Maintenance();

            String formato = jDateChooserMaintenance.getDateFormatString();
            Date date = jDateChooserMaintenance.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            Long dateInLong = Long.valueOf(dateFormat.format(date));
            
            maintenanceData.setDate(dateInLong);

            maintenanceData.setAddress(txtMaintenanceAddress.getText());

            maintenanceData.setDescription(txtMaintenanceDescription.getText());

            maintenanceData.setSession(Integer.parseInt(txtSesionNumber.getText()));
            
    
            maintenanceData.setId(maintenanceData.generateID());
            
            maintenanceData.setStatus(Status());
        
        return maintenanceData;
    }
    
    
    
    public OrderStatus Status(){
        OrderStatus orderStatusData= new OrderStatus();
        orderStatusData.setDescription("null");
        orderStatusData.setOrderCompletionDate("null");
        orderStatusData.setOrderCompleted("null");
        
        return orderStatusData;
    }
    
  public void reserveOrder(Client clientData){
        
       String clientOrderFilePath="Files\\ClientOrder.txt" ;
       String backupPath="Backup\\ClientOrder.txt" ;
       String technicianFilePath="Files\\TechnicianList.txt"; 
        
        String tempId;

        Boolean decide = clientData.flag;

        if (decide) {
            tempId = clientData.getNewRepairOrder().getId();
        } else {
            tempId = clientData.getNewMaintenanceOrder().getId();
        }

        //convert data to json format
        Gson gson = new Gson();
        String jsonClientData;
        jsonClientData = gson.toJson(clientData);

        File firstTimeRun = new File(clientOrderFilePath);
        boolean exist = firstTimeRun.exists();
        if (exist == false) {
            FileManager.writeFile(clientOrderFilePath, jsonClientData);
            FileManager.writeFile(backupPath, jsonClientData);
        } else {
            FileManager.appendStrToFile(clientOrderFilePath, jsonClientData);
            FileManager.appendStrToFile(backupPath, jsonClientData);
        }

        Client newOrderWaiting = new Client();
        try {
            newOrderWaiting.AssignOrder(clientOrderFilePath, technicianFilePath,
                    tempId);
            JOptionPane.showMessageDialog(this,"Su orden fue asignada con éxito\n"
                    + "El ID de su orden es: "+ tempId,"Orden Asignada", WIDTH);
        } catch (FileNotFoundException ex) {} catch (IOException ex) {
         JOptionPane.showMessageDialog(this,"Error con su orden","Error Orden", WIDTH);
         Logger.getLogger(FRMClient.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        cmbType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblMaintenanceDate = new javax.swing.JLabel();
        lblMaintenanceAddress = new javax.swing.JLabel();
        txtMaintenanceAddress = new javax.swing.JTextField();
        lblMaintenanceDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMaintenanceDescription = new javax.swing.JTextArea();
        lblSesionNumber = new javax.swing.JLabel();
        txtSesionNumber = new javax.swing.JTextField();
        jDateChooserMaintenance = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        lblReparationDate = new javax.swing.JLabel();
        lblReparationAddress = new javax.swing.JLabel();
        txtReparationAddress = new javax.swing.JTextField();
        lblReparationDescription = new javax.swing.JLabel();
        lblReparationPriority = new javax.swing.JLabel();
        cbUrgencia = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtReparationDescription = new javax.swing.JTextArea();
        jDateChooserRepair = new com.toedter.calendar.JDateChooser();
        btnSave = new javax.swing.JButton();
        btnNewOrder = new javax.swing.JButton();
        btnExit = new javax.swing.JToggleButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Numero telefónico: ");

        jLabel6.setText("Tipo de orden: ");

        txtPhoneNumber.setToolTipText("Ingrese aqui su numero telefonico de contacto");
        txtPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneNumberKeyTyped(evt);
            }
        });

        jLabel7.setText("ID (4 últimos dígitos cédula)");

        txtId.setToolTipText("Aqui ingrese los cuatro ultimos digitos de su cedula");
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombre: ");

        txtName.setToolTipText("Ingrese aqui sus nombres");
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        jLabel4.setText("Direccion:");

        txtAddress.setToolTipText("Ingrese aqui su direccio");
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressKeyTyped(evt);
            }
        });

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reparacion ", "Mantenimiento" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(97, 97, 97))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(92, 92, 92)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(txtName)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId)
                                    .addComponent(txtPhoneNumber)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                                .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)))
                .addGap(59, 59, 59))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(189, 189, 189))
        );

        jLabel1.setText("Bienvenid@");

        jLabel2.setText("Ingrese sus datos para su orden");

        lblMaintenanceDate.setText("Ingrese la fecha para el mantenimiento (dd/mm/aa): ");

        lblMaintenanceAddress.setText("Ingrese la dirección del mantenimiento: ");

        txtMaintenanceAddress.setToolTipText("Ingrese la direccion donde desea que lo visitemos para el mantenimiento");
        txtMaintenanceAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaintenanceAddressKeyTyped(evt);
            }
        });

        lblMaintenanceDescription.setText("Ingrese una descripción: ");

        txtMaintenanceDescription.setColumns(20);
        txtMaintenanceDescription.setRows(5);
        txtMaintenanceDescription.setToolTipText("Ingrese una breve descripcion del problema");
        txtMaintenanceDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaintenanceDescriptionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtMaintenanceDescription);

        lblSesionNumber.setText("Numero de Sesion:");

        jDateChooserMaintenance.setDateFormatString("ddMMyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSesionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSesionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMaintenanceDate)
                        .addGap(28, 28, 28)
                        .addComponent(jDateChooserMaintenance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaintenanceAddress)
                            .addComponent(lblMaintenanceDescription))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(txtMaintenanceAddress)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaintenanceDate)
                    .addComponent(jDateChooserMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaintenanceAddress)
                    .addComponent(txtMaintenanceAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaintenanceDescription)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(lblSesionNumber)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSesionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setToolTipText("Ingrese la descripcion de su problema");

        lblReparationDate.setText("Ingrese la fecha de la reparación (dd/mm/aa):");

        lblReparationAddress.setText("Ingrese la dirección de la reparación: ");

        txtReparationAddress.setToolTipText("Ingrese la direccion de reparación");
        txtReparationAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReparationAddressKeyTyped(evt);
            }
        });

        lblReparationDescription.setText("Ingrese una descripción de la reparación:");

        lblReparationPriority.setText("Es una reparación urgente: ");

        cbUrgencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        cbUrgencia.setToolTipText("Considera usted que es de suma urgencia la reparacion?");

        txtReparationDescription.setColumns(20);
        txtReparationDescription.setRows(5);
        txtReparationDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReparationDescriptionKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtReparationDescription);

        jDateChooserRepair.setDateFormatString("ddMMyy");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblReparationPriority, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReparationDate)
                            .addComponent(lblReparationAddress))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserRepair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtReparationAddress)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblReparationDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReparationDate)
                    .addComponent(jDateChooserRepair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReparationAddress)
                    .addComponent(txtReparationAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReparationDescription)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReparationPriority))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnSave.setText("Guardar");
        btnSave.setToolTipText("Guardar con los datos establecidos");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnNewOrder.setText("Nueva Orden");
        btnNewOrder.setToolTipText("Generar la orden con los datos establecidos");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });

        btnExit.setText("Menú");
        btnExit.setToolTipText("Salir de la pantalla");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnNewOrder)
                        .addGap(70, 70, 70)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(190, 190, 190))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewOrder)
                            .addComponent(btnExit))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
         FRMSchweitzerSystem system = new FRMSchweitzerSystem();
        system.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        int index = cmbType.getSelectedIndex();
        if (index==0){
            lblReparationAddress.setVisible(true);
            lblReparationDate.setVisible(true);
            lblReparationDescription.setVisible(true);
            lblReparationPriority.setVisible(true);
            txtReparationAddress.setVisible(true);
            jDateChooserRepair.setVisible(true);
            txtReparationDescription.setVisible(true);
            cbUrgencia.setVisible(true);
            jScrollPane4.setVisible(true);
            
            
            lblMaintenanceAddress.setVisible(false);
            lblMaintenanceDate.setVisible(false);
            lblMaintenanceDescription.setVisible(false);
            lblSesionNumber.setVisible(false);
            txtMaintenanceAddress.setVisible(false);
            jDateChooserMaintenance.setVisible(false);
            txtMaintenanceDescription.setVisible(false);
            txtSesionNumber.setVisible(false);
            jScrollPane2.setVisible(false);
            btnSave.setVisible(true);
   
        }
        else if(index==1) {
            lblMaintenanceAddress.setVisible(true);
            lblMaintenanceDate.setVisible(true);
            lblMaintenanceDescription.setVisible(true);
            lblSesionNumber.setVisible(true);
            txtMaintenanceAddress.setVisible(true);
            jDateChooserMaintenance.setVisible(true);
            txtMaintenanceDescription.setVisible(true);
            txtSesionNumber.setVisible(true);
            jScrollPane2.setVisible(true);
            
            
            lblReparationAddress.setVisible(false);
            lblReparationDate.setVisible(false);
            lblReparationDescription.setVisible(false);
            lblReparationPriority.setVisible(false);
            txtReparationAddress.setVisible(false);
            jDateChooserRepair.setVisible(false);
            txtReparationDescription.setVisible(false);
            cbUrgencia.setVisible(false);
            jScrollPane4.setVisible(false);
            btnSave.setVisible(true);
            
        }
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char validate=evt.getKeyChar();

   if(validate >=65 && validate<=90 || validate==8 
           || validate >=97 && validate<=122 || validate ==32 ){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
    LOG.warning("Values entered incorrect");  
    }
   
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        char validate=evt.getKeyChar();

    if(validate >=48 && validate<=57 || validate ==8){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        LOG.warning("Values entered incorrect");  
    }
        if (txtId.getText().length()== 4) {

         evt.consume(); 
    } 
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtPhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberKeyTyped
        char validate=evt.getKeyChar();

           if(validate >=48 && validate<=57 || validate==8){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        LOG.warning("Values entered incorrect");  
    }
            if (txtPhoneNumber.getText().length()== 10) {

         evt.consume(); 
    } 

            
    }//GEN-LAST:event_txtPhoneNumberKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        Client data = new Client();
        data = setData();

        if(data.flag==true){
        data.setNewRepairOrder(RepairOrder());
        }
        else if (data.flag==false){
        data.setNewMaintenanceOrder(MaitenanceOrder());
        }

        reserveOrder(data);
        clearTxtFiles();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyTyped
       char validate=evt.getKeyChar();

   if(validate >=65 && validate<=90 || validate==8 || validate >=97 && validate<=122 || 
           validate >=48 && validate<=57 || validate ==45){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras numeros y guion");
    LOG.warning("Values entered incorrect");  
    }
    }//GEN-LAST:event_txtAddressKeyTyped

    private void txtReparationAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReparationAddressKeyTyped
        char validate=evt.getKeyChar();

   if(validate >=65 && validate<=90 || validate==8 || validate >=97 && validate<=122 || 
           validate >=48 && validate<=57 || validate ==45){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras numeros y guion");
    LOG.warning("Values entered incorrect");  
    }
    }//GEN-LAST:event_txtReparationAddressKeyTyped

    private void txtReparationDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReparationDescriptionKeyTyped
       char validate=evt.getKeyChar();

   if(validate >=65 && validate<=90 || validate==8 || 
           validate >=97 && validate<=122 || validate ==32){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
    LOG.warning("Values entered incorrect");  
    }
    }//GEN-LAST:event_txtReparationDescriptionKeyTyped

    private void txtMaintenanceDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaintenanceDescriptionKeyTyped
        char validate=evt.getKeyChar();

   if(validate >=65 && validate<=90 || validate==8 || 
           validate >=97 && validate<=122 || validate ==32 ){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
    LOG.warning("Values entered incorrect");  
    }
    }//GEN-LAST:event_txtMaintenanceDescriptionKeyTyped

    private void txtMaintenanceAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaintenanceAddressKeyTyped
        char validate=evt.getKeyChar();

   if(validate >=65 && validate<=90 || validate==8 || validate >=97 && validate<=122 || 
           validate >=48 && validate<=57 || validate ==45){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras numeros y guion");
    LOG.warning("Values entered incorrect");  
    }
    }//GEN-LAST:event_txtMaintenanceAddressKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRMClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnExit;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cbUrgencia;
    private javax.swing.JComboBox<String> cmbType;
    private com.toedter.calendar.JDateChooser jDateChooserMaintenance;
    private com.toedter.calendar.JDateChooser jDateChooserRepair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblMaintenanceAddress;
    private javax.swing.JLabel lblMaintenanceDate;
    private javax.swing.JLabel lblMaintenanceDescription;
    private javax.swing.JLabel lblReparationAddress;
    private javax.swing.JLabel lblReparationDate;
    private javax.swing.JLabel lblReparationDescription;
    private javax.swing.JLabel lblReparationPriority;
    private javax.swing.JLabel lblSesionNumber;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMaintenanceAddress;
    private javax.swing.JTextArea txtMaintenanceDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtReparationAddress;
    private javax.swing.JTextArea txtReparationDescription;
    private javax.swing.JTextField txtSesionNumber;
    // End of variables declaration//GEN-END:variables
}
