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
}
