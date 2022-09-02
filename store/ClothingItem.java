package store;

public class ClothingItem extends Item {
    private String size;
    private String materials;
    private String brand;

    public ClothingItem(String name, int quantity, double price, String size, String materials, String brand) {
        super(name, quantity, price);
        this.size = size;
        this.materials = materials;
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void printItem() {
        System.out.printf("%s: $%.2f | %s, %s, %s | Quantity: %d\n",
                this.getName(), price, size, materials, brand, this.getQuantity());
    }
}
