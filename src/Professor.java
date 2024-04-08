public class Professor extends Person {

    private String department;
    private String officeNumber;

    public Professor(String firstname, String lastname, String department, String officeNumber, int day, int month, int year) {
        super(firstname, lastname, day, month, year);
        this.department = department;
        this.officeNumber = officeNumber;
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

    public String toString() {
        return "Professor: " + this.getFirstName() + " " + this.getLastName() + ", " + this.getDepartment()
                + ", " + this.getOfficeNumber() + "," + this.getDOE();
    }


}