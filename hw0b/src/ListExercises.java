import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int sum = 0;
        for(int i = 0 ;i < L.size() ;i++)
        {
            sum += L.get(i);
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> evenList = new ArrayList<>();
        for(int i = 0 ;i < L.size() ;i++)
        {
            if(L.get(i) % 2 == 0)
            {
                evenList.add(L.get(i));
            }
        }
        return evenList;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        List<Integer> commonList = new ArrayList<>();
        for(Integer elem : L1){
            if(L2.contains(elem))
                commonList.add(elem);
        }
        return commonList;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int count = 0;
        for(String elem :words)
        {
            for(int i = 0 ;i < elem.length() ;i++)
            {
                if(elem.charAt(i) == c)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
