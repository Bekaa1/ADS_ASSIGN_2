import interfaces.MyList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class MyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        Node<T> current = getNodeAt(index);
        current.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else {
            Node<T> current = getNodeAt(index - 1);
            Node<T> newNode = new Node<>(item);
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        if (head != null) head.prev = newNode;
        head = newNode;
        if (tail == null) tail = head;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        return getNodeAt(index).data;
    }


    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }


    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            Node<T> current = getNodeAt(index - 1);
            current.next = current.next.next;
            if (current.next != null) {
                current.next.prev = current;
            } else {
                tail = current;
            }
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
            size--;
        }
    }

    @Override
    public void sort() {
        // Implement sorting algorithm
    }

    @Override
    public int indexOf(T item) {
        return getIndex(item, 0, size);
    }

    @Override
    public int lastIndexOf(T item) {
        return getIndex(item, size - 1, -1);
    }

    @Override
    public boolean exists(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private Node<T> getNodeAt(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private int getIndex(T item, int start, int step) {
        Node<T> current = start == 0 ? head : tail;
        for (int i = start; i >= 0 && i < size; i += step) {
            if (current.data.equals(item)) {
                return i;
            }
            current = current.next == null ? tail : current.prev;
        }
        return -1;
    }
}