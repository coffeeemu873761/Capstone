import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int id;
    private List<Course> enrolledCourses;

    public Student(String firstName, String lastName, int id, int day, int month, int year) {
        super(firstName, lastName, day, month, year);
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    public Student(String firstName, String lastName, int id) {
        super(firstName, lastName);
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    public Student(String firstName, String lastName, int id) {

    }

    public Student(String firstName, String lastName) {
    }

    public Student(String firstName, String lastName, int id, int day, int month, int year) {
    }

    public int getId() {

        return this.id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void addCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
        }
    }

    public void dropCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
            course.removeStudent(this);
        }
    }

    public List<Course> getEnrolledCourses() {

        return new ArrayList<>(enrolledCourses);
    }

    public int getTotalCreditHours() {
        int total = 0;
        for (Course course : enrolledCourses) {
            total += course.getCredits();
        }
        return total;
    }


    @Override
    public String toString() {
        return getLastName(); // Just returning last name doesn't seem appropriate. You might want to adjust this.
    }

    // Method to get the full name of the student
    public String getName() {

        return getFirstName() + " " + getLastName();
    }
}