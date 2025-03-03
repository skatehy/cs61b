public class SLList <BleepBlop>{
    public class BleepNode {
        public BleepBlop item;
        public BleepNode next;

        public BleepNode(BleepBlop i, BleepNode n) {
            item = i;
            next = n;
        }
    }

    public BleepNode sentinel;
    public static int size;
    public SLList(BleepBlop x) {
        sentinel = new BleepNode(63, null);
        sentinel.next = new BleepNode(x,null);
        size = 1;
    }
    public SLList(){
        sentinel = new BleepNode(63,null);
        size = 0;
    }
    /*add x to the front of the list */
    public void addFirst(BleepBlop x) {
        sentinel.next = new BleepNode(x, sentinel.next);
        size++;
    }


    /*Returns the first item in the list*/
    public BleepBlop getFirst() {
        return sentinel.next.item;
    }

    /*ADDs an item to the end of the list*/
    public void addLast(BleepBlop x) {
        BleepNode p = sentinel;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new BleepNode(x, null);
            size++;
        }


    public int  size(){
        return size;
    }
    public static void main(String[] args) {
        SLList<Integer> s1 = new SLList<>(5);
        s1.addLast(10);
        System.out.println(s1.getFirst());
        SLList<String> s2 = new SLList<>("hi");
        System.out.println(s2.getFirst());
    }
}