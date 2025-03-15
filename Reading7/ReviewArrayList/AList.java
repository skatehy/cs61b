package lec7_lists4.DIY;

/** This is a fill in the blanks version of the SLList class
 *  in case you want to try to figure out how to write it yourself.
 *  After writing your methods, you can run the AListTest file.
 */
/*
    invariants:
    the size's number always representative the index of next item
    when remove an item or add an item ,the size will -- or ++
 */
public class AList {
    int size = 0;
    int[] items;
    /** Creates an empty list. */
    public AList() {
        size = 0;
        items = new int[10];
    }

    /** Inserts X into the back of the list. */
    /*
    if the array is filled,when inserts,the items should expand to 2 multiple
     */
    public void addLast(int x) {
        if(size >= items.length)
            Resize();
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        if(size >= items.length)
            Resize();
     return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    //if the i is bigger than size,return -1
    public int get(int i) {
        if(i >= size)
            return -1;
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {

        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    //if size <= 0,return -1.
    public int removeLast() {
        if(size <= 0)return -1;
        return items[--size];
    }

    public void Resize()
    {
        int[] p = new int[items.length*2];
        System.arraycopy(items,0,p,0,size);
        items = p;
    }
} 