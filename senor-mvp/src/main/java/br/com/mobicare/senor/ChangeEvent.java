package br.com.mobicare.senor;

import java.util.Map;

public class ChangeEvent<T> {

    private Map<Enum<?>, T> changes;

    public ChangeEvent(Map<Enum<?>, T> changes) {
	this.changes = changes;
    }

    public T get(Enum<?> key) {
	return changes.get(key);
    }
}