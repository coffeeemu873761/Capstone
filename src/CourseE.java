import java.util.*;

public class CourseE {
    private String deptName;
    private String title;
    private int credits;
    private int maxStudents;
    private int currentStudents;

    private HashSet<StudentE> enrolledStudents;
    private LinkedList<StudentE> waitlist;
    private boolean full;

    public CourseE(String deptName, String title, int credits, int maxStudents) {
        this.deptName = deptName;
        this.title = title;
        this.credits = credits;
        this.maxStudents = maxStudents;
        this.currentStudents = 0;
        this.enrolledStudents = new HashSet<>();
        this.waitlist = new LinkedList<>();
        this.full = false;

    }

    @Override
    public String toString() {
        return (title);
    }

    public void addStudent(StudentE student) {
        if (currentStudents < maxStudents) {
            enrolledStudents.add(student); //adds student to course
            currentStudents++;
            System.out.println(student.firstName + " " + student.lastName + " has been enrolled in " + title);
        } else {
            waitlist.add(student);
            System.out.println(student.firstName + " " + student.lastName + " has been added to the waitlist for " + title);
        }
        if (currentStudents >= maxStudents) {
            full = true;
        } else {
            full = false;
        }
    }

    public void dropStudent(StudentE student) {
        if (enrolledStudents.contains(student)) {
            enrolledStudents.remove(student); //drops student from course
            currentStudents--;
            System.out.println(student.firstName + " " + student.lastName + " has been un-enrolled from " + title);
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
            System.out.println(student.firstName + " is not enrolled in this course");
        }
    }

    public int getCredits() {
        return credits;
    }

    public void getEnrolledStudents() {
        Iterator<StudentE> i = enrolledStudents.iterator();
        while (i.hasNext()) {
            StudentE v = i.next();
            System.out.print(v.firstName + " " + v.lastName + ", ");
        }
    }

    public void getWaitlist() {
        Iterator<StudentE> j = waitlist.iterator();
        while (j.hasNext()) {
            StudentE k = j.next();
            System.out.print(k.firstName + " " + k.lastName + ", ");
        }
    }

    public boolean isFull() {
        return full;
    }
}
