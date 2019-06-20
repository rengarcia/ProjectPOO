/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.frames;


import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.controller.FileManager;
import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Maintenance;
import ec.edu.espe.schweitzer_revision.model.OrderStatus;
import ec.edu.espe.schweitzer_revision.model.Repair;
import java.io.File;
import java.io.FileNotFoundException;
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
        setIconImage(new ImageIcon(getClass().getResource("/ec/edu/espe/schweitzer_revision/frames/icono.png")).getImage());
    }
    
    public void setVisibility (){
         lblReparationAddress.setVisible(false);
         lblReparationDate.setVisible(false);
         lblReparationDescription.setVisible(false);
         lblReparationPriority.setVisible(false);
         txtReparationAddress.setVisible(false);
         txtReparationDate.setVisible(false);
         txtReparationDescription.setVisible(false);
         cbUrgencia.setVisible(false);
         jScrollPane4.setVisible(false);
        
          lblMaintenanceAddress.setVisible(false);
          lblMaintenanceDate.setVisible(false);
          lblMaintenanceDescription.setVisible(false);
          lblSesionNumber.setVisible(false);
          txtMaintenanceAddress.setVisible(false);
          txtMaintenanceDate.setVisible(false);
          txtMaintenanceDescription.setVisible(false);
          txtSesionNumber.setVisible(false);
          jScrollPane2.setVisible(false);
           
         
    }

    public Client setData(){
              
        //Get Data for Client class
        Client clientData = new Client();
     
        clientData.setName(txtName.getText());
             
        clientData.setId(Long.valueOf(txtId.getText()));
             
        clientData.setAddress(txtAddress.getText());
        
        clientData.setPhone(Long.valueOf(txtPhoneNumber.getText()));
        
        //Data for Order Status is set these values for default
        FileManager randomValue = new FileManager();
        
        OrderStatus orderStatusData= new OrderStatus();
        orderStatusData.setDescription(randomValue.randomString());
        orderStatusData.setOrderCompletionDate(randomValue.randomString());
        orderStatusData.setOrderCompleted(randomValue.randomString());
        
        
        //temperol value for Combo Box
        String choice = (String)cmbType.getSelectedItem();
        
        //decide wheter the client want a repair or maintenance
        if (choice.equals("Reparacion")){
            Repair repairData = new Repair();

            repairData.setDate(Long.valueOf(txtReparationDate.getText()));
    
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
            
            //Set data for Order attribute
            clientData.setNewRepairOrder(repairData);
            
            repairData.setStatus(orderStatusData);
            
            clientData.flag=true;
        }
        
        else if (choice.equals("Mantenimiento")){
            //Get data for Order attribute
            Maintenance maintenanceData = new Maintenance();

            
            maintenanceData.setDate(Long.valueOf(txtMaintenanceDate.getText()));

            maintenanceData.setAddress(txtMaintenanceAddress.getText());

            maintenanceData.setDescription(txtMaintenanceDescription.getText());

            maintenanceData.setSession(Integer.parseInt(txtSesionNumber.getText()));
            
            //Set data for Order attribute
            clientData.setNewMaintenanceOrder(maintenanceData);
            
            maintenanceData.setId(maintenanceData.generateID());
            
            maintenanceData.setStatus(orderStatusData);
            
            clientData.flag=false;
        
            }

        return clientData;
    }  
    
    
    public void reserveOrder(){
        
       String clientOrderFilePath="Files\\ClientOrder.txt" ;
       String backupPath="Backup\\ClientOrder.txt" ;
       String technicianFilePath="Files\\TechnicianList.txt"; 
        

        Client clientData = setData();
        FileManager newDataLine = new FileManager();

        String tempId;

        Boolean decide = clientData.flag;

        if (decide == true) {
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
            newDataLine.writeFile(clientOrderFilePath, jsonClientData);
            newDataLine.writeFile(backupPath, jsonClientData);
        } else {
            newDataLine.appendStrToFile(clientOrderFilePath, jsonClientData);
            newDataLine.appendStrToFile(backupPath, jsonClientData);
        }

        Client newOrderWaiting = new Client();
        try {
            newOrderWaiting.AssignOrder(clientOrderFilePath, technicianFilePath,
                    tempId);
        } catch (FileNotFoundException ex) {}
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
        btnExit = new javax.swing.JToggleButton();
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
        btnNewOrder = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblMaintenanceDate = new javax.swing.JLabel();
        txtMaintenanceDate = new javax.swing.JTextField();
        lblMaintenanceAddress = new javax.swing.JLabel();
        txtMaintenanceAddress = new javax.swing.JTextField();
        lblMaintenanceDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMaintenanceDescription = new javax.swing.JTextArea();
        lblSesionNumber = new javax.swing.JLabel();
        txtSesionNumber = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblReparationDate = new javax.swing.JLabel();
        txtReparationDate = new javax.swing.JTextField();
        lblReparationAddress = new javax.swing.JLabel();
        txtReparationAddress = new javax.swing.JTextField();
        lblReparationDescription = new javax.swing.JLabel();
        lblReparationPriority = new javax.swing.JLabel();
        cbUrgencia = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtReparationDescription = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnExit.setText("Salir");
        btnExit.setToolTipText("Salir de la pantalla");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

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
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                                .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId)
                                    .addComponent(txtPhoneNumber))))
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

        btnNewOrder.setText("Nueva Orden");
        btnNewOrder.setToolTipText("Generar la orden con los datos establecidos");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });

        lblMaintenanceDate.setText("Ingrese la fecha para el mantenimiento (dd/mm/aa): ");

        txtMaintenanceDate.setToolTipText("Ingrese la fecha que desea que lo visitemos");

        lblMaintenanceAddress.setText("Ingrese la dirección del mantenimiento: ");

        txtMaintenanceAddress.setToolTipText("Ingrese la direccion donde desea que lo visitemos para el mantenimiento");

        lblMaintenanceDescription.setText("Ingrese una descripción: ");

        txtMaintenanceDescription.setColumns(20);
        txtMaintenanceDescription.setRows(5);
        txtMaintenanceDescription.setToolTipText("Ingrese una breve descripcion del problema");
        jScrollPane2.setViewportView(txtMaintenanceDescription);

        lblSesionNumber.setText("Numero de Sesion:");

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
                        .addGap(63, 63, 63)
                        .addComponent(txtMaintenanceDate))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaintenanceAddress)
                            .addComponent(lblMaintenanceDescription))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaintenanceAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaintenanceDate)
                    .addComponent(txtMaintenanceDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        txtReparationDate.setToolTipText("Ingrese la fecha que desea que lo visitemos ");

        lblReparationAddress.setText("Ingrese la dirección de la reparación: ");

        txtReparationAddress.setToolTipText("Ingrese la direccion de reparación");

        lblReparationDescription.setText("Ingrese una descripción de la reparación:");

        lblReparationPriority.setText("Es una reparación urgente: ");

        cbUrgencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        cbUrgencia.setToolTipText("Considera usted que es de suma urgencia la reparacion?");

        txtReparationDescription.setColumns(20);
        txtReparationDescription.setRows(5);
        jScrollPane4.setViewportView(txtReparationDescription);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtReparationDate, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(txtReparationAddress)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblReparationDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReparationDate)
                    .addComponent(txtReparationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSave)
                                    .addComponent(btnNewOrder)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(46, 46, 46)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        int index = cmbType.getSelectedIndex();
        if (index==0){
            lblReparationAddress.setVisible(true);
            lblReparationDate.setVisible(true);
            lblReparationDescription.setVisible(true);
            lblReparationPriority.setVisible(true);
            txtReparationAddress.setVisible(true);
            txtReparationDate.setVisible(true);
            txtReparationDescription.setVisible(true);
            cbUrgencia.setVisible(true);
            jScrollPane4.setVisible(true);
            
            
            lblMaintenanceAddress.setVisible(false);
            lblMaintenanceDate.setVisible(false);
            lblMaintenanceDescription.setVisible(false);
            lblSesionNumber.setVisible(false);
            txtMaintenanceAddress.setVisible(false);
            txtMaintenanceDate.setVisible(false);
            txtMaintenanceDescription.setVisible(false);
            txtSesionNumber.setVisible(false);
            jScrollPane2.setVisible(false);
   
        }
        else if(index==1) {
            lblMaintenanceAddress.setVisible(true);
            lblMaintenanceDate.setVisible(true);
            lblMaintenanceDescription.setVisible(true);
            lblSesionNumber.setVisible(true);
            txtMaintenanceAddress.setVisible(true);
            txtMaintenanceDate.setVisible(true);
            txtMaintenanceDescription.setVisible(true);
            txtSesionNumber.setVisible(true);
            jScrollPane2.setVisible(true);
            
            
            lblReparationAddress.setVisible(false);
            lblReparationDate.setVisible(false);
            lblReparationDescription.setVisible(false);
            lblReparationPriority.setVisible(false);
            txtReparationAddress.setVisible(false);
            txtReparationDate.setVisible(false);
            txtReparationDescription.setVisible(false);
            cbUrgencia.setVisible(false);
            jScrollPane4.setVisible(false);
            
        }
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char validate=evt.getKeyChar();

        if(validate >=97 && validate<=122  ){
          
        }
            else{
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        char validate=evt.getKeyChar();

    if(validate >=48 && validate<=57){
     
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

           if(validate >=48 && validate<=57){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        LOG.warning("Values entered incorrect");  
    }
    }//GEN-LAST:event_txtPhoneNumberKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        reserveOrder();
    }//GEN-LAST:event_btnSaveActionPerformed

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
    private javax.swing.JTextField txtMaintenanceDate;
    private javax.swing.JTextArea txtMaintenanceDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtReparationAddress;
    private javax.swing.JTextField txtReparationDate;
    private javax.swing.JTextArea txtReparationDescription;
    private javax.swing.JTextField txtSesionNumber;
    // End of variables declaration//GEN-END:variables
}
