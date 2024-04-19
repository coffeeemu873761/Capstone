public class Undergrad extends Student {

    private double discountRate = 0.10;

    private Level level;

    public Undergrad(String firstName, String lastName, int id, int day, int month, int year, Level level) {
        super(firstName, lastName, id, day, month, year);
        this.level = level;
    }

    public Undergrad(String firstName, String lastName, int id, int day, int month, int year) {
        super(firstName, lastName, id, day, month, year);
    }

    public Undergrad(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    public enum Level {
        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR
    }

    public String toString() {
        return "Undergrad Student: " + this.getFirstName() + " " + this.getLastName() + ", " + this.getId() + ", " + this.getDOE();
    }

    public double GetDiscount() {
        return this.discountRate;
    }
}