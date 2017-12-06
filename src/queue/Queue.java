package queue;

import node.node;

import java.util.Iterator;

public class Queue<T extends Comparable<T>> implements iQueue<T>, Iterable<T> {

    node<T> back,front;
    int count = 0,size = 10;
    private node<T> start, end;


    public Queue() {
        start = new node<>();
        start.setIndex(-1);
        end = new node<>();
        end.setIndex(-1);
        node<T> n = new node<>();
        start.setNext(n);
        n.setBack(start);
        node<T> tmp = start.getNext();
        for (int i = 1; i < size; i++) {
            node<T> nuevo = new node<>();
            tmp.setNext(nuevo);
            nuevo.setBack(tmp);
            tmp = tmp.getNext();
        }
        end.setBack(tmp);
        index();
        front = start.getNext();
        back = start.getNext();
    }


    public Queue(int size) {
        this.size = size;
        start = new node<>();
        start.setIndex(-1);
        end = new node<>();
        end.setIndex(-1);
        node<T> n = new node<>();
        start.setNext(n);
        n.setBack(start);
        node<T> tmp = start.getNext();
        for (int i = 1; i < size; i++) {
            node<T> nuevo = new node<>();
            tmp.setNext(nuevo);
            nuevo.setBack(tmp);
            tmp = tmp.getNext();
        }
        end.setBack(tmp);
        index();
        front = start.getNext();
        back = start.getNext();
    }

    public void index() {
        node<T> tmp = start;
        int i = 0;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            tmp.setIndex(i);
            i++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            node<T> tmp = back.getBack();
            int i = 0;

            @Override
            public boolean hasNext() {
                if (tmp.getNext() == null)
                    tmp = start.getNext();
                else
                    tmp = tmp.getNext();
                return i++ != count;
            }

            @Override
            public T next() {
                return tmp.getValue();
            }
        };
    }


    @Override
    public void enQueue(T value) throws QueueFullException {
        if (isFull()) throw new QueueFullException("Trae llena la cajuela compa");
        front.setValue(value);
        count++;
        if (front.getNext() == null)
            front = start.getNext();
        else
            front = front.getNext();

    }


    @Override
    public T deQueue() throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("pongale algo primon");
        T tmp = back.getValue();
        back.setValue(null);
        count--;
        if (back.getNext() == null)
            back = start.getNext();
        else
            back = back.getNext();
        return tmp;
    }


    @Override
    public boolean isEmpty() {
        return (count == 0);
    }


    @Override
    public boolean isFull() {
        return (count == size);
    }


    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("no trai nada pariente");
        return back.getValue();
    }


    @Override
    public node<T> search(T value) throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("Viejon, no trae nada en el saco primo");
        node<T> tmp = back;
        int i = 0;
        while (i <= count) {
            i++;
            if (tmp.getValue().equals(value))
                return tmp;
            if (tmp.getNext() == null)
                tmp = start.getNext();
            else
                tmp = tmp.getNext();
        }
        return null;
    }


    @Override
    public void clear() {
        while (!isEmpty())
            try {
                deQueue();
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
    }


    @Override
    public int size() {
        return count;
    }


}
