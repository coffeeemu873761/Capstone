import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        GroceryItem GroceryItem1 = null;
        for (GroceryItem Item : this.getGroceryItems()) {
            if (Item.getName().equals(GroceryItem.getName())) {
                GroceryItem1= Item;
            }
        }
        return Items.getOrDefault(GroceryItem1, 0.0);
    }

    public String getName() {
        return this.name;
    }

    public Map<GroceryItem, Double> getItems() {
        return this.Items;
    }

    public List<GroceryItem> getGroceryItems() {
        List<GroceryItem> groceryItems = new ArrayList<>();
        for (GroceryItem item : Items.keySet()) {
            groceryItems.add(item);
        }
        return groceryItems;
    }

    public List<String> getGroceryItemsName() {
        List<String> groceryItemsName = new ArrayList<>();
        for (GroceryItem item : this.getGroceryItems()) {
            groceryItemsName.add(item.getName());
        }
        return groceryItemsName;
    }

    public void printItemsAndPrices() {
        System.out.println("Items available in " + this.name + ":");
        for (Map.Entry<GroceryItem, Double> entry : Items.entrySet()) {
            GroceryItem item = entry.getKey();
            double price = entry.getValue();
            System.out.println(item.getName() + " - $" + price);
        }
    }

}
