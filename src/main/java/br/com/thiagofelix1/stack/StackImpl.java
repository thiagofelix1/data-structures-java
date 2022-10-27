package br.com.thiagofelix1.stack;

public class StackImpl<T> implements Stack<T>{

    private final T[] elements;
    private int last;

    public StackImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("stack size cannot be 0");
        }
        this.elements = (T[]) new Object[size];
        this.last = -1;
    }

    @Override
    public void push(T data) {
        if (isFull()) {
            throw new IllegalArgumentException("Stack is full");
        }
        this.elements[++this.last] = data;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return this.elements[this.last--];
    }

    @Override
    public T top() {
        if (isEmpty()) throw new IllegalArgumentException("Stack is empty");
        return elements[last];
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return last < 0;
    }

    @Override
    public boolean isFull() {
        return (last + 1) == this.size();
    }
}
