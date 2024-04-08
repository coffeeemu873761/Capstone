public class Graduate extends Student {

    private double discountRate = 0.15;

    public Graduate(String firstName, String lastName, int id, int day, int month, int year) {
        super(firstName, lastName, id, day, month, year);
    }

    @Override
    public void displayTotalCost() {
        super.displayTotalCost();
        GroceryList list = getGroceryList();
        double total = list.getTotalCost();
        total = total * (1 - discountRate);
        System.out.println("The total cost after discount is: " + total);
        //getGroceryList().finalList();
    }

    public String toString() {
        return "Graduate Student: " + this.getFirstName() + " " + this.getLastName() + ", " + this.getId() + ", " + this.getDOE();
    }
}
