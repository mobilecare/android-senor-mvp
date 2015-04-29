package br.com.mobicare.senor.mvp.android.senor.mvp;

public interface IChangeListener<T> extends IAbstractListener {

    void handle(T event);
}