import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ArraySet<T> implements Iterable<T>{
    T[] items;
    int size;
    //constructor
    public ArraySet()
    {
        items = (T[]) new Object[100];
        size = 0;
    }
    //if the arrayset include the element x,yes ,return true,else return false
    private boolean contains(T x)
    {
        for(T item : items)
        {
            if(item ==null)
            {
                if(x==null)return true;
                continue;
            }
            if(item.equals(x))
                return true;
        }
        return false;
    }
    public void add(T x)
    {
        if(x == null)
            throw new IllegalArgumentException("can not be a null");
        if(contains(x))
            return ;
        items[size] = x;
        size++;
    }
    public ArraySetIterator iterator()
    {
        return new ArraySetIterator();
    }
    public class ArraySetIterator implements Iterator<T> {

        int wizpos ;
        public ArraySetIterator()
        {
            wizpos = 0;
        }
        @Override
        public boolean hasNext() {
            if(wizpos < size)return true;
            return false;
        }

        @Override
        public T next() {
            return items[wizpos++];
        }
    }

    //toString() method 1
//    public String toString()
//    {
//        String returnString = "[";
//        for(int i = 0; i < size -1; i++)
//        {
//            returnString += items[i].toString();
//            returnString += ",";
//        }
//        returnString += items[size-1].toString();
//        returnString += "]";
//        return returnString;
//    }
    //toString() method 2
//    @Override
//    public String toString()
//    {
//        StringBuilder returnSB = new StringBuilder("[");
//        for(int i = 0 ; i < size-1 ; i++)
//        {
//            returnSB.append(items[i]);
//            returnSB.append(",");
//        }
//        returnSB.append(items[size-1]);
//        returnSB.append("]");
//        return returnSB.toString();
//     }

    //toString Method 3
    public String toString()
    {
        List<String> list =  new ArrayList<String>();
        for(T x : this)
        {
            list.add(x.toString());
        }
        return "{" + String.join("," , list) + "}";
    }

     //equals() method to equal two ArraySet

    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if(obj instanceof ArraySet array)
        {
            if(array.size != this.size)return false;
            for(T item : this)//这里this和items的区别,注意这里是Iterator和Iterative的作用
            {
                if(!array.contains(item))return false;
            }
        }
        return true;
    }
    //of method,can be used : ArraySet.of(1,2,3);
    public static <T> ArraySet<T> of(T...stuff)
    {
        ArraySet<T> returnas = new ArraySet<>();
        for(T x : stuff)
            returnas.add(x);
        return returnas;
    }
}
