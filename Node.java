package structures;

import entities.Client;

/**
 * Created by Sonad on 01.03.17.
 */
public class Node {

    private Leaf root;

    public Node(final Client client) //Конструктор с параметрами
    {
        root = new Leaf(client);
    }


    public Client getElement(String key) //Получение значения по ключу
    {
        Leaf element = root;
        while (element != null) {
            if (Integer.parseInt(key) == Integer.parseInt(element.key)) {
                return element.client;
            }
            if (Integer.parseInt(key) < Integer.parseInt(element.key)) {
                element = element.left;
            } else {
                element = element.right;
            }
        }
        return null;
    }

    public void addElement(Client client) //Добавление элемента
    {
        String key = client.getPassportNumber();
        Leaf x = root, y = null;
        while (x != null) {
            if (Integer.parseInt(key) == Integer.parseInt(x.key)) {
                x.client = client;
                return;
            } else {
                y = x;
                if (Integer.parseInt(key) < Integer.parseInt(x.key)) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        Leaf newLeaf = new Leaf(client);
        if (y == null) {
            root = newLeaf;
        } else {
            if (Integer.parseInt(key) < Integer.parseInt(y.key)) {
                y.left = newLeaf;
            } else {
                y.right = newLeaf;
            }
        }

        root = balance(root);

    }


    public void removeElement(final String key) //Удаление элемента
    {
        Leaf x = root, y = null;
        while (x != null)
        {
            if (Integer.parseInt(key) == Integer.parseInt(x.key)) {
                break;
            } else {
                y = x;
                if (Integer.parseInt(key) < Integer.parseInt(x.key)) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        if (x == null) {
            return;
        }
        if (x.right == null) {
            if (y == null) {
                root = x.left;
            } else {
                if (x == y.left) {
                    y.left = x.left;
                } else {
                    y.right = x.left;
                }
            }
        } else {
            Leaf leftMost = x.right;
            y = null;
            while (leftMost.left != null) {
                y = leftMost;
                leftMost = leftMost.left;
            }
            if (y != null) {
                y.left = leftMost.right;
            } else {
                x.right = leftMost.right;
            }
            x.key = leftMost.key;
            x.client = leftMost.client;
        }

        if (root != null) root = balance(root);

    }

    public Leaf getRoot() //Геттер для корня
    {
        return root;
    }

    public void printTree(Leaf leaf)
    {
        if(leaf == null) {
            System.out.println("Дерево пустое");
            return;
        }
        System.out.println(leaf.client.getFullName());
        if (leaf.left != null) {
            System.out.println("Влево от " + leaf.key);
            printTree(leaf.left);
        }
        if (leaf.right != null)
        {
            System.out.println("Вправо от " + leaf.key);
            printTree(leaf.right);
        }
    }

    public class Leaf //Внутренний класс, хранящий непосредственно всю инфу
    {

        private String key;
        private Client client;
        public Leaf left, right;

        public Leaf(final Client client) {
            this.key = client.getPassportNumber();
            this.client = client;
        }


    }



    private Leaf rotateRight(Leaf leaf) // правый поворот
    {
        Leaf temporaryLeaf = leaf.left;
        leaf.left = temporaryLeaf.right;
        temporaryLeaf.right = leaf;
        return temporaryLeaf;
    }

    private Leaf rotateLeft(Leaf leaf) // левый поворот вокруг q
    {
        Leaf temporaryLeaf = leaf.right;
        leaf.right = temporaryLeaf.left;
        temporaryLeaf.left = leaf;
        return temporaryLeaf;
    }

    private Leaf balance(Leaf leaf) // балансировка узла
    {

        if (leaf.left != null) leaf.left = balance(leaf.left);
        if (leaf.right != null) leaf.right = balance(leaf.right);

        if( calculateBalance(leaf)==2 )
        {
            if( calculateBalance(leaf.right) < 0 )
                leaf.right = rotateRight(leaf.right);
            return rotateLeft(leaf);
        }
        if( calculateBalance(leaf)==-2 )
        {
            if( calculateBalance(leaf.left) > 0  )
                leaf.left = rotateLeft(leaf.left);
            return rotateRight(leaf);
        }
        return leaf;
    }

    private int calculateHeight(Leaf leaf) // Вычисление высоты узла
    {
        if (leaf == null)
            return 0;
        int leftLeaf, rightLeaf;
        if (leaf.left != null)
            leftLeaf = calculateHeight(leaf.left);
        else leftLeaf = 0;
        if (leaf.right != null)
            rightLeaf = calculateHeight(leaf.right);
        else rightLeaf = 0;
        int max = leftLeaf > rightLeaf ? leftLeaf : rightLeaf;
        return max + 1;
    }

    private int calculateBalance(Leaf leaf)  //Вычисление баланс фактора узла
    {
        return calculateHeight(leaf.right) - calculateHeight(leaf.left);
    }



}
