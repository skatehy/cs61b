public class Cat implements Comparable<Cat>{
    String call;
    int number;
    public Cat(String call, int number)
    {
        this.call = call;
        this.number = number;
    }
    public int compareTo(Cat cat)
    {
        return this.number - cat.number;
    }

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Meow",11),
                new Cat("Woof",25),
                new Cat("Hello",200),
        };
        Cat cat = (Cat)Maximizer.Max(cats);
        System.out.println(cat.call);
    }
}
