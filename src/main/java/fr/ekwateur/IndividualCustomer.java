package fr.ekwateur;

public class IndividualCustomer extends Customer {
    private String title;
    private String lastName;
    private String firstName;

    public IndividualCustomer(final String reference, final String title, final String lastName, final String firstName) {
        super(reference);
        this.title = title;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
}
