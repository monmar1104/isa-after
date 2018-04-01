package queue;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class QueueTest {

    @Test
    public void shouldEnqueueItems() {
        Queue<String> queue = new QueueImpl<>();
        queue.enqueue("AAA");
        queue.enqueue("BBB");
        queue.enqueue("CCC");

        assertEquals(3, queue.size());
    }

    @Test
    public void shouldDequeueItems() {
        Queue<String> queue = new QueueImpl<>();
        queue.enqueue("AAA");
        queue.enqueue("BBB");
        queue.enqueue("CCC");

        assertEquals(3, queue.size());

        String s = queue.dequeue();
        assertEquals("AAA", s);
        assertEquals(2, queue.size());

        s = queue.dequeue();
        assertEquals("BBB", s);
        assertEquals(1, queue.size());

        s = queue.dequeue();
        assertEquals("CCC", s);
        assertEquals(0, queue.size());
    }

    @Test
    public void shouldNumbersQueue(){
        Queue<Integer> integerQueue = new QueueImpl<>();
        integerQueue.enqueue(60);
        integerQueue.enqueue(50);
        integerQueue.enqueue(40);
        integerQueue.enqueue(50);
        assertThat(integerQueue.dequeue(),is(60));

        assertThat(integerQueue.size(), is(3));
    }


}