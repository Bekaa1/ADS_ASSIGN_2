import interfaces.MyList;

public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T itemToRemove = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return itemToRemove;
    }

    public T peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }
}
