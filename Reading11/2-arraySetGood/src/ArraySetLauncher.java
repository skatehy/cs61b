import java.util.Iterator;
public class ArraySetLauncher {
    public static void main(String[] args) {
        ArraySet<String> arraySet = new ArraySet<>();
//        arraySet.add("horse");
        arraySet.add("pig");
        arraySet.add("dog");
        arraySet.add("hybaba");
        arraySet.add("hybaba");
        Iterator<String> seer = arraySet.iterator();
        while(seer.hasNext())
        {
            System.out.println(seer.next());
        }
        ArraySet<String> arraySet1 = new ArraySet<>();
//        arraySet1.add("horse");
        arraySet1.add("pig");
        arraySet1.add("dog");
        arraySet1.add("hybaba");
        arraySet1.add("hybaba");
//        //
//        if(arraySet1.equals(arraySet))System.out.println("they are equal");
//        else
//            System.out.println("they are not equal");
//        //right : arraySet.new ArraySetIterator();
//
        System.out.println(arraySet.toString());

//        if(arraySet1.equals(arraySet))System.out.println("Equal!");

        ArraySet<String> returnas = ArraySet.of("hello","I'm","hybaba");
        System.out.println(returnas);//默认打印时使用toString() method

    }

}
