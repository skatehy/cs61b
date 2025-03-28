package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T>
{
    int size ,nextFirst,nextLast;
    T[] items;
    //constructor
    public ArrayDeque61B()
    {
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        items = (T[]) new Object[8];
    }

    //helper method :resizeUp
    void resizeUp()
    {
        T[] resize = (T[])new Object[items.length*2];
        int index = 0;
        for(int i = 0; i < size; i++)
        {
            nextFirst = Math.floorMod(nextFirst+1, items.length);
            resize[index] = items[nextFirst] ;
            index++;
        }
        this.items = resize;
        nextFirst = items.length-1;
        nextLast = index;
    }
    @Override
    public void addFirst(T x) {
        //if the size equal or bigger than the length ,need resize up,so let us do it .
        if(size >= items.length)
        {
            resizeUp();
        }
        items[nextFirst] = x;
        nextFirst= Math.floorMod(nextFirst-1 , items.length);
        size++;
    }

    @Override
    public void addLast(T x) {
        if(size >= items.length)
        {
            resizeUp();
        }
        items[nextLast] = x;
        nextLast = Math.floorMod(nextLast+1, items.length);
        size++;
    }

    @Override
    /*
    maybe is a recursion:
    a base case : when
     */
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        int index = Math.floorMod(nextFirst + 1,items.length);
        while(index != nextLast)
        {
            returnList.add(items[index]);
            index = Math.floorMod(index+1, items.length);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return size;
    }
    //resizeDown : reduce the memory assuming.
    public void resizeDown()
    {
        T[] resize = (T[])new Object[items.length/2];
        int index = 0;
        for(int i = 0; i < size; i++)
        {
            nextFirst = Math.floorMod(nextFirst+1, items.length);
            resize[index] = items[nextFirst];
            index++;
        }
        this.items = resize;
        nextFirst = items.length-1;
        nextLast = index;
    }
    @Override
    public T removeFirst() {
        //if the size is smaller than 1/4 length ,then removeDown to 8;
        //if the length is smaller than 15(or equal),don't do anything
        if(size < items.length*0.25 && items.length > 15)
        {
            resizeDown();
        }
        /*
        invariants: the nextFirst's move is always right
        when remove, the items[nextFirst]is the removed element.
         */
        if(size == 0)return null;
        nextFirst = Math.floorMod(nextFirst+1, items.length);
        size--;
        if(size < items.length*0.25 && items.length > 15)
        {
            resizeDown();
        }
        return items[nextFirst];
    }

    @Override
    public T removeLast() {
        /*
        invariants: the nextFirst's move is always left
        when remove, the items[nextLast]is the removed element.
         */
        if(size == 0)return null;
        nextLast = Math.floorMod(nextLast-1, items.length);
        size--;
        if(size < items.length*0.25 && items.length > 15)
        {
            resizeDown();
        }
        return items[nextLast];
    }

    @Override
    public T get(int index) {
        //index is the index of items
        if(index < 0 || index >= size)return null;
        return items[index];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    @Override
    public Iterator<T> iterator() {
        return new arrayDequeIterator();
    }

    //inline class
    public class arrayDequeIterator implements Iterator
    {
        int wispod;
        public arrayDequeIterator()
        {
            wispod = Math.floorMod(nextFirst+1,items.length);
        }

        @Override
        public boolean hasNext() {
            if(Math.floorMod(wispod  , items.length) != nextLast)
                return true;
            return false;
        }

        @Override
        public Object next() {
            T p = items[wispod];
            wispod = Math.floorMod(wispod+1 , items.length);
            return p;
        }
    }


    //contains to see if an arraydeque's element is in another arraydeque
    public boolean contains(T x)
    {
        for(T item : items)
        {
            if(x == null)
            {
                if(item == null)return true;
            }
            else if(item.equals(x))return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)return true;
        if(obj instanceof ArrayDeque61B array)
        {
            if(array.size != this.size)return false;
            for(T item : this)
            {
                if(!array.contains(item))return false;
            }
        }
        return true;
    }

//    @Override
//    public String toString()
//    {
//        return List.of().toString();
//    }

//    @Override
//    public String toString()
//    {
//        StringBuilder stringad = new StringBuilder("[");
//        for(T item : this)
//        {
//            stringad.append(item);
//            stringad.append(",");
//        }
//        stringad.append("}");
//        return stringad.toString();
//    }

    @Override
    public String toString()
    {
        List<String> listad = new ArrayList<>();
        for(T item : this)
        {
            listad.add(item.toString());
        }
        return "{"+String.join(",",listad)+"}";
    }

}
