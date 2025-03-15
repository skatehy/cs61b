import java.util.Comparator;

public class PigLauncher {
    public static void main(String[] args) {
        Pig[] pigs = {
                new Pig("hybaba",100000),
                new Pig("49",1000),
                new Pig("stay",100000000),
                new Pig("Dragon",100),
                new Pig("abc",1293),
        };
        Pig maxpig = (Pig)Maximizer.Max(pigs);
        System.out.println(maxpig.size+"   "+maxpig.name);

        Pig pig1 = new Pig("hybaba",1000);
        Pig pig2 = new Pig("hybabaa",10000);
//        Pig.nameComparator nc = new Pig.nameComparator();
        Comparator<Pig> nc = Pig.getCompartor();
        if(nc.compare(pig1,pig2) > 0)//pig 1 is later than pig2
        {
            System.out.println(pig1.size+"   "+pig2.name);
        }
        else
            System.out.println(pig2.size+"   "+pig2.name);
    }
}
