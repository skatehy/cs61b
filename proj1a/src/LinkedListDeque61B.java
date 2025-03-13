import java.util.ArrayList;
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
    }
    @Override
    public void addLast(T x) {
        Node p = sentinel.prev;
        p.next = new Node(p, x, p.next);
        sentinel.prev = p.next;
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
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
