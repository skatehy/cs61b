import java.util.Comparator;

public class Maximizer {
    public static Comparable Max(Comparable[] items)
    {
        Comparable max = items[0];
        for(Comparable item : items)
        {
            if(max.compareTo(item) < 0)
            {
                max = item;
            }
        }
        return max;
    }
}
