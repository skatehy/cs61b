package deque;

import java.sql.Array;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MaxArrayDeque61B<T> extends ArrayDeque61B<T>{
    Comparator<T> maxc ;
    //constructor
    public MaxArrayDeque61B(Comparator<T> c)
    {
        maxc = c;
    }
    public T max()
    {
        if(size == 0)return null;
        T max = items[0];
        for(T item : this)
        {
            if(maxc.compare(item,max) > 0) max = item;
        }
        return max;
    }
    public T max(Comparator<T> c)
    {
        if(size == 0)return null;
        T max = items[0];
        for(T item : this)
        {
            if(c.compare(item,max) > 0)max = item;
        }
        return max;
    }

}
