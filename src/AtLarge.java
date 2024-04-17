public class AtLarge extends Student {

    public AtLarge(String firstName, String lastName, int id, int day, int month, int year) {
        super(firstName, lastName, id, day, month, year);
    }

    public AtLarge(String firstName, String lastName) {
        super(firstName,lastName);
    }

    public String toString() {
        return "AtLarge: " + this.getFirstName() + " " + this.getLastName() + ", " + this.getId() + ", " + this.getDOE();
    }
}
