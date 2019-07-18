package ec.edu.espe.schweitzer_revision.model;

/**
 *
 * @author Jhony Naranjo
 */
public class SparePart {
    private String name;
    private Float price;
    private int stock;

    private static SparePart sparepart;
    
   

    public static SparePart getSparePart( String name, Float price, int stock){
        if(sparepart==null){
            sparepart = new SparePart(name, price, stock);
        }
        return sparepart;
    }
    
     private SparePart(String name, Float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "Nombre -->" + name + ", Precio -->" + price + ", Stock -->" + stock;
    }
    
    
}
