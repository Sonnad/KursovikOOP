/**
 * Created by Sonad on 03.03.16.
 */

import entities.Client;
import entities.Sim;
import structures.*;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Hash simBase = new Hash();

        System.out.println("\t\t\t\t\t\t\t\t\t\t\tМЕНЮ");
        while (true)
        {
            System.out.println("\t\tНажмите соответствующую клавишу на клавиатуре для выбора нужного пункта меню.\n");
            System.out.println(
                    "1 - Работа с симкартами \n" +
                    "2 - Работа с клиентами\n" +
                    "3 - Выход\n"
            );
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Ваш выбор: ");
                int choice = Integer.parseInt(reader.readLine());
                switch (choice)
                {
                    case 1: {
                        System.out.println(
                                        "1 - Добавить сим карту \n" +
                                        "2 - Работа с клиентами\n" +
                                        "3 - Вернуться в предыдущее меню\n"
                        );
                        System.out.print("Ваш выбор: ");
                        choice = Integer.parseInt(reader.readLine());
                        switch (choice)
                        {
                            case 1: {
                                boolean exit = false;
                                while (!exit)
                                {
                                    System.out.println("Номер сим карты в формате NNN-NNNNNNN");
                                }
                            }
                        }
                        break;
                    }
                    case 2:
                        System.in.read();
                        break;
                    case 3:
                        return;
                }

            } catch(Exception e){};
        }
    }

}
