import interfaces.MyList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private T[] arr;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[10];
        size = 0;
    }
    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }


    public void add(T item) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        arr[size++] = item;
        System.out.println(arr.length);
    }


    @Override
    public void set(int index, T item) {
        if(index >= 0 && index < size){
            arr[index] = item;
        } else {
            System.out.println("Index out of range");
        }
    }


    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T get(int index) {
        for(int i = 0; i <= size; i++){
            System.out.println(arr[i]);
        }
        return null;
    }

    @Override
    public T getFirst(T item) {
        return null;
    }

    @Override
    public T getLast(T item) {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(T item) {
        return 0;
    }

    @Override
    public int lastIndexOf(T item) {
        return 0;
    }

    @Override
    public boolean exists(T item) {
        return false;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[size]; // Создаем массив типа T с размером списка
        System.arraycopy(arr, 0, result, 0, size); // Копируем элементы списка в массив
        return result; // Возвращаем массив типа T
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}