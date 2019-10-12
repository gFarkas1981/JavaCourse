package com.gfarkas;

import com.gfarkas.Model.Student;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        InputStream in;
        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(
                            new FileInputStream("student.obj"));

            Student st1 = (Student) objectInputStream.readObject();
            Student st2 = (Student) objectInputStream.readObject();

            objectInputStream.close();

            st1.display();
            st2.display();

        } catch (FileNotFoundException fnfEx) {
            fnfEx.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}
