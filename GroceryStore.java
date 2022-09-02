import store.*;

public class GroceryStore {
    public static void main(String[] args) {
        Item newObject = new Item(); // name= "", quantity = 0, price = 0
        Item shirt = new Item("shirt", 100, 20.0);

        shirt.discountBy(0.3);
        shirt.printItem();
    }

}
