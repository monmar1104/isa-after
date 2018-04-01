package queue;

import java.util.ArrayList;
import java.util.List;

public class QueueImpl<T> implements Queue<T> {


    List<T> objectList = new ArrayList<>();


    public void enqueue(T o) {
        objectList.add(o);
    }

    public T dequeue() {
        T t = objectList.get(0);
        objectList.remove(0);
        return t;
    }

    public int size() {
        return objectList.size();
    }


}
