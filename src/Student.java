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

    public int getId() {

        return this.id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void addCourse(Course course, Semester semester) {
        if (course.getSemester().equals(semester)) {
            enrolledCourses.add(course);
        }
    }

    public void dropCourse(Course course, Semester semester) {
        if (course.getSemester().equals(semester)) {
            enrolledCourses.remove(course);
        }
    }

    public List<Course> getEnrolledCourses() {

        return this.enrolledCourses;
    }

    public int getTotalCreditHours() {

        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {

        return getFirstName() + " " + getLastName();
    }

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getLastName() {
        return super.getLastName();
    }
}