package com.gfarkas;

public class MyList implements List {

    private Object[] data;

    public MyList() {
    }

    @Override
    public void add(Object o) {

        if(data == null) {

            data = new Object[1];
            data[0] = o;

        } else {



        }

    }

    @Override
    public Object get(int index) {

        if (index > 0 && index < this.size()) {

            return data[index];

        }

        return null;

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void set(int index, Object o) {

    }

    @Override
    public int size() {
        return 0;
    }

}
