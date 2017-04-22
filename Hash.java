package structures;

import entities.Sim;

import java.util.Arrays;

/**
 * Created by Sonad on 11.03.17.
 */
public class Hash {

    private Sim[] simBase;


    public Hash() {
        this.simBase = new Sim [500];
    }

    public static String keyGeneration()
    {
        String key = "";
        int a = 0; // Начальное значение диапазона - "от"
        int b = 10; // Конечное значение диапазона - "до"
        for (int i = 0; i < 10; i++) {
            key +=  a + (int) (Math.random() * b);
        }
       return key;
    }

    public int hash1(final String value) {
        int myHash1 = 0;
        String stringHash;
        for (int i = 0, stepen; i < value.length(); i++) {
            myHash1 += value.charAt(i) * Math.pow(3, i);
        }
        stringHash = Integer.toString(myHash1).substring(3,6);
        myHash1 = Integer.parseInt(stringHash);
            myHash1 = myHash1 % 500;
            return myHash1;
    }

    public int hash2(final String value) {
        int myHash2 = Math.abs(value.hashCode() % 500);
        if (myHash2 == 0) myHash2++;
        return myHash2;
    }


    public void addElement(final Sim sim)
    {
        int mainHash = hash1(sim.getSimNumber());
        int helpHash = hash2(sim.getSimNumber());
        int j = 0;
        int c = 1;
        while (simBase[mainHash] != null) {
            mainHash = (((mainHash + c * j) % simBase.length) + (helpHash + c * j) % simBase.length) % simBase.length;
            j++;
            if (j == 1000) {
                simBase = Arrays.copyOf(simBase, simBase.length * 2);
            }
        }
        simBase[mainHash] = sim;
    }

    public boolean removeElement(final String simNumber)
    {
        for (int i = 0; i < simBase.length; i++) {
            if (simBase[i] == null) continue;
            if (simBase[i].getSimNumber().equals(simNumber)) {
                simBase[i] = null;
                return true;
            }
        }
        return false;
    }

    public Sim searchBySimNumber(final String simNumber)
    {
        for (int i = 0; i < simBase.length; i++) {
            if (simBase[i] == null) continue;
            if (simBase[i].getSimNumber().equals(simNumber)) return simBase[i] ;
        }

        return null;
    }

    public void searchByTariff(final String tariff)
    {
        boolean isEmpty = true;
        for (int i = 0; i < simBase.length; i++) {
            if (simBase[i] == null) continue;
            if (simBase[i].getTariff().equals(tariff.toLowerCase())) {
                System.out.println(simBase[i]) ;
                isEmpty = false;
            }
        }

        if(isEmpty) System.out.println("\nСим карты с указанным тарифом не найдены");
    }

    public void clear()
    {
        for (int i = 0; i < simBase.length; i++) {
            simBase[i] = null;
        }
        System.out.println("\nОчистка бахы сим карт выполнена успешно\n");
    }

    public void printSimBase()
    {
        boolean isEmpty = true;
        for (int i = 0; i < simBase.length ; i++) {
            if (simBase[i] != null)
            {
                System.out.println(simBase[i]);
                isEmpty = false;
            }
        }

        if(isEmpty) System.out.println("\nБаза сим карт пуста.\n");
    }
}
