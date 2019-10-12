package com.gfarkas;

public class MyList implements List {

    private Object[] data;

    public MyList() {
    }

    @Override
    public void add(Object o) {

        if (data == null) {

            data = new Object[1];
            data[0] = o;

        } else {

            Object[] a2 = new Object[data.length + 1];

            for (int i = 0; i < data.length; i++) {

                a2[i] = data[i];

            }

            a2[a2.length - 1] = o;
            data = a2;

        }

    }

    @Override
    public Object get(int index) {

        if (index >= 0 && index < this.size()) {

            return data[index];

        }

        return null;

    }

    @Override
    public void remove(int index) {

        Object[] a2 = new Object[data.length - 1];

        for (int i = 0; i < data.length; i++) {

            if (i < index) {

                a2[i] = data[i];

            } else if (i > index) {

                a2[i] = data[i - 1];

            }

        }

        data = a2;

    }

    @Override
    public void set(int index, Object o) {

        data[index] = o;

    }

    @Override
    public int size() {
        return data.length;
    }

}
