package br.com.mobicare.senor;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEventer {

    private HashMap<Enum<?>, IAbstractListener> listeners;

    public void addListener(IAbstractListener iListener, Enum<?> listenerType) {
	if (listeners == null) {
	    listeners = new HashMap<Enum<?>, IAbstractListener>();
	}

	listeners.put(listenerType, iListener);
    }
    
    private void isListenerMap() {
	if (listeners == null || listeners.size() == 0) {
	    throw new RuntimeException("The listeners map was not initialized! Make sure you call addListener() before trying to fire any of them.");
	}
    }
    
    public void clearListeners() {
	listeners.clear();
    }

    public void fireListener(Enum<?> listenerType) {
	isListenerMap();
	
	IAbstractListener listener = listeners.get(listenerType);
	if (listener != null) {
	    if (listener instanceof IListener) {
		((IListener) listener).handle();
	    } else {
		throw new RuntimeException("The listener with enum " + listenerType.toString() + " is not an IListener!");
	    }
	}
    }

    @SuppressWarnings("unchecked")
    public void fireListenerWithValue(Enum<?> listenerType, Object value) {
	isListenerMap();
	
	IAbstractListener listener = listeners.get(listenerType);
	if (listener instanceof IChangeListener) {
	    Map<Enum<?>, Object> changes = new HashMap<Enum<?>, Object>();
	    changes.put(listenerType, value);
	    ChangeEvent<Object> event = new ChangeEvent<Object>(changes);
	    ((IChangeListener<Object>) listener).handle(event.get(listenerType));
	} else {
	    throw new RuntimeException("The listener with enum " + listenerType.toString() + " is not an IChangeListener!");
	}
    }

}