import java.util.*;
public class Semester {
    private String name;
    private List<Course> courses;

    public Semester(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    public String getName() {
        return this.name;
    }
}