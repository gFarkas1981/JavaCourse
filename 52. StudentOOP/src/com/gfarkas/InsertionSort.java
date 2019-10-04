package com.gfarkas;

class InsertionSort {

    void sort(Student[] students) {

        for (int i = 1; i < students.length; i++) {
            Student element = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getReachedPoint() > element.getReachedPoint()) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = element;

        }
    }

}
