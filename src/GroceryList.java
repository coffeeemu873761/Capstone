import java.util.ArrayList;

public class GroceryList {
    private ArrayList<GroceryItemOrder> items;

    private GroceryStore store;

    public GroceryList(GroceryStore store) {
        this.store = store;
        this.items = new ArrayList<>();
    }

    public void addItemOrder(GroceryItemOrder itemOrder) {
        items.add(itemOrder);
    }

    public ArrayList<GroceryItemOrder> getItems() {
        return items;
    }

    public GroceryStore getStore() {
        return store;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (GroceryItemOrder itemOrder : items) {
            totalPrice += itemOrder.getQuantity() * store.getItemPrice(itemOrder.getItem());
        }
        return totalPrice;
    }


    private static void displayGroceryListTotal() {
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
}
