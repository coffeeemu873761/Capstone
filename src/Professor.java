import java.util.*;
public class Professor extends Person {

    private String department;
    private String officeNumber;
    private List<Course> courses;


    public Professor(String firstname, String lastname, String department, String officeNumber, int day, int month, int year) {
        super(firstname, lastname, day, month, year);
        this.department = department;
        this.officeNumber = officeNumber;
        this.courses = new ArrayList<>();
    }

    public Professor(String firstName, String lastName, String department, String officeNumber) {
        super(firstName, lastName);
        this.department = department;
        this.officeNumber = officeNumber;
        this.courses = new ArrayList<>();
    }

    public String getDepartment() {
        return this.department;
    }

    public String getOfficeNumber() {
        return this.officeNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public List<Course> getCoursesForSemester(Semester semester) {
        List<Course> coursesForSemester = new ArrayList<>();
        for (Course course : courses) {
            if (course.getSemester().equals(semester)) {
                coursesForSemester.add(course);
            }
        }
        coursesForSemester.sort(Comparator.comparing(Course::getTitle));
        return coursesForSemester;
    }

    public String toString() {
        return "Professor: " + this.getFirstName() + " " + this.getLastName() + ", " + this.getDepartment()
                + ", " + this.getOfficeNumber() + "," + this.getDOE();
    }


}