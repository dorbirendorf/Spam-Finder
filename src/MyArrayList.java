


import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private int length;
    private E[] items;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        length = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
        if (newCapacity < length) return;

        E[] old = items;
        items = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = old[i];
        }
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public E get(int index) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();

        return items[index];
    }

    public E set(int index, E newVal) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        E old = items[index];
        items[index] = newVal;
        return old;
    }

    /**
     * add the element to the end of list
     *
     * @param element is the element you want to add
     * @return true if add successfully, otherwise return false
     */
    public boolean add(E element) {
        add(size(), element);
        return true;
    }

    
    public void add(int index, E element) {
        if (items.length == size()) ensureCapacity(size() * 2 + 1);
        for (int i = length; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = element;
        length++;
    }

    public E remove(int index) {
        E removeItem = items[index];
        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        length--;
        return removeItem;
    }


    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    // inner class
    private class ArrayListIterator implements java.util.Iterator<E> {

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public E next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return items[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current); // reference the outer class
        }
    }
}
