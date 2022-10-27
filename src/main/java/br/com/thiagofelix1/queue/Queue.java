package br.com.thiagofelix1.queue;

public interface Queue<T> {
    void enqueue(T data);

    T dequeue();

    T front();

    int size();

    boolean isEmpty();

    boolean isFull();
}
