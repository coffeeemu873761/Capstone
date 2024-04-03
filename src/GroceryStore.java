import java.util.HashMap;
import java.util.Map;

public class GroceryStore {

    private String storeName;
    private String location;
    private Map<GroceryItemOrder, Double> stocks;

    public GroceryStore(String storeName, String location) {
        this.storeName = storeName;
        this.location = location;
        stocks = new HashMap<>();
    }

    public void addStock(GroceryItemOrder groceryItemOrder, double price) {

        stocks.put(groceryItemOrder, price);
    }

    public String getStoreName() {

        return this.storeName;
    }

    public String getLocation() {

        return this.location;
    }

    public void setStoreName(String storeName) {

        this.storeName = storeName;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public Map<GroceryItemOrder, Double> getStocks() {

        return this.stocks;
    }


}