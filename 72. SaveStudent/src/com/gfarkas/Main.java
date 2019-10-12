package com.gfarkas;

import com.gfarkas.Model.Student;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student(67,"Géza", 100 );
        Student student2 = new Student(77,"Erika", 100 );

        OutputStream out;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("student.obj"));

            objectOutputStream.writeObject(student1);
            objectOutputStream.writeObject(student2);

        } catch (FileNotFoundException fnfEx) {
            fnfEx.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
