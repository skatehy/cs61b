//public class IntList {
//    //instance variences
//    public int item;
//    public IntList next;
//    //consructor
//    public IntList(int a, IntList b){
//        item = a;
//        next = b;
//    }
//    //size() recursion
//    public int size()
//    {
//        if(this.next == null)
//        {
//            return 1;
//        }
//        return 1+next.size();
//    }
//    //size() iterative
//    public int size2()
//    {
//        int size = 0;
//        IntList p = this;
//        while(null != p)
//        {
//            p = p.next;
//            size++;
//        }
//        return size;
//    }
//    //get() recursion
//    public int get(int i)
//    {
//        if(i==1)
//            return this.item;
//        return this.next.get(i);
//    }
//    //get() iterative
//    public int get2(int i)
//    {
//        IntList p = this;
//        for(int j = 1 ;j < i ;j++)
//        {
//            p = p.next;
//        }
//        return p.item;
//    }
//    public static void main(String[] args)
//    {
////        IntList L = new IntList(10,null);
////        L = new IntList(20,L);
////        L = new IntList(5,L);
//        IntList L = new IntList(10,null);
//        L.next = new IntList(3,null);
//        L.next.next = new IntList(4,null);
//    }
//
//}
