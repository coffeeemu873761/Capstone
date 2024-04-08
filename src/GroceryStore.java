import java.util.HashMap;
import java.util.Map;

public class GroceryStore {
    private String name;
    private Map<GroceryItem, Double> Items;

    public GroceryStore(String name) {
        this.name = name;
        this.Items = new HashMap<>();
    }


    public void stockItem(GroceryItem GroceryItem, double price) {
        Items.put(GroceryItem, price);
    }

    public double getItemPrice(GroceryItem GroceryItem) {
        return Items.getOrDefault(GroceryItem, 0.0);
    }
}
