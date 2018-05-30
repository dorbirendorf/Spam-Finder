


public class LinkedList <T>{
    private Link<T> first;

    public LinkedList(){
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(T element) {
        if (element == null)
            throw new NullPointerException();
        first = new Link<T>(element, first);
    }

    public Link<T> getLast(){
        Link<T> current = first;
        while (current.getNext() != null){
            current = current.getNext();
        }
        return current;
    }
    public T getLastData(){
        Link<T> current = first;
        while (current.getNext() != null){
            current = current.getNext();
        }
        return current.getData();
    }
    public void add(T element) {
        if(element == null)
            throw new NullPointerException();
        Link<T> newLink = new Link<>(element);
        if(isEmpty()){
            first = newLink;
        }
        else {
            Link<T> current = getLast();
            current.setNext(newLink);
        }
    }
    public T removeFirst() {
        if(first == null)
            throw new NullPointerException();
        Link<T> firstLink=first;
        if(first.getNext() != null)
            first=first.getNext();
        else
            first=null;
        return firstLink.getData();
    }
    public T getFirst(){
        if(first == null)
            throw new NullPointerException();
        return first.getData();
    }
    
}