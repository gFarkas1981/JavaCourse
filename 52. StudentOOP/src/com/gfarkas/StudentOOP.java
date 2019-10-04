package com.gfarkas;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentOOP {

    public static void main(String[] args) {

        Student[] students = new Student[6];

        Student student1 = new Student(67, "Bela", 100);
        Student student2 = new Student(50, "Erika", 100);
        Student student3 = new Student(77, "Józsi", 100);
        Student student4 = new Student(88, "Géza", 100);
        Student student5 = new Student(26, "Timi", 100);
        Student student6 = new Student(59, "Gábor", 100);

        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        students[3] = student4;
        students[4] = student5;
        students[5] = student6;

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(students);

        for (Student student : students) {

            student.display();

        }

    }

}
