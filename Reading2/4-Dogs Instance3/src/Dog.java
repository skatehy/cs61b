public class Dog{
    //没有加main函数的话，出现错误：error: class Dog is public, should be declared in a file named Dog.java
    public int weightInPounds;
    public static String binomen =  "Canis familiar";//静态变量，所有狗都有的属性
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
//    //maxDog只能是静态的，为什么？
    public static Dog maxDog(Dog d1,Dog d2)
    {
        if(d1.weightInPounds>d2.weightInPounds)
        {
            return d1;
        }else{
            return d2;
        }
    }
    //非静态的方法，自己与别的狗比较
//    public Dog maxDog(Dog d2)
//    {
//        if(this.weightInPounds > d2.weightInPounds)
//        {
//            return this;
//        }
//        return d2;
//    }
}

