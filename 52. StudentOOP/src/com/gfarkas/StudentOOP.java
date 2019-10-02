package com.gfarkas;

public class StudentOOP {

    public static void main(String[] args) {

        Student[] students = new Student[3];

        Student student1 = new Student(67, "Bela", 100);
//        student1.reachedPoint = 70;
//        student1.calcMark(100);
        student1.setName("Geza");


        Student student2 = new Student(50, "Erika", 100);
//        student2.reachedPoint = 50;
//        student2.calcMark(100);
        student2.setName("Timi");

        Student student3 = new Student(77, "Jozsi");
//        student3.reachedPoint = 77;
        student3.calcMark(100);
//        student3.name = "Erika";

        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        student1.display();
        student2.display();
        student3.display();

    }

}
