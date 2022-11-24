package com.example.final_project;

public class Logins {

    private int SSN;
    private String username;
    private String passowrd;
    private String firstName;
    private String lastName;
    private String middleName;
    private String passConfirmation;

    public Logins(int SSN, String username, String passowrd, String firstName, String lastName, String middleName, String passConfirmation) {
        this.SSN = SSN;
        this.username = username;
        this.passowrd = passowrd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.passConfirmation = passConfirmation;
    }

    public Logins() {

    }

    //    public Logins() {
//        this.SSN = SSN;
//        this.username = username;
//        this.passowrd = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.middleName = middleName;
//        this.passConfirmation = passConfirmation;
//    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassConfirmation() {
        return passConfirmation;
    }

    public void setPassConfirmation(String passConfirmation) {
        this.passConfirmation = passConfirmation;
    }

    @Override
    public String toString() {
        return "Logins{" +
                "SSN=" + SSN +
                ", username='" + username + '\'' +
                ", passowrd='" + passowrd + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", passConfirmation='" + passConfirmation + '\'' +
                '}';
    }
}
