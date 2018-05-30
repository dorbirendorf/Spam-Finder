


import java.util.NoSuchElementException;

public class Queue<T> {
    private LinkedList<T> list;

    public Queue() {
        this.list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    public T getLast(){
        return list.getLastData();
    }
    public void enqueue(T element) {
        if(element == null)
            throw new NullPointerException();
        list.add(element);
    }


    public T dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }

    public T peek() {
        if(isEmpty())
            throw new NoSuchElementException();
        return list.getFirst();
    }
}

