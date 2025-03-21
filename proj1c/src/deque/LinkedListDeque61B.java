package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    //inner class
    private class Node
    {
        T data;
        Node prev,next;
        private Node(Node prev,T data, Node next)
        {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    Node sentinel;
    private int size = 0;
    //constructor
    public LinkedListDeque61B()
    {
        sentinel = new Node(sentinel,null,sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    //time will not increase when LinkList is big.
    @Override
    public void addFirst(T x) {
        Node p = new Node(sentinel,x,sentinel.next);
//        if(sentinel.prev == sentinel)//let sentinel.prev points at the last node
//        {
//            sentinel.prev = sentinel.next;
//        }
        // a nice sentinel idea
        sentinel.next = p;
        p.next.prev = p;
        size++;
    }
    @Override
    public void addLast(T x) {
        Node p = sentinel.prev;
        p.next = new Node(p, x, p.next);
        sentinel.prev = p.next;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel.next;
        while(p != sentinel)
        {
            returnList.add(p.data);
            p = p.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        if(sentinel.next == sentinel)
            return true;
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        /*
        list empty : return null
         */
        if(sentinel.next == sentinel)return null;
        Node p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        return p.data;
    }

    @Override
    public T removeLast() {
        if(sentinel.next == sentinel)return null;
        Node p = sentinel.prev;
        p.prev.next = sentinel;
        sentinel.prev = p.prev;
        return p.data;
    }

    @Override
    public T get(int index) {
        /*
        if index is a negative index or larger than the list.length return null
        iterate to get the item in index.
        the index representative which number is it.
         */
        if(index < 0 || index > this.size())
            return null;
        Node p = sentinel.next;
        for(int i = 1; i < index; i++)
        {
            p = p.next;
        }
        return p.data;
    }

    @Override
    public T getRecursive(int index) {

        return getRecursiveHelper(index,this.sentinel.next);
    }
    public T getRecursiveHelper(int index, Node p)
    {
        /*
        I want to get index,equals to my brother get index -1 ,and the brother...get index 1
        the index is which number it is
        base case : my brother get when index = 1
         */
        if(index < 0 || index > this.size())
        {
            return null;
        }
        if(index == 1)return p.data;
        return getRecursiveHelper(index-1,p.next);
    }

    @Override
    public Iterator<T> iterator() {

        return new linkedListDequeIterator();
    }

    public class linkedListDequeIterator implements Iterator{
        Node wispod;
        public linkedListDequeIterator()
        {
            wispod = sentinel.next;

        }

        @Override
        public boolean hasNext() {
            if(wispod == sentinel)
                return false;
            return true;
        }

        @Override
        public Object next() {
            T p = wispod.data;
            wispod = wispod.next;
            return p;
        }
}
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

    public static void main(String[] args) {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        System.out.println(lld1);
    }
}
