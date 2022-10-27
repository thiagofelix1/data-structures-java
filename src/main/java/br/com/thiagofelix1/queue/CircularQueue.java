package br.com.thiagofelix1.queue;

public class CircularQueue<T> implements Queue<T> {

    private final T[] elements;
    private int  rear, front;

    public CircularQueue(int size) {
        if (size <= 0) throw new IllegalArgumentException("queue size cannot be 0");
        this.elements = (T[]) new Object[size];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public void enqueue(T data) {
        if (isFull()) throw new IllegalArgumentException("Queue is full");
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % this.size();
        elements[rear] = data;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new IllegalArgumentException("Queue is empty");
        T element = elements[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % this.size();
        }
        return element;
    }

    @Override
    public T front() {
        return elements[front];
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        if (front == 0 && rear == this.size() - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }
}
