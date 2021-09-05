package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Serializable {
    static int numberStudent = 1;
    int number;
    public String name;
    public String surname;
    public String group;


    public HashMap<String,ArrayList<String>> schedule = new HashMap<>();


    public static void showLessonsForDay(String day,int number){
        StudentsLessonsSaver.students.stream()
                .filter(student->student.number == number)
                .map(student->student.schedule.get(day))
                .forEach(System.out::println);
    }


    public static void showLessonsForWeek(int number){
        try (FileInputStream fis = new FileInputStream("students.txt");
             ObjectInputStream in = new ObjectInputStream(fis)) {
            Optional<Student> thereIs = StudentsLessonsSaver.students.stream()
                    .filter(student->student.number == number)
                    .findAny();

            if(thereIs.isPresent()){
                StudentsLessonsSaver.students.stream()
                        .filter(student->student.number == number)
                        .map(student->student.schedule.get("monday"))
                        .forEach(x-> System.out.println("monday " + x.toString()));

                StudentsLessonsSaver.students.stream()
                        .filter(student->student.number == number)
                        .map(student->student.schedule.get("tuesday"))
                        .forEach(x-> System.out.println("tuesday " + x.toString()));

                StudentsLessonsSaver.students.stream()
                        .filter(student->student.number == number)
                        .map(student->student.schedule.get("wednesday"))
                        .forEach(x-> System.out.println("wednesday " + x.toString()));

                StudentsLessonsSaver.students.stream()
                        .filter(student->student.number == number)
                        .map(student->student.schedule.get("thursday"))
                        .forEach(x-> System.out.println("thursday " + x.toString()));

                StudentsLessonsSaver.students.stream()
                        .filter(student->student.number == number)
                        .map(student->student.schedule.get("friday"))
                        .forEach(x-> System.out.println("friday " + x.toString()));

                StudentsLessonsSaver.students.stream()
                        .filter(student->student.number == number)
                        .map(student->student.schedule.get("saturday"))
                        .forEach(x-> System.out.println("saturday " + x.toString()));

                StudentsLessonsSaver.students.stream()
                        .filter(student->student.number == number)
                        .map(student->student.schedule.get("sunday"))
                        .forEach(x-> System.out.println("sunday " + x.toString()));
            }
            else{
                System.out.println("Этого номера нет");
            }
        } catch (IOException e) {
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
