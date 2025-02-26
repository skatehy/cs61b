public class Dog {
    public int weight;
    public Dog(int w)//调用Dog时传入的参数
    {
        weight = w;
    }
    public void makeNoise()//调用Dog传入参数后，该是什么狗就发什么狗声
    {
        if(weight<10)
        {
            System.out.println("yipyipyip");
        }else if(weight<30)
        {
            System.out.println("barkbarkbark");
        }
        else{
            System.out.println("woofwoofwoof");
    }
    }

}
