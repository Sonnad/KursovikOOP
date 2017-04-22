package entities;

/**
 * Created by Sonad on 08.03.17.
 */
public class Sim {
    private String simNumber;
    private String tariff;
    private int yearOfIssue;
    private boolean аvailability;

    public Sim(String simNumber, String tariff, int yearOfIssue) {
        this.simNumber = simNumber;
        this.tariff = tariff;
        this.yearOfIssue = yearOfIssue;
        this.аvailability = true;
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

    public boolean isАvailability() {
        return аvailability;
    }

    public void setАvailability(boolean аvailability) {
        this.аvailability = аvailability;
    }

    @Override
    public String toString()
    {
     return "Номер сим карты: " + simNumber + " Тариф: " + tariff + " Год выпуска: " + yearOfIssue + " Доступность: " + ((isАvailability()==true)? "Карта доступна": "Карта выдана");
    }
}
