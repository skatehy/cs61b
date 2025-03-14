public class Dog implements Comparable<Dog>{
    String name;
    int size;
    public Dog(String name, int size)
    {
        this.name = name;
        this.size = size;
    }
    /*
    compare this dog with other dog
    if this dog larger than other dog,return positive number
    if this dog smaller than, return negative number
    if equal,return 0
     */
    public int compareTo(Dog dog)
    {
        return this.size - dog.size;
    }
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog("hybaba",5),
                new Dog("hybaba",6),
                new Dog("hybaba",100),
        };
        Dog dog = (Dog)Maximizer.Max(dogs);
        System.out.println(dog.size);
    }
}