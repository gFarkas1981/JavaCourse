package com.gfarkas;

public interface List {

    void add(Object o);
    Object get(int index);
    void remove(int index);
    void set(int index, Object o);
    int size();

}
