import deque.Deque61B;
import deque.ArrayDeque61B;
import deque.LinkedListDeque61B;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
public class Deque61BTest
{

    @Test
    public void iterableTest()
    {
        ArrayDeque61B<Integer> test1 = new ArrayDeque61B<>();
        test1.addLast(100);
        test1.addFirst(200);
        test1.addFirst(300);
        assertThat(test1).containsExactly(300,200,100);
        for(int item : test1)
        {
            assertThat(item).isNotEqualTo(500);
        }

        LinkedListDeque61B<Integer> test2 = new LinkedListDeque61B<>();
        test2.addFirst(100);
        test2.addFirst(200);
        test2.addLast(300);
        assertThat(test2).containsExactly(200,100,300);
        for(int item : test2)
        {
            assertThat(item).isNotEqualTo(500);
        }
    }

    @Test
    public void testEqualDeques61B() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        Deque61B<String> lld2 = new LinkedListDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        lld2.addLast("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertThat(lld1.toString()).isEqualTo(lld2.toString());//为什么我这里一定要调用toString(),但是我在任意一个类里面不需要toString()呢？
    }

    @Test
    public void toStringTest()
    {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        assertThat(lld1.toString()).isEqualTo("{front,middle,back}");

    }

}
