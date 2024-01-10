package com.example.wonderfulcc.activity.observer;

import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class PostUser implements Subject{

    private ArrayList<Observer> observers;
    private String username;

    @Override
    public void attach(List<Observer> obs) {

    }

    @Override
    public void notifyAllObserver() {

    }
}
