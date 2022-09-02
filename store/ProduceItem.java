package store;

public class ProduceItem extends Item {
    private String expirationDate;
    private String foodType;
    private double weight;
    private boolean priceByWeight;

    public ProduceItem() {
        super();
        expirationDate = "";
        foodType = "";
        weight = 0.0;
        priceByWeight = false;
    }

    public ProduceItem(String name, int quantity, double price,
                       String expirationDate, String foodType, double weight, boolean priceByWeight) {
        super(name, quantity, price);
        this.expirationDate = expirationDate;
        this.foodType = foodType;
        this.weight = weight;
        this.priceByWeight = priceByWeight;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isPriceByWeight() {
        return priceByWeight;
    }

    public void setPriceByWeight(boolean priceByWeight) {
        this.priceByWeight = priceByWeight;
    }

    @Override
    public void printItem() {
        System.out.printf("%s: $%.2f | %s, %s, %flb | Quantity: %d\n",
                this.getName(), price, expirationDate, foodType, weight, this.getQuantity());
    }

    public double calcPrice() {
        if (priceByWeight == true)
        {
            price = price * weight;
        }

        return price;
    }
}