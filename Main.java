/**
 * Created by Sonad on 03.03.16.
 */

import entities.Client;
import entities.Sim;
import structures.*;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Hash simBase = new Hash();
//        for (int i = 0; i < 300 ; i++) {
//            simBase.addElement(new Sim(Hash.keyGeneration(), "Тариф" + i, i, true));
//        }
        int count = 0;
        simBase.addElement(new Sim("123456789", "black", 2014, true));
        simBase.addElement(new Sim("123456389", "black", 2014, true));
        simBase.addElement(new Sim("133456789", "black", 2014, true));
        simBase.addElement(new Sim("153456389", "black", 2014, true));
        simBase.addElement(new Sim("123456729", "black", 2014, true));
        simBase.removeElement("153456389");
        for (int i = 0; i < simBase.getHashTableLength(); i++) {
            System.out.println(" [" + i + "]  " + simBase.getHashTable()[i]);
            if (simBase.getHashTable()[i] != null) count++;
        }
        System.out.println(count);
    }

}
