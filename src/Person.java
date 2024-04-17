public class Person implements Shopper {
    private String firstName;
    private String lastName;
    private int day;
    private int month;
    private int year;
    private GroceryList groceryList;
    private double discountRate = 0.0;


    public Person(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.day = day;
        this.month = month;
        this.year = year;
        groceryList = new GroceryList();
    }



    public Person() {
        this.firstName = "";
        this.lastName = "";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getDOE() {

        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public boolean startGroceryList(GroceryStore store) {
        this.groceryList = new GroceryList(store);
        return true;
    }

    public GroceryList getGroceryList() {
        return this.groceryList;
    }



    public double GetDiscount() {
        return this.discountRate;
    }


    public String toString() {
        return "Person: " + this.firstName + " " + this.lastName + ", " + this.getDOE();
    }

    public double getListPrice() {
        double totalPrice = 0.0;
        for (GroceryItemOrder itemOrder : groceryList.getItems()) {
            totalPrice += itemOrder.getQuantity() * groceryList.getStore().getItemPrice(itemOrder.getItem());
        }
        return totalPrice;
    }

    public void displayGroceryListTotal() {
        System.out.println("Items:");
        for (GroceryItemOrder itemOrder : groceryList.getItems()) {
            System.out.println(itemOrder.getItem().getName() + " - Quantity: " + itemOrder.getQuantity() +
                    ", Price per item: $" + groceryList.getStore().getItemPrice(itemOrder.getItem()) +
                    ", Total Price: $" + itemOrder.getQuantity() * groceryList.getStore().getItemPrice(itemOrder.getItem()));
        }
        double totalPriceBeforeDiscount = this.getListPrice();
        double totalPriceAfterDiscount = applyDiscount();
        System.out.println("Total Price before discount: $" + totalPriceBeforeDiscount);
        System.out.println("Total Price after discount: $" + totalPriceAfterDiscount);
    }

    private double applyDiscount() {
        double totalPrice = this.groceryList.getListPrice();
        totalPrice = totalPrice - this.GetDiscount() * totalPrice;
        return totalPrice;
    }

}

