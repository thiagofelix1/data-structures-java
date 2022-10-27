package br.com.thiagofelix1.list;

public interface LinkedList <T>{
    void inserirInicio(T data);

    void inserirFinal(T data);

    T removerInicio();

    T removerFinal();

    void imprimir();
}
