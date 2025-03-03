package SortTesting.src;
public class Sort {
    //construction method
    /*
    return the sort which was sorted.
    */
    public static String[] sort(String[] x)
    {
        return sortRecursion(x,0);
    }
    /* recursion x from start*/
    public static String[] sortRecursion(String[] x,int start)
    {
        if(start >= x.length-1)
        {
            return x;
        }
        findSmallest(x,start);
        return sortRecursion(x,start+1);
    }
    /*
    find the smllest string in the sort and swap
     */
    public static String findSmallest(String[] x,int start)
    {
        for(int i = start ;i < x.length ;i++)
        {
            int result = x[start].compareTo(x[i]);
            if(result > 0)
            {
                String temp = "hello";
                temp = x[i];
                x[i] = x[start];
                x[start] = temp;
            }
        }
        return x[start];
    }
}