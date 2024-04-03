public class Person implements Shopper {
    private String firstName;
    private String lastName;
    private int day;
    private int month;
    private int year;
    private GroceryList groceryList;
    private GroceryStore groceryStore;

    public Person(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.day = day;
        this.month = month;
        this.year = year;
        groceryList = new GroceryList();
    }

    public void setGroceryStore(GroceryStore store) {
        this.groceryStore = store;
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

    @Override
    public void order(GroceryItemOrder item) {
        if (groceryStore.getStocks().containsKey(item)) {
            groceryList.add(item);
        } else {
            System.out.println("Item not available!");
        }
    }

    public GroceryList getGroceryList() {
        return this.groceryList;
    }

    @Override
    public void displayTotalCost() {
        getGroceryList().finalList();

    }

    public String toString() {
        return "Person: " + this.firstName + " " + this.lastName + ", " + this.getDOE();
    }
}

