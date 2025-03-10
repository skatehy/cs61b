public class AList<Genergic> {
    /*
    1,items[size] always poGenergics at the node to be placed in.
    2.when add one element,size++;when remove one element,size--
     */
    Genergic[] items;
    int size;
    public AList(){
        items = (Genergic[]) new Object[10];
        size = 0;
    }
    public void resizeArray()
    {
        Genergic [] resize = (Genergic[]) new Object[size+1];
//        for(Genergic i = 0 ; i <size ;i++)
//        {
//            resize[i] = items[i];
//        }
        System.arraycopy(items,0,resize,0,size);
        this.items = resize;
    }
    public void addLast(Genergic x)
    {
        if(size==items.length)
        {
            resizeArray();
        }
        items[size++] = x;
    }
    public void removeLast()
    {
        size--;
    }
    public static void main(String[] args) {
        AList<Integer> test = new AList<>();
        int x = 1;
        for(int i = 1 ; i <= 11 ;i++) {
            test.addLast(x);
            x++;
        }
    }
}