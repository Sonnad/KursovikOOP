package operations;

import entities.Sim;
import structures.Hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Sonad on 22.04.17.
 */
public class Operations {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void simAdd(final Hash simBase)
    {
        String exit = "1";
        while (!exit.equals("0"))
        {
            try {
            exit = "1";
            System.out.print("Номер сим карты в формате NNN-NNNNNNN: ");
            String simNumber = reader.readLine();
            if (simBase.searchBySimNumber(simNumber)) {
                System.out.println("\nОШИБКА!! СИМ КАРТА С ДАННЫМ НОМЕРОМ УЖЕ СУЩЕСТВУЕТ\n");
                continue;
            }
            System.out.print("Название тарифа: ");
            String tariff = reader.readLine();
            System.out.print("Год выпуска: ");
            int yearOfIssue = Integer.parseInt(reader.readLine());
            simBase.addElement(new Sim(simNumber, tariff, yearOfIssue));
            System.out.print("Нажмите 0 для продолжения ввода данных иди любую клавишу для возврата в преыдущее меню. ");
                exit = reader.readLine();
            } catch (Exception e) {}
            System.out.println("\n\n\n");
        }
    }

    public static void simRemove(final Hash simBase)
    {
        String exit = "1";
        while (!exit.equals("0"))
        {
            try {
                exit = "1";
                System.out.print("Номер сим карты в формате NNN-NNNNNNN: ");
                String simNumber = reader.readLine();
                 if (simBase.removeElement(simNumber)) System.out.println("Сим карта успешно удалена");
                 else System.out.println("Сим карта с указанным номером не найдена");
                System.out.print("Нажмите 0 для продолжения удаления данных иди любую клавишу для возврата в преыдущее меню. ");
                exit = reader.readLine();
            } catch (Exception e) {}
            System.out.println("\n\n\n");
        }
    }

}

