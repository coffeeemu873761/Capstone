public class GroceryItemOrderTwo {
    private String item; // Name of the grocery item
    private int quantity; // Quantity of the item being ordered
    private double pricePerUnit; // Price per unit of the item

    // Constructor to create a new grocery item order
    public GroceryItemOrderTwo(String item, int quantity, double pricePerUnit) {
        this.item = item;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    // Method to get the name of the grocery item
    public String getItem() {

        return item;
    }

    // Method to get the quantity of the grocery item
    public int getQuantity() {

        return quantity;
    }

    // Method to set the quantity of the grocery item
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    // Method to get the price per unit of the grocery item
    public double getPricePerUnit() {

        return pricePerUnit;
    }

    // Method to calculate and return the total cost of the grocery item
    public double getCost() {

        return quantity * pricePerUnit;
    }

    // Method to create a string representation of the grocery item
    public String toString() {

        return "[" + item + ", price: $" + pricePerUnit + ", amount: " + quantity + "]";
    }
}