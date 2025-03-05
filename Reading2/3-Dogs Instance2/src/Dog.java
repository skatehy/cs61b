public class Dog{
    //没有加main函数的话，出现错误：error: class Dog is public, should be declared in a file named Dog.java
    public int weightInPounds;
    /*One integer constructer for dogs*/
    public Dog(int w){
        weightInPounds = w;
    }
    public void makeNoise()
    {
        if(weightInPounds<10){
            System.out.println(("yipyipyip"));
        }else if(weightInPounds<30)
        {
            System.out.println("bark bark bark");
        }else {
            System.out.println("woof");
        }
    }
}
