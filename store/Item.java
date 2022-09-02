package store;

public class Item {
        private String name;
        private int quantity;
        protected double price;

        public Item() {
                name = "";
                quantity = 0;
                price = 0;
        }
        public Item(String name, int quantity, double price) {
                this.name = name;
                this.quantity = quantity;
                this.price = price;
        }
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }
        public void printItem() {
                System.out.printf("%s: $%.2f | Quantity: %d/n", name, price, quantity);
        }
        public void discountBy(double percent) {
                if (percent < 1 && percent > 0)
                {
                        price = price * (1-percent);
                }
                else {
                     throw new Error("Discount should be in between 0% and 100 %");
                }
        }



}
