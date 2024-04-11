
import java.util.Scanner;
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


        public void GroceryListMaker() {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter your position in the university: ");
            String position = scanner.nextLine();
            if (position == "Professor") {
                System.out.print("Enter your department: ");
                String department = scanner.nextLine();
                System.out.print("Enter your office number: ");
                String officeNumber = scanner.nextLine();
                Professor professor = new Professor(firstName,lastName, department, officeNumber);
            } else if (position == "Student") {
                System.out.print("What part of the student body are you: ");
                String role = scanner.nextLine();
                if (role == "Undergrad") {
                    System.out.print("What is your id number: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("What level are you: ");
                    Undergrad.Level level = Undergrad.Level.valueOf(scanner.nextLine());
                    Undergrad undergrad = new Undergrad(firstName, lastName, id, level);
                } else if (role == "Graduate") {
                    System.out.print("What is your id number: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Graduate graduate = new Graduate(firstName,lastName, id);
                } else if (role == "AtLarge") {


                }


            }
            } else {
                System.out.println("No such position in the university");
            }

        }

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


        Davide.getGroceryList().addItemOrder(order1);
        Davide.getGroceryList().addItemOrder(order2);
        Davide.getGroceryList().addItemOrder(order3);
        Davide.getGroceryList().addItemOrder(order4);
        Angelo.getGroceryList().addItemOrder(order1);
        Angelo.getGroceryList().addItemOrder(order1);
        Angelo.getGroceryList().addItemOrder(order22);
        Angelo.getGroceryList().addItemOrder(order33);
        Angelo.getGroceryList().addItemOrder(order44);


        Davide.displayGroceryListTotal();
        Angelo.displayGroceryListTotal();
    }


}
