package ü1a1;

public interface Stapel<T> extends Folge<T> {

    T top();
    void insert(T e);
    void remove();

}
