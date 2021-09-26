package arrays;

public class Person {

    private int numGuest;         //Make global variable for numGuest

    private String firstName;     //Make global variable for firstName

    private String lastName;      //Make global variable for lastName

    public String cdNumber ;      //Make global variable for cdNumber

    public Person() {}

    public Person(int numGuest, String firstName, String lastName, String cdNumber) {        // Constructor person
        this.numGuest = numGuest;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cdNumber = cdNumber;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCdNumber() {
        return this.cdNumber;
    }

    public int getNumGuest() {
        return numGuest;
    }

    public void setNumGuest(int numGuest) {
        this.numGuest = numGuest;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCdNumber(String cdNumber) {
        this.cdNumber = cdNumber;
    }

}


