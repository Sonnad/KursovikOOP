package entities;

/**
 * Created by Sonad on 07.03.17.
 */
public class Client {
    private String passportNumber;
    private String dateOfIssue;
    private String fullName;
    private int yearOfBirth;
    private String address;

    public Client(String passportNumber, String dateOfIssue, String fullName, int yearOfBirth, String address) {
        this.passportNumber = passportNumber;
        this.dateOfIssue = dateOfIssue;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
