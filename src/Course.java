import java.util.*;

public class Course{
    private String deptName;
    private String title;
    private int credits;
    private int maxStudents;
    private int currentStudents;

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

    public void addStudent(Student student) {
        if (currentStudents < maxStudents) {
            enrolledStudents.add(student); //adds student to course
            currentStudents++;
            System.out.println(student.getFirstName() + " " + student.getLastName() + " has been enrolled in " + title);
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

    public void dropStudent(Student student) {
        if (enrolledStudents.contains((Object)student)) {
            enrolledStudents.remove((Object)student); //drops student from course
            currentStudents--;
            System.out.println(student.getFirstName() + " " + student.getLastName() + " has been un-enrolled from " + title);
            if (!waitlist.isEmpty()) {
                addStudent(waitlist.getFirst());
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

    public void getEnrolledStudents() {
        Iterator<Student> i = enrolledStudents.iterator();
        while (i.hasNext()) {
            Student v = i.next();
            System.out.print(v.getFirstName() + " " + v.getLastName() + ", ");
        }
    }

    public void getWaitlist() {
        Iterator<Student> j = waitlist.iterator();
        while (j.hasNext()) {
            Student k = j.next();
            System.out.print(k.getFirstName() + " " + k.getLastName() + ", ");
        }
    }

    public boolean isFull() {
        return full;
    }
}