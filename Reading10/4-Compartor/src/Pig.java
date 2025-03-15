import java.util.Comparator;

public class Pig implements Comparable<Pig> {
    String name;
    int size;
    //constructor
    public Pig (String name , int size)
    {
        this.name = name;
        this.size = size;
    }
    //comapre this with another pig
    public  int compareTo(Pig o)
    {
        Pig pig = (Pig)o;
        return this.size - pig.size;
    }
    //I want to compareto the pig's name ,but I won't write compareTo2,instead,use comparator.
    private static class  nameComparator implements Comparator<Pig>
    {
        public int compare(Pig a, Pig b)
        {
            return a.name.compareTo(b.name);
        }
    }
    public static Comparator<Pig> getCompartor()
    {
        return new nameComparator();
    }

}
