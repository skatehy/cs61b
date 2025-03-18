import java.util.HashSet;
import java.util.Iterator;

public class ArraySetLauncher {
    public static void main(String[] args) {
        ArraySet<String> arraySet = new ArraySet<>();
        arraySet.add(null);
        arraySet.add("horse");
        arraySet.add("pig");
        arraySet.add("dog");
        arraySet.add("hybaba");
//        for(String i : arraySet)
//        {
//            System.out.println(i);
//        }
        ArraySetIterator<String> seer=  arraySet.iterator();
        while(seer.hasnext()) {
            System.out.println(seer.next());
        }

//        HashSet<Integer> hyset = new HashSet<>();
//        hyset.add(1);
//        hyset.add(200);
//        hyset.add(20);
//        Iterator<Integer> seer1 = hyset.iterator();
//        while(seer1.hasNext())
//        {
//            System.out.println(seer1.next());
//        }
    }
}
