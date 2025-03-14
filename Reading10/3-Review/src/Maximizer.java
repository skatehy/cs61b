public class Maximizer {
    public static Comparable Max(Comparable[] items)
    {
        Comparable Max = items[0];
        for(Comparable item : items)
        {
            if(Max.compareTo(item) < 0)
            {
                Max = item;
            }
        }
        return Max;
    }
}
