package br.com.thiagofelix1.list;

import br.com.thiagofelix1.list.node.Node;

import java.util.NoSuchElementException;

public class LinkedListImpl<T> implements LinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    private int size;

    public LinkedListImpl() {
        this.size = 0;
    }

    @Override
    public void inserirInicio(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
        }
        newNode.setNext(last);
        last = newNode;
    }

    @Override
    public void inserirFinal(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
        }
        last.setNext(newNode);
    }

    @Override
    public T removerInicio() {
        if (first == null) throw new NoSuchElementException();
        Node<T> node = first;
        first = node.getNext();
        if (first == last) {
            first = null;
            last = null;
        }
        return node.getValue();
    }

    @Override
    public T removerFinal() {
        Node<T> node = this.first;
        return node.getValue();
    }

    @Override
    public void imprimir() {
        Node<T> node = this.first;
        while (node.getNext() != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }
}
