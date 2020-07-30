package com.zzp.behavior.observer.listener;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 事件源
 * @Author Garyzeng
 * @since 2020.07.30
 **/
public class EventSource {

    private List<Listener> listeners;

    public EventSource() {
        listeners = new LinkedList<Listener>();
    }

    public void addListener(Listener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    public void fireEvent(Event e) {
        notify(e);
    }

    public void notify(Event e) {
        for (Listener listener : listeners) {
            listener.eventHandler(e);
        }
    }

}
