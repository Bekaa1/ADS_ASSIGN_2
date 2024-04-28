public class MyQueue<T> {
    private T[] queueArray;
    private int queueFront;
    private int queueRear;
    private int queueSize;

    public MyQueue() {
        queueArray = (T[]) new Object[10];
        queueFront = 0;
        queueRear = -1;
        queueSize = 0;
    }

    public void enqueue(T item) {
        if (queueSize == queueArray.length) {
            resize();
        }
        queueRear = (queueRear + 1) % queueArray.length;
        queueArray[queueRear] = item;
        queueSize++;
    }

    public T dequeue() {
        if (queueSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = queueArray[queueFront];
        queueFront = (queueFront + 1) % queueArray.length;
        queueSize--;
        if (queueSize == queueArray.length / 4) {
            resize();
        }
        return item;
    }

    public T peek() {
        if (queueSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueArray[queueFront];
    }

    public int size() {
        return queueSize;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }

    private void resize() {
        T[] newQueueArray = (T[]) new Object[queueArray.length * 2];
        for (int i = 0; i < queueSize; i++) {
            newQueueArray[i] = queueArray[(queueFront + i) % queueArray.length];
        }
        queueArray = newQueueArray;
        queueFront = 0;
        queueRear = queueSize - 1;
    }
}