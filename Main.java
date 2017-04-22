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
                                String exit = "1";
                                while (!exit.equals("0"))
                                {
                                    exit = "1";
                                    System.out.print("Номер сим карты в формате NNN-NNNNNNN: ");
                                    String simNumber = reader.readLine();
                                    if (simBase.searchBySimNumber(simNumber)) {
                                        System.out.println("ОШИБКА!! СИМ КАРТА С ДАННЫМ НОМЕРОМ УЖЕ СУЩЕСТВУЕТ");
                                        continue;
                                    }
                                    System.out.print("Название тарифа: ");
                                    String tariff = reader.readLine();
                                    System.out.print("Год выпуска: ");
                                    int yearOfIssue = Integer.parseInt(reader.readLine());
                                    simBase.addElement(new Sim(simNumber, tariff, yearOfIssue));
                                    System.out.print("Нажмите 0 для продолжения ввода данных иди любую клавишу для возврата в преыдущее меню. ");
                                    exit = reader.readLine();
                                    System.out.println("\n\n\n");

                                }
                            }
                        }
                        break;
                    }
                    case 2:
                        System.in.read();
                        break;
                    case 3:
                        int count = 0;
                        for (int i = 0; i < simBase.getHashTableLength(); i++) {
                            System.out.println(" [" + i + "]  " + simBase.getHashTable()[i]);
                            if (simBase.getHashTable()[i] != null) count++;
                        }
                        System.out.println(count);
                        return;
                }

            } catch(Exception e){};
        }
    }

}
