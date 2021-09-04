package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Student implements Serializable {
    static int numberStudent = 1;
    int number;
    public String name;
    public String surname;
    public String group;

    public ArrayList<ArrayList<String>> schedule = new ArrayList<>();

//    Stream<String> stream = Arrays.stream(array);

    public static void showLessonsForWeek(int number){
        try (FileInputStream fis = new FileInputStream("students.txt");
             ObjectInputStream in = new ObjectInputStream(fis)) {
            ArrayList<Student> students = (ArrayList<Student>) in.readObject();
            int count = 0;

            for(String lesson:students.get(0).schedule.get(0)){
                System.out.println(lesson);
            }

//            long c = students.stream()
//                    .filter(student->student.number == number)
//                    .map(student->student.schedule)
//                    .map(schedule->schedule.get(0))
//                    .count();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Student(String surname,String name,String group){
        this.surname = surname;
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString(){
        return this.number + "|" + this.surname + "|" + this.name +"|" + this.group;
    }

}
