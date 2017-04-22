package operations;

import Exeptions.InvalidSimNumberLengthExeption;
import Exeptions.SimNumberException;
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
                System.out.print("\nНомер сим карты в формате NNN-NNNNNNN: ");
                String simNumber = reader.readLine();
                Validation.simNumberValidation(simNumber);
                if (simBase.searchBySimNumber(simNumber) != null) {
                    System.out.println("\nОШИБКА!! СИМ КАРТА С ДАННЫМ НОМЕРОМ УЖЕ СУЩЕСТВУЕТ\n");
                    continue;
                }
                System.out.print("Название тарифа: ");
                String tariff = reader.readLine();
                System.out.print("Год выпуска: ");
                int yearOfIssue = Integer.parseInt(reader.readLine());
                simBase.addElement(new Sim(simNumber, tariff.toLowerCase(), yearOfIssue));
                System.out.print("\nНажмите 0 для возврата в предыдущее меню или любую клавишу для продолжения ввода данных. ");
                exit = reader.readLine();
            } catch (SimNumberException e){
                System.out.print("\nОшибка!");
                System.out.println(e instanceof InvalidSimNumberLengthExeption ? " Некорректная длина номера сим карты!" : " В номере сим карты использованы некорректые символы. Допускается использование цифр от 0 до 9");
            } catch (NumberFormatException e) {
                System.out.println("\nОшибка ввода! Год выдачи введен некорректно!\n");
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println();
        }
    }

    public static void simRemove(final Hash simBase)
    {
        String exit = "1";
        while (!exit.equals("0"))
        {
            try {
                exit = "1";
                System.out.print("\nНомер сим карты в формате NNN-NNNNNNN: ");
                String simNumber = reader.readLine();
                Validation.simNumberValidation(simNumber);
                 if (simBase.removeElement(simNumber)) System.out.println("Сим карта успешно удалена");
                 else System.out.println("\nСим карта с указанным номером не найдена");
                System.out.print("\nНажмите 0 для возврата в предыдущее меню или любую клавишу для продолжения удаления данных. ");
                exit = reader.readLine();
            } catch (SimNumberException e){
                System.out.print("\nОшибка!");
                System.out.println(e instanceof InvalidSimNumberLengthExeption ? " Некорректная длина номера сим карты!" : " В номере сим карты использованы некорректые символы. Допускается использование цифр от 0 до 9");
            } catch (Exception e) {}
            System.out.println();
        }
    }

    public static void searchSimByTariff(final Hash simBase)
    {
        String exit = "1";
        while (!exit.equals("0"))
        {
            try {
                exit = "1";
                System.out.print("\nНазвание тарифа: ");
                String tariff = reader.readLine();
                simBase.searchByTariff(tariff);
                System.out.print("\nНажмите 0 для возврата в предыдущее меню или любую клавишу для продолжения поиска. ");
                exit = reader.readLine();
            } catch (Exception e) {}
            System.out.println();
        }
    }

}

