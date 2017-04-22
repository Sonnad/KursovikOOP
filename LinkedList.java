package structures;

public class LinkedList
{

    private int size;
    public ListVector iFirst;


    public LinkedList(int value) {
        size = 1;
        iFirst = new ListVector();
        iFirst.setValue(value);
        iFirst.next = iFirst;
        iFirst.prev = iFirst;
    }

    public void addElement(int value) {
        ListVector iTemp, iInterim;
        iTemp = iFirst;
        for (int i = 1; i < size; i++)
            iTemp = iTemp.next;
        iTemp.next = new ListVector();
        iInterim = iTemp;
        iTemp = iTemp.next;
        iTemp.prev = iInterim;
        iTemp.setValue(value);
        iTemp.next = iFirst;
        iFirst.prev = iTemp;
        size++;
    }

    public int getSize() {
        return size;
    }

    public class ListVector
    {
        private int value;

        public ListVector next;
        public ListVector prev;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }



}