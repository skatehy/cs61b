package gh2;

import deque.ArrayDeque61B;
import deque.Deque61B;

// TODO: maybe more imports
//Note: This file will not compile until you complete the Deque61B implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    // TODO: uncomment the following line once you're ready to start this portion
    // private Deque61B<Double> buffer;
    int capacity;
    Deque61B<Double> buffer = new ArrayDeque61B<>();//初始化一个duque，叫做buffer，这里我用Array
    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Initialize the buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this division operation into an int. For
        //       better accuracy, use the Math.round() function before casting.
        //       Your should initially fill your buffer with zeros.
        capacity = (int)(Math.round(SR/frequency));//初始化deque的容量
        for(int i = 0; i < capacity; i++)//以容量为限，用0填满buffer
        {
            buffer.addFirst(0.000);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in buffer, and replace with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.
        //用随机声音重置Deque61B的每一个item
//        for(Double item :buffer)
//        {
//            item = Math.random()-0.5;//注意，这里的item不是buffer.items中的item，而是一个变量，改变item无法改变buffer中item的值
//        }
        for(int i = 0; i < buffer.size(); i++)//取出buffer中的所有元素，并用随机值替换它们
        {
            buffer.removeFirst();
            buffer.addLast(Math.random()-0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       **Do not call StdAudio.play().**
        //将队列中的double移走，并生成新的声音(生成新的double到deque后面)
        double olddouble = buffer.removeFirst();
        double newdouble = DECAY*0.5*(olddouble+sample());
        buffer.addLast(newdouble);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
        return buffer.get(0);
    }
}
    // TODO: Remove all comments that say TODO when you're done.
