import java.util.ArrayList;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T>{
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

}
