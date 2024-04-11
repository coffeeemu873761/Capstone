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

    public ArrayList<GroceryItemOrder> getItems() {
        return items;
    }

    public GroceryStore getStore() {
        return store;
    }





}
