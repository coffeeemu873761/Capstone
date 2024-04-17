import java.util.ArrayList;

public class GroceryList {
    private ArrayList<GroceryItemOrder> items;

    private GroceryStore store;

    public GroceryList(GroceryStore store) {
        this.store = store;
        this.items = new ArrayList<>();
    }

    public GroceryList() {
    }

    public void addItemOrder(GroceryItemOrder itemOrder) {
        items.add(itemOrder);
    }

    public double getListPrice() {
        double totalPrice = 0.0;
        for (GroceryItemOrder itemOrder : items) {
            totalPrice += itemOrder.getQuantity() * store.getItemPrice(itemOrder.getItem());
        }
        return totalPrice;
    }

    public ArrayList<GroceryItemOrder> getItems() {
        return items;
    }

    public GroceryStore getStore() {
        return store;
    }





}
