public class Maximizer {
    //return the big size dog in dogs,or cats,for the forth.
    public static OurComparable Max(OurComparable[] items)
    {
        OurComparable max = items[0];
        for(int i = 0; i < items.length; i++)
        {
            if(max.compareTo(items[i]) < 0)
                max = items[i];
        }
        return max;
    }
}
