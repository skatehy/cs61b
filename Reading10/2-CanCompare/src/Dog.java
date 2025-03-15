public class Dog implements OurComparable{
    public String name;
    public int size;
    public Dog(String name, int size)
    {
        this.name = name;
        this.size = size;
    }
    /*
    return positive number when this dog bigger than ;
    return 0 when equals;
    return nagative number when smaller than.
     */
    @Override
    public int compareTo(OurComparable o)
    {
        Dog dog = (Dog)o;
        return this.size-dog.size;
    }

    public static void main(String[] args)
    {
        Dog[] dogs = {
                new Dog("Elyse",3),
                new Dog("Sture",9),
                new Dog("Benja",15)
        };
        System.out.println(((Dog)Maximizer.Max(dogs)).size);
    }
}
