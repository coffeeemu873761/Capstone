import java.util.*;
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

        Professor professor1 = new Professor("John", "Doe", "Computer Science", "101");
        Professor professor2 = new Professor("Jane", "Doe", "Mathematics", "102");
        Professor professor3 = new Professor("Mark", "Smith", "Physics", "103");
        Professor professor4 = new Professor("Emma", "Johnson", "Biology", "104");

        // Create Semesters
        Semester semester1 = new Semester("Fall 2023");
        Semester semester2 = new Semester("Spring 2024");
        Semester semester3 = new Semester("Summer 2024");
        Semester semester4 = new Semester("Fall 2024");

        // Create Courses
        Course course1 = new Course("CS", "Computer Science 101", 3, 30);
        course1.setProfessor(professor1);
        course1.setSemester(semester1);

        Course course2 = new Course("MATH", "Mathematics 101", 3, 30);
        course2.setProfessor(professor2);
        course2.setSemester(semester2);

        Course course3 = new Course("PHYS", "Physics 101", 3, 30);
        course3.setProfessor(professor3);
        course3.setSemester(semester3);

        Course course4 = new Course("BIO", "Biology 101", 3, 30);
        course4.setProfessor(professor4);
        course4.setSemester(semester4);

        Personquestions(Marianos, WholeFoods);
        CourseQuestions(course1, course2, course3, course4);
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

    public static void CourseQuestions(Course course1, Course course2, Course course3, Course course4) {
        Scanner scanner = new Scanner(System.in);

        List<Course> courses = Arrays.asList(course1, course2, course3, course4);

        System.out.println("Here are the available courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getTitle());
        }

        System.out.print("Enter the number of the course you want to interact with: ");
        int courseNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        if (courseNumber < 1 || courseNumber > courses.size()) {
            System.out.println("Invalid course number");
            return;
        }

        Course course = courses.get(courseNumber - 1);

        System.out.println("What do you want to do with this course?");
        System.out.println("1. Print course details");
        System.out.println("2. Print enrolled students");
        System.out.println("3. Print waitlist");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        switch (choice) {
            case 1:
                printCourseDetails(course);
                break;
            case 2:
                printEnrolledStudents(course);
                break;
            case 3:
                printWaitlist(course);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    public static void printCourseDetails(Course course) {
        System.out.println("Course Title: " + course.getTitle());
        System.out.println("Professor: " + course.getProfessor().getFirstName() + " " + course.getProfessor().getLastName());
        System.out.println("Semester: " + course.getSemester().getName());
    }

    public static void printEnrolledStudents(Course course) {
        System.out.println("Enrolled Students in " + course.getTitle() + ": ");
        for (Student student : course.getEnrolledStudents()) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    public static void printWaitlist(Course course) {
        System.out.println("Waitlist for " + course.getTitle() + ": ");
        for (Student student : course.getWaitlist()) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
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
                    System.out.println("Answer unclear");
                }
            }
        }


        person.displayGroceryListTotal();
    }
    }







