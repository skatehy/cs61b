public class Dessert {
    public int flavor,price;
    public Dessert(int a,int b)
    {
        flavor = a;
        price = b;
        numDesserts++;
    }
    static int numDesserts = 0;
    public void printDessert()
    {
        System.out.println(flavor+" "+price+" "+numDesserts);
    }
    public static void main(String[] args)
    {
//        Dessert d = new Dessert(1,2);
//        d.printDessert();
//        Dessert d1 = new Dessert(3,4);
//        d1.printDessert();
        System.out.println("I love dessert!");
    }
}
