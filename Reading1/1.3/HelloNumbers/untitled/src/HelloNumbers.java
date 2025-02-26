public class HelloNumbers{
    public static void main(String[] args)
    {
        int x = 0 , y = 0;
        while(x < 10)
        {
            System.out.print(y + " ");
            x++;
            y = x + y;
        }
        System.out.println();
    }
}