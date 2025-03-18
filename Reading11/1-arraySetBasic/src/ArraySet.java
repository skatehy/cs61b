public class ArraySet <T> implements ArraySetIterator<T>{
    /*
    write constructor, contain, and add
    the properties is the element in the ArraySet should not same,
    and there's no null
     */
    T[] items;
    int size;
    int seer;
    public ArraySet()
    {
        items = (T[])new Object[100];
        size = 0;
    }
    private boolean contain(T x)
    {
        /*
        if the ArraySet contain x,return true
        else return false
         */
        for(int i = 0; i < size; i++)
        {
            if(items[i] == null)
            {
                if(x == null)return true;
                return false;
            }
            if(items[i].equals(x))
                return true;
        }
        return false;
    }
    public void add(T item)
    {
//        if(item == null)
//        {
//            throw new IllegalArgumentException("can not null");
//        }

        if(this.contain(item))
            return ;
        items[size++] = item;
    }

    //iterator(): return the Interator which points at the ArraySet
    public ArraySetIterator<T> iterator()
    {
        seer = 0;
        return this;
    }
    /*
    two method : hasnext(),next()
    hasnext: define is there element in the arrayset. If it has element, return true, else return false.
    next：return two result, first, the pointer points at next, second, return the element in thr arrayset.
    invariants: when call havenext and next , the pointer points at the array elements should remain,
    and when second call havenext and next, the pointer should return to the head.
     */
    @Override
    public boolean hasnext() {
        if(seer == size)return false;
        return true;
    }

    @Override
    public T next() {
        return items[seer++];
    }
}