import java.util.*;

public class Course{
    private String deptName;
    private String title;
    private int credits;
    private int maxStudents;
    private int currentStudents;
    private Professor professor;
    private Semester semester;
    private HashSet<Student> enrolledStudents;
    private LinkedList<Student> waitlist;
    private boolean full;

    public Course(String deptName, String title, int credits, int maxStudents) {
        this.deptName = deptName;
        this.title = title;
        this.credits = credits;
        this.maxStudents = maxStudents;
        this.currentStudents = 0;
        this.enrolledStudents = new HashSet<Student>();
        this.waitlist = new LinkedList<Student>();
        this.full = false;
    }

    @Override
    public String toString() {
        return (title);
    }

    public void addStudent(Student student, Semester semester) {
        if (currentStudents < maxStudents) {
            if (this.semester.equals(semester)) {
                enrolledStudents.add(student);
                currentStudents++;
                System.out.println(student.getFirstName() + " " + student.getLastName() + " has been enrolled in " + title);
            } else {
                System.out.println("This course is not available this semester");
                return;
            }
        } else {
            waitlist.add(student);
            System.out.println(student.getFirstName() + " " + student.getLastName() + " has been added to the waitlist for " + title);
        }
        if (currentStudents >= maxStudents) {
            full = true;
        } else {
            full = false;
        }
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public void dropStudent(Student student) {
        if (enrolledStudents.contains((Object)student)) {
            if (this.semester.equals(semester)) {
                enrolledStudents.remove(student);
                currentStudents--;
                System.out.println(student.getFirstName() + " " + student.getLastName() + " has been un-enrolled from " + title);
            }
            if (!waitlist.isEmpty()) {
                addStudent(waitlist.getFirst(), this.semester);
                waitlist.removeFirst();
            }
            if (currentStudents >= maxStudents) {
                full = true;
            } else {
                full = false;
            }
        } else {
            System.out.println(student.getFirstName() + " is not enrolled in this course");
        }
    }

    public int getCredits() {
        return credits;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Student> getWaitlist() {
        return waitlist;
    }

    public Semester getSemester() {
        return this.semester;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isFull() {
        return full;
    }

    // Edited getters
    public Professor getProfessor() {
        return professor;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public int getCurrentStudents() {
        return currentStudents;
    }
}