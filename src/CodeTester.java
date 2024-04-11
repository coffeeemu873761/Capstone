public class CodeTester {

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



}
