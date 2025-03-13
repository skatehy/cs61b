public class Dog {
    //Explicit HoF approach:compare in the dogs.有点像static：公正的狗
    public String name;
    public int size;
    public Dog(String name, int size)
    {
        this.name = name;
        this.size = size;
    }
    //compare all dogs and return the big size one
    public static Dog Maximizer(Dog[] dogs)
    {
        Dog maxdog = dogs[0];
        for(Dog dog : dogs)
        {
            if(dog.size > maxdog.size)
            {
                maxdog = dog;
            }
        }
        return  maxdog;
    }
    public static void main(String[] args)
    {
        Dog[] dogs = {
                new Dog("Elyse",3),
                new Dog("Sture",9),
                new Dog("Benja",15)
        };
        System.out.println(Maximizer(dogs).size);
    }
}
