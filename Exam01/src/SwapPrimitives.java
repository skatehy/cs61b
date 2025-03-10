public class SwapPrimitives {
    public static void swap(IntWrapper x , IntWrapper y)
    {
        IntWrapper swap = new IntWrapper(x.x);
        x.x = y.x;
        y.x = swap.x;
    }
    public static void main(String[] args) {
        int a = 6;
        int b = 7;
        IntWrapper x = new IntWrapper(a);
        IntWrapper y = new IntWrapper(b);
        swap(x,y);
        a = x.x;
        b = y.x;
        System.out.println(a);
        System.out.println(b);
        //except : 7,6
    }
}
