import interfaces.MyList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    // The array that holds the elements of the list
    private T[] arr;
    // The current size of the list (number of elements)
    private int size;

    // Constructor that initializes the array with a default size of 10
    public MyArrayList() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    // Method to increase the size of the array when it's full
    private void increaseBuffer() {
        // Create a new array with double the size of the current array
        T[] newArr = (T[]) new Object[arr.length * 2];
        // Copy all elements from the current array to the new array
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        // Assign the new array to the current array
        arr = newArr;
    }

    // Method to add an element to the end of the list
    public void add(T item) {
        // If the array is full, increase its size
        if (size >= arr.length) {
            increaseBuffer();
        }
        // Add the element to the end of the array and increment the size
        arr[size++] = item;
    }

    // Method to set the element at a specific index
    @Override
    public void set(int index, T item) {
        // If the index is within the range of the list, set the element at that index
        if(index >= 0 && index < size){
            arr[index] = item;
        } else {
            // If the index is out of range, print an error message
            System.out.println("Index out of range");
        }
    }

    // Methods to add an element at a specific index, at the beginning, and at the end of the list
    @Override
    public void add(int index, T item) {
    }

    @Override
    public void addFirst(T item) {
    }

    @Override
    public void addLast(T item) {
    }

    // Method to get the element at a specific index
    @Override
    public T get(int index) {
        // Print all elements of the array
        for(int i = 0; i <= size; i++){
            System.out.println(arr[i]);
        }
        return null;
    }

    // Methods to get the first and last occurrence of an element in the list
    @Override
    public T getFirst(T item) {
        return null;
    }

    @Override
    public T getLast(T item) {
        return null;
    }

    // Methods to remove an element at a specific index, at the beginning, and at the end of the list
    @Override
    public void remove(int index) {
    }

    @Override
    public void removeFirst() {
    }

    @Override
    public void removeLast() {
    }

    // Method to sort the elements of the list
    @Override
    public void sort() {
    }

    // Methods to find the index of the first and last occurrence of an element in the list
    @Override
    public int indexOf(T item) {
        return 0;
    }

    @Override
    public int lastIndexOf(T item) {
        return 0;
    }

    // Method to check if an element exists in the list
    @Override
    public boolean exists(T item) {
        return false;
    }

    // Method to convert the list to an array
    @Override
    public T[] toArray() {
        // Create a new array with the same size as the list
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[size];
        // Copy all elements from the list to the new array
        System.arraycopy(arr, 0, result, 0, size);
        // Return the new array
        return result;
    }

    @Override
    public void clear() {
    }

    @Override
    public int size() {
        return 0;
    }

    // Method to get an iterator for the list
    @Override
    public Iterator iterator() {
        return null;
    }
}