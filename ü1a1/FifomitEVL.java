package ü1a1;

public class FifomitEVL<T> implements FifoIF<T> {

    EVL<T> evl = new EVL<>();

    @Override
    public void push(T e) {
        if(evl.size() == 0) {
            evl.addLast(e);
        } else {
            evl.add(evl.size(), e);
        }
    }

    @Override
    public T pop() {
        return evl.removeFirst().data;
    }

    @Override
    public T peek() {
        T x;
        x = evl.remove(evl.size() - 1).data;
        evl.addLast(x);
        return x;
    }

    @Override
    public int size() {
        return evl.size();
    }

    @Override
    public boolean isEmpty() {
        return evl.size() == 0;
    }
}
