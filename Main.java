/**
 * Created by Sonad on 03.03.16.
 */

import operations.Operations;
import structures.*;

import java.io.BufferedReader;
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
                                        "2 - Удалить сим карту\n" +
                                        "3 - Вывести базу сим карт на экран\n" +
                                        "4 - Очистить базу сим карт\n" +
                                        "5 - Найти сим карту по тарифу\n"
                        );
                        System.out.print("Ваш выбор: ");
                        choice = Integer.parseInt(reader.readLine());
                        switch (choice)
                        {
                            case 1:
                                Operations.simAdd(simBase);
                                break;
                            case 2:
                                Operations.simRemove(simBase);
                                break;
                            case 3:
                                simBase.printSimBase();
                                System.in.read();
                                break;
                            case 4:
                                simBase.clear();
                                break;
                            case 5:
                                Operations.searchSimByTariff(simBase);
                                System.in.read();
                                break;
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
