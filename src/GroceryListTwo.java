public class GroceryListTwo {
    private GroceryItemOrder[] list; // array to store grocery items
    private int num; // number of items in the list
    private static boolean isNewListMade = false; // catch and track if the list is created

    // constructor method to create a new grocery list
    // initializes the array to hold up to 7 items
    public GroceryListTwo() {
        if (!isNewListMade) {
            System.out.println("Creating a new list");
            isNewListMade = true;
        }

        list = new GroceryItemOrder[7];
        num = 0; // initially, there are 0 items in the list
    }

    // Method to add an item to the list
    // Adds a grocery item to the list.
    // item - grocery item to be added
    // Precondition: List must have fewer than 7 items.
    // Postcondition: Item is added to the list if the precondition is met.
    public void add(GroceryItemOrder item) {
        if (num < 7) { // check if the list has fewer than 7 items
            list[num] = item; // add item to current index in array
            num += 1; // increment number of items in list
            System.out.println("Adding " + item.getQuantity() + " " + item.getItem() + " to the list");
        } else {
            // print an error message if list is full
            System.out.println("Cannot add " + item.getQuantity() + " " + item.getItem() + " to the list. Max limit of the list has been reached");
        }
    }

    // method to calculate total cost of all items in list
    public double getTotalCost() {
        double cost = 0.00; // Initialize the total cost to 0
        for (int i = 0; i < num; i++) { // Loop through each item in the list
            cost += list[i].getCost(); // Add the cost of the item to the total cost
        }
        return cost; // Return the total cost
    }

    // method to create final list representation as string
    public String finalList() {
        // initialize result string with a starting message
        String result = "The price of ";

        // iterate through each item in list
        for (int i = 0; i < num; i++) {
            // Concatenate the amount, item name, and a space to the result string
            result = result + list[i].getQuantity() + " " + list[i].getItem() + " ";
        }

        // concatenate final cost message to result string
        result = result + "is $" + getTotalCost();

        // print final result
        System.out.println(result);

        // return final result string
        return result;
    }
}