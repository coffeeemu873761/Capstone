public class GroceryTester {
    public static void main(String[] args) {
        // Create GroceryStores
        GroceryStore Marianos = new GroceryStore("Marianos");
        GroceryStore WholeFoods = new GroceryStore("WholeFoods");

        GroceryItem item1 = new GroceryItem("apple");
        GroceryItem item2 = new GroceryItem("banana");
        GroceryItem item3 = new GroceryItem("orange");
        GroceryItem item4 = new GroceryItem("bread");
        GroceryItem item5 = new GroceryItem("milk");
        GroceryItem item6 = new GroceryItem("avocado");
        GroceryItem item7 = new GroceryItem("bell pepper");


        Marianos.stockItem(item1, 1.5);
        Marianos.stockItem(item2, 0.75);
        Marianos.stockItem(item3, 1.0);
        Marianos.stockItem(item5, 1.5);
        Marianos.stockItem(item7, 1.5);
        WholeFoods.stockItem(item4, 2.0);
        WholeFoods.stockItem(item5, 1.75);
        WholeFoods.stockItem(item6, 2.25);
        WholeFoods.stockItem(item7, 1.25);
        WholeFoods.stockItem(item1, 1.25);
        WholeFoods.stockItem(item2, 1.75);


        Undergrad Davide = new Undergrad("Mazzucco", "Davide", 7628, 12, 3, 2002, Undergrad.Level.JUNIOR);
        Graduate Angelo = new Graduate("Mazzucco", "Angelo", 8756, 20, 11, 2000);

        Davide.startGroceryList(Marianos);
        Angelo.startGroceryList(WholeFoods);

        GroceryItemOrder order1 = new GroceryItemOrder(item1, 4);
        GroceryItemOrder order2 = new GroceryItemOrder(item3, 2);
        GroceryItemOrder order3 = new GroceryItemOrder(item5, 1);
        GroceryItemOrder order4 = new GroceryItemOrder(item7, 5);


        GroceryItemOrder order22 = new GroceryItemOrder(item6, 3);
        GroceryItemOrder order33 = new GroceryItemOrder(item4, 2);
        GroceryItemOrder order44 = new GroceryItemOrder(item2, 4);


        Davide.groceryList.addItemOrder(order1);
        Davide.groceryList.addItemOrder(order2);
        Davide.groceryList.addItemOrder(order3);
        Davide.groceryList.addItemOrder(order4);
        Angelo.groceryList.addItemOrder(order1);
        Angelo.groceryList.addItemOrder(order1);
        Angelo.groceryList.addItemOrder(order22);
        Angelo.groceryList.addItemOrder(order33);
        Angelo.groceryList.addItemOrder(order44);


        displayGroceryListTotal(Davide);
        displayGroceryListTotal(Angelo);
    }

    private static void displayGroceryListTotal(Person person) {
        System.out.println(person.getGivenName() + "'s grocery list:");
        System.out.println("Items:");
        for (GroceryItemOrder itemOrder : person.groceryList.getItems()) {
            System.out.println(itemOrder.getItem().getName() + " - Quantity: " + itemOrder.getQuantity() +
                    ", Price per item: $" + person.groceryList.getStore().getItemPrice(itemOrder.getItem()) +
                    ", Total Price: $" + itemOrder.getQuantity() * person.groceryList.getStore().getItemPrice(itemOrder.getItem()));
        }
        double totalPriceBeforeDiscount = person.groceryList.getTotalPrice();
        double totalPriceAfterDiscount = applyDiscount(person);
        System.out.println("Total Price before discount: $" + totalPriceBeforeDiscount);
        System.out.println("Total Price after discount: $" + totalPriceAfterDiscount);
    }

    private static double applyDiscount(Person person) {
        double totalPrice = person.groceryList.getTotalPrice();
        totalPrice = totalPrice - person.GetDiscount() * totalPrice;
        return totalPrice;
    }
}
