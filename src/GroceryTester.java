
import java.util.Objects;
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


        Personquestions(Marianos, WholeFoods);


    }
    public static void Personquestions(GroceryStore store1, GroceryStore store2) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your position in the university: ");
        String position = scanner.nextLine();
        if (position.equals("Professor")) {
            System.out.print("Enter your department: ");
            String department = scanner.nextLine();
            System.out.print("Enter your office number: ");
            String officeNumber = scanner.nextLine();
            Professor person = new Professor(firstName, lastName, department, officeNumber);
            GroceryMaker(person, store1, store2);
        } else if (position.equals("Student")) {
            System.out.print("What part of the student body are you: ");
            String role = scanner.nextLine();
            if (role.equals("Undergrad")) {
                System.out.print("What is your id number: ");
                int id = Integer.parseInt(scanner.nextLine());
//                System.out.print("What level are you: ");
//                Undergrad.Level level = Undergrad.Level.valueOf(scanner.nextLine());
                Undergrad person = new Undergrad(firstName, lastName, id);
                GroceryMaker(person, store1, store2);
            } else if (role.equals("Graduate")) {
                System.out.print("What is your id number: ");
                int id = Integer.parseInt(scanner.nextLine());
                Graduate person = new Graduate(firstName, lastName, id);
                GroceryMaker(person, store1, store2);
            } else if (role.equals("AtLarge")) {
                AtLarge person = new AtLarge(firstName, lastName);
                GroceryMaker(person, store1, store2);
            } else {
                System.out.println("No such role in system");
            }
        } else {
            System.out.println("No such position in the university");
        }
    }



    public static void GroceryMaker(Person person, GroceryStore store1, GroceryStore store2) {
        boolean truth = true;
        GroceryStore Usedstore = store1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("What store do you want to shop at, " + store1.getName() + " or " + store2.getName() + " ? ");
        String store = scanner.nextLine();
        if (store.equals(store1.getName())) {
            person.startGroceryList(store1);
            store1.printItemsAndPrices();

        } else if (store.equals(store2.getName())) {
            person.startGroceryList(store2);
            store2.printItemsAndPrices();
            Usedstore = store2;

        } else {
            System.out.println("No such store");
            truth = false;
        }
        while (truth) {
            System.out.print("What do you want to buy? ");
            String item = scanner.nextLine();
            System.out.println("How much? ");
            int number = Integer.parseInt(scanner.nextLine());
            if (Usedstore.getGroceryItemsName().contains(item)) {
                GroceryItem GrItem = new GroceryItem(item);
                GroceryItemOrder order1 = new GroceryItemOrder(GrItem, number);
                person.getGroceryList().addItemOrder(order1);
            } else {
                System.out.println("No such item");
            }
            boolean truth1 = true;
            while (truth1) {
                System.out.print("Any more items? ");
                String answer = scanner.nextLine();
                if (Objects.equals(answer, "no")) {
                    truth = false;
                    truth1 = false;
                } else if (Objects.equals(answer, "yes")) {
                    truth1 = false;
                } else {
                    System.out.println("Answer unclear/no item in store");
                }
            }
        }


        person.displayGroceryListTotal();
    }
    }







