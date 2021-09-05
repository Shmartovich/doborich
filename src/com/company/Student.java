package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Serializable {
    static int numberStudent = 1;
    int number;
    public String name;
    public String surname;
    public String group;


    public HashMap<String,ArrayList<String>> schedule = new HashMap<>();


//    Stream<String> stream = Arrays.stream(array);

    public static void showLessonsForDay(String day,int number){
        StudentsLessonsSaver.students.stream()
                .filter(student->student.number == number)
                .map(student->student.schedule.get(day));
    }


    public static void showLessonsForWeek(int number){
        try (FileInputStream fis = new FileInputStream("students.txt");
             ObjectInputStream in = new ObjectInputStream(fis)) {
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


//            student1.schedule.get("monday").stream()
//                    .forEach(x -> System.out.println("monday " + x));

//
//            students.stream()
//                    .filter(student->student.number == number)
//                    .map(student->student.schedule)
//                    .forEach(x->System.out.println("tuesday " + x.get("tuesday")));
//            students.stream()
//                    .filter(student->student.number == number)
//                    .map(student->student.schedule)
//                    .forEach(x->System.out.println("monday " + x.get("monday")));
//            students.stream()
//                    .filter(student->student.number == number)
//                    .map(student->student.schedule)
//                    .forEach(x->System.out.println("monday " + x.get("monday")));
//            students.stream()
//                    .filter(student->student.number == number)
//                    .map(student->student.schedule)
//                    .forEach(x->System.out.println("monday " + x.get("monday")));
//            students.stream()
//                    .filter(student->student.number == number)
//                    .map(student->student.schedule)
//                    .forEach(x->System.out.println("monday " + x.get("monday")));

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
