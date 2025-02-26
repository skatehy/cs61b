public class DogLauncher
{
    public static void main(String[] args)
    {
        Dog d;
        d = new Dog(20);
        Dog d2 = new Dog(50);
        //让更重的狗发出声音
//        Dog bigger = Dog.maxDog(d1,d2);
        Dog bigger = Dog.maxDog(d,d2);
        bigger.makeNoise();
//        System.out.println(d.binomen);
//        System.out.println(d2.binomen);
//        System.out.println(Dog.binomen);
    }
}