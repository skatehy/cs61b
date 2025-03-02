public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /*add x to the front of the list */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void addFirst3(int x) {
        IntNode addfirst = new IntNode(x, null);
        addfirst.next = this.first;
        this.first = addfirst;
    }

    public void addFirst2(int x) {
        SLList addfirst = new SLList(x);
        addfirst.first.next = this.first;
        this.first = addfirst.first;
    }

    /*Returns the first item in the list*/
    public int getFirst() {
        return first.item;
    }

    /*ADDs an item to the end of the list*/
    public void addLast(int x)
    {
        IntNode p = first ;
        while(p.next != null)
        {
            p = p.next;
        }
        p.next = new IntNode(x,null);
    }
//    public int size()
//    {
//        int size = 0;
//        IntNode p = first;
//        while(p.next != null)
//        {
//            p = p.next;
//            size++;
//        }
//        return size+1;
//    }
    private static int size(IntNode p)
    {
        if(p.next == null)
        {
            return 1;
        }
        else
            return 1 + size(p.next);
    }
    public int size()
    {
       return size(first);
    }

    public static void main(String[] args) {
        /*create a list of one interger,namely 10*/
        SLList L = new SLList(10);
        L.addFirst(10);
        L.addFirst2(20);
        L.addFirst3(30);
        System.out.println(L.getFirst());
        L.addLast(40);
        System.out.println(L.size());
    }
}