/**
 * Created by Sonad on 03.03.16.
 */

import entities.Client;
import structures.*;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //ТЕСТ ДЕРЕВА
        /*
        Node node = new Node(new Client("6", "22.01.2014", " 6 6 6 ", 1994, "test1"));
        node.addElement(new Client("3", "22.01.2014", " 3 3 3 ", 1994, "test1"));
        node.addElement(new Client("2", "22.01.2014", " 2 2 2 ", 1994, "test1"));
        node.addElement(new Client("4", "22.01.2014", " 4 4 4 ", 1994, "test1"));
        node.addElement(new Client("7", "22.01.2014", " 7 7 7 ", 1994, "test1"));
        node.addElement(new Client("8", "22.01.2014", " 8 8 8 ", 1994, "test1"));
        node.addElement(new Client("9", "22.01.2014", " 9 9 9 ", 1994, "test1"));

        System.out.println("===============");
        node.printTree(node.getRoot());
        node.removeElement("3");
        node.removeElement("6");
        node.removeElement("4");
        node.removeElement("7");
        node.removeElement("2");
        node.removeElement("8");
        node.removeElement("9");

        System.out.println("===============");
        System.out.println("===============");
        System.out.println("===============");
        node.printTree(node.getRoot());
        System.out.println("===============");
        System.out.println("===============");
        System.out.println("===============");
        node.removeElement("6");
        node.printTree(node.getRoot());
        */
        String Str = new String("9999999999");
        System.out.println("Мой Хэш-код для Str: " + Hash.hash1(Str));
        for (int i = 0; i < Hash.table.length*3; i++) {
            Hash.table[Hash.hash1(Hash.keyGeneration())]++;
            Hash.table2[Hash.hash2(Hash.keyGeneration())]++;
        }

        try(FileWriter writer = new FileWriter("/Users/jura/Desktop/test.txt", false))
        {
            String testHash = "";
            for (int i = 0; i < Hash.table.length; i++) {
                testHash += Hash.table[i] + "\n";
            }
            writer.write(testHash);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter("/Users/jura/Desktop/test2.txt", false))
        {
            String testHash = "";
            for (int i = 0; i < Hash.table2.length; i++) {
                testHash += Hash.table2[i] + "\n";
            }
            writer.write(testHash);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

}
