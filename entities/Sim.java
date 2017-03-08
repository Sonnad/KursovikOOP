package entities;

/**
 * Created by Sonad on 08.03.17.
 */
public class Sim {
    private String simNumber;
    private String tariff;
    private int yearOfIssue;
    private boolean shit;

    public Sim(String simNumber, String tariff, int yearOfIssue, boolean shit) {
        this.simNumber = simNumber;
        this.tariff = tariff;
        this.yearOfIssue = yearOfIssue;
        this.shit = shit;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public boolean isShit() {
        return shit;
    }

    public void setShit(boolean shit) {
        this.shit = shit;
    }
}
