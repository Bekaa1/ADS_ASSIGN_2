public class Main {
    public static void main(String[] args) {
        MyArrayList newList = new MyArrayList();
        newList.add(6);
        newList.get(5);
        newList.set(0, 7);
        newList.get(5);
    }
    public static void queue(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(5);
        queue.enqueue(1);
        queue.enqueue(8);

        System.out.println(queue.dequeue()); //prints 1
        System.out.println(queue.dequeue()); //prints 2

        queue.enqueue(7);
        queue.enqueue(4);

        System.out.println(queue.peek()); //prints 3
        System.out.println(queue.size()); //prints 3

        System.out.println(queue.isEmpty()); //prints false
    }
}