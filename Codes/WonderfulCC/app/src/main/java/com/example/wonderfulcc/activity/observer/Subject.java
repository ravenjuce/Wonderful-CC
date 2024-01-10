package com.example.wonderfulcc.activity.observer;

import java.util.List;

public interface Subject {
    public void attach(List<Observer> obs);

    public void notifyAllObserver();
}
