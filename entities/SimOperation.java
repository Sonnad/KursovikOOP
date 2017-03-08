package entities;

/**
 * Created by Sonad on 08.03.17.
 */
public class SimOperation {
    private String passportNumber;
    private String simNumber;
    private String dateOfIssue;
    private String dateOfDeath;

    public SimOperation(String passportNumber, String simNumber, String dateOfIssue, String dateOfDeath) {
        this.passportNumber = passportNumber;
        this.simNumber = simNumber;
        this.dateOfIssue = dateOfIssue;
        this.dateOfDeath = dateOfDeath;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}

