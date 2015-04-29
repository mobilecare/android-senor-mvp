package br.com.mobicare.senor;

public interface IChangeListener<T> extends IAbstractListener {

    void handle(T event);
}