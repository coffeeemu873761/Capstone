public class Graduate extends Student {

    private double discountRate = 0.15;

    public Graduate(String firstName, String lastName, int id, int day, int month, int year) {
        super(firstName, lastName, id, day, month, year);
    }

    public Graduate(String firstName, String lastName, int id) {
        super(firstName,lastName,id);
    }


    public String toString() {
        return "Graduate Student: " + this.getFirstName() + " " + this.getLastName() + ", " + this.getId() + ", " + this.getDOE();
    }
}
