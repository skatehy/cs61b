import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }

    @Test
    void addFirstLastTest()
    {
        //test an integer array and a string array.
        ArrayDeque61B<Integer> array1= new ArrayDeque61B<>();
        array1.addFirst(10);
        array1.addLast(8);
        array1.addLast(3);
        array1.addFirst(6);
        assertThat(array1.toList()).containsExactly(6,10,8,3);

        ArrayDeque61B<Character> array2 = new ArrayDeque61B<>();
        array2.addFirst('y');
        array2.addLast('b');
        array2.addLast('a');
        array2.addFirst('h');
        array2.addLast('b');
        array2.addLast('a');
        assertThat(array2.toList()).containsExactly('h','y','b','a','b','a');
    }

    @Test
    //test the items beyond the length ,if it resize the array?
    //need add many elements.
    void resizeUpTest()
    {
//        int N = 1,element = 0;
//        ArrayDeque61B<Integer> array = new ArrayDeque61B<>();
//        while(N > 0)
//        {
//            array.addLast(element++);
//            array.addLast(element++);
//            N--;
//        }
//        assertThat(array.).isAtLeast(-1);

        ArrayDeque61B<Integer> array1= new ArrayDeque61B<>();
        array1.addFirst(10);
        array1.addLast(8);
        array1.addLast(3);
        array1.addFirst(6);
        array1.addFirst(6);
        array1.addFirst(6);
        array1.addFirst(6);
        array1.addFirst(6);
        array1.addFirst(6);
        assertThat(array1.toList()).containsExactly(6,6,6,6,6,6,10,8,3);

        ArrayDeque61B<Character> array2 = new ArrayDeque61B<>();
        array2.addFirst('y');
        array2.addLast('b');
        array2.addLast('a');
        array2.addFirst('h');
        array2.addLast('b');
        array2.addLast('a');
        array2.addLast('p');
        array2.addLast('i');
        array2.addLast('g');
        assertThat(array2.toList()).containsExactly('h','y','b','a','b','a', 'p','i','g');
    }

    @Test
    void isEmptyandSizeTest()
    {
        //test an empty and a not empty
        ArrayDeque61B<Integer> array1= new ArrayDeque61B<>();
        ArrayDeque61B<Character> array2 = new ArrayDeque61B<>();
        array2.addFirst('y');
        assertThat(array1.isEmpty()).isTrue();
        assertThat(array1.size()).isEqualTo(0);
        assertThat(array2.size()).isEqualTo(1);
        assertThat(array2.isEmpty()).isFalse();
    }

    @Test
    public void removeFirstandLastTest()
    {
        //test an integer array and a string array.
        ArrayDeque61B<Integer> array1= new ArrayDeque61B<>();
        array1.addFirst(10);
        array1.addLast(8);
        array1.addLast(3);
        array1.addFirst(6);
        array1.removeFirst();
        array1.removeLast();
        assertThat(array1.toList()).containsExactly(10,8);

        ArrayDeque61B<Character> array2 = new ArrayDeque61B<>();
        array2.addFirst('y');
        array2.addLast('b');
        array2.addLast('a');
        array2.addFirst('h');
        array2.addLast('b');
        array2.addLast('a');
        array2.removeFirst();
        array2.removeLast();
        assertThat(array2.toList()).containsExactly('y','b','a','b');
    }

    @Test
    public void resizeDownTest()
    {
        ArrayDeque61B<Integer> array1= new ArrayDeque61B<>();
        array1.addFirst(10);
        array1.addLast(8);
        array1.addLast(3);
        array1.addFirst(6);
        array1.addFirst(6);
        array1.addFirst(6);
        array1.addFirst(6);
        array1.addFirst(6);
        array1.addFirst(6);
        array1.removeFirst();
        array1.removeFirst();
        array1.removeLast();
        array1.removeFirst();
        array1.removeFirst();
        array1.removeLast();
//        assertThat(array1.items.length).isEqualTo(8); can't write like this ,so I just debug to see the length.

        ArrayDeque61B<Character> array2 = new ArrayDeque61B<>();
        array2.addFirst('y');
        array2.addLast('b');
        array2.addLast('a');
        array2.addFirst('h');
        array2.addLast('b');
        array2.addLast('a');
        array2.addLast('p');
        array2.addLast('i');
        array2.addLast('g');
        array1.removeFirst();
        array1.removeFirst();
        array1.removeLast();
        array1.removeFirst();
        array1.removeFirst();
        array1.removeLast();
        //need to see the length is 8 in the Visualizer.
        assertThat(array2.toList()).containsExactly('h','y','b','a','b','a', 'p','i','g');
    }

    @Test
    public void getTest()
    {
        //Test a large,a nagative,and a normal
        ArrayDeque61B<Integer> array1= new ArrayDeque61B<>();
        assertThat(array1.get(-1)).isEqualTo(null);
        assertThat(array1.get(1000)).isEqualTo(null);


        ArrayDeque61B<Character> array2 = new ArrayDeque61B<>();
        array2.addFirst('y');
        array2.addLast('b');
        array2.addLast('a');
        array2.addFirst('h');
        array2.addLast('b');
        array2.addLast('a');
        array2.addLast('p');
        array2.addLast('i');
        array2.addLast('g');
        array1.removeFirst();
        array1.removeFirst();
        array1.removeLast();
        array1.removeFirst();
        array1.removeFirst();
        array1.removeLast();
        //need to see the length is 8 in the Visualizer.
        assertThat(array2.toList()).containsExactly('h','y','b','a','b','a', 'p','i','g');
        assertThat(array2.get(3)).isEqualTo('a');
        assertThat(array2.get(8)).isEqualTo('g');
    }
}
