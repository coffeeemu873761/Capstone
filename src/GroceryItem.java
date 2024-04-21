public class GroceryItem {
    private String name;


    public GroceryItem(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if (o instanceof GroceryItem) {
            GroceryItem g = (GroceryItem) o;
            return this.name.equals(g.name);
        } else {
            return false;
        }

    }




}
