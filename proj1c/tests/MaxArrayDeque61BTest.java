import org.junit.jupiter.api.*;

import java.util.Comparator;
import deque.MaxArrayDeque61B;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class MaxArrayDeque61BTest {
    private static class StringLengthComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }

    @Test
    public void basicTest() {
        MaxArrayDeque61B<String> mad = new MaxArrayDeque61B<>(new StringLengthComparator());
        mad.addFirst("");
        mad.addFirst("2");
        mad.addFirst("fury road");
        assertThat(mad.max()).isEqualTo("fury road");
        StringLengthComparator c = new StringLengthComparator();
        assertThat(mad.max(c)).isEqualTo("fury road");//为什么max（c）
    }

    @Test
    public void integerTest()
    {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<Integer>(Comparator.naturalOrder());
        mad.addFirst(100);
        mad.addLast(300);
        mad.addFirst(200);
        mad.addLast(900);
        assertThat(mad.max()).isEqualTo(900);
        assertThat(mad.max(Comparator.naturalOrder())).isEqualTo(900);//为什么max.naturalOrder();
    }

}
