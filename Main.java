/**
 * Created by Sonad on 03.03.16.
 */

import entities.Client;
import structures.*;

public class Main {

    public static void main(String[] args) {

        Node node = new Node(new Client("6", "22.01.2014", " 6 6 6 ", 1994, "test1"));
        node.addElement(new Client("3", "22.01.2014", " 3 3 3 ", 1994, "test1"));
        node.addElement(new Client("2", "22.01.2014", " 2 2 2 ", 1994, "test1"));
        node.addElement(new Client("4", "22.01.2014", " 4 4 4 ", 1994, "test1"));
        node.addElement(new Client("7", "22.01.2014", " 7 7 7 ", 1994, "test1"));
        node.addElement(new Client("8", "22.01.2014", " 8 8 8 ", 1994, "test1"));
        node.addElement(new Client("9", "22.01.2014", " 9 9 9 ", 1994, "test1"));
//        node.addElement("1", "1");
//        node.addElement("0", "0");
        System.out.println("===============");
        node.printTree(node.getRoot());
        node.removeElement("2");
        node.removeElement("3");

        System.out.println("===============");
        System.out.println("===============");
        System.out.println("===============");
        node.printTree(node.getRoot());
        System.out.println("===============");
        System.out.println("===============");
        System.out.println("===============");
        node.removeElement("6");
        node.printTree(node.getRoot());

    }

}
