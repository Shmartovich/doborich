package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        StudentsLessonsSaver saver = new StudentsLessonsSaver();


        Student student1 = new Student("sa", "ba", "11-000");
        Student student2 = new Student("ja", "jo", "11-001");

        saver.addStudent(student1);
        saver.addStudent(student2);

        Lesson lesson1 = new Lesson("08:30","11:00","101","Hasanov","chemistry");
        Lesson lesson2 = new Lesson("11:10","12:40","102","Busanov","math");

        saver.addLesson(lesson1);
        saver.addLesson(lesson2);

        ArrayList<String> monday = new ArrayList<>();
        ArrayList<String> tuesday = new ArrayList<>();
        ArrayList<String> wednesday = new ArrayList<>();
        ArrayList<String> thursday = new ArrayList<>();
        ArrayList<String> friday = new ArrayList<>();
        ArrayList<String> saturday = new ArrayList<>();
        ArrayList<String> sunday = new ArrayList<>();

        monday.add(lesson1.toString());
        monday.add(lesson2.toString());
        tuesday.add(lesson2.toString());
        wednesday.add(lesson1.toString());
        thursday.add(lesson1.toString());
        friday.add(lesson1.toString());
        saturday.add(lesson1.toString());
        sunday.add(lesson1.toString());


        student1.schedule.add(monday);
        student1.schedule.add(tuesday);
        student1.schedule.add(wednesday);
        student1.schedule.add(thursday);
        student1.schedule.add(friday);
        student1.schedule.add(saturday);
        student1.schedule.add(sunday);

        student2.schedule.add(monday);
        student2.schedule.add(tuesday);
        student2.schedule.add(wednesday);
        student2.schedule.add(thursday);
        student2.schedule.add(friday);
        student2.schedule.add(saturday);
        student2.schedule.add(sunday);

//        Student.showLessonsForWeek(1);

        System.out.println(student1.schedule.get(0).get(0));
//        while (true) {
//            System.out.println("1. Добавить студента");
//            System.out.println("2. Добавить пару");
//            System.out.println("3. Удалить студента");
//            System.out.println("4. Удалить пару");
//            System.out.println("5. Отобразить всех студентов");
//            System.out.println("6. Отобразить все пары");
//
//            int x = scanner.nextInt();
//            switch (x) {
//                case 1:
//                    System.out.println("Инфо студента как в примере: Иванов Иван 11-001");
//                    String line = scanner.next();
//                    String [] studentInfo = line.split(" ");
//                    Student student = new Student(studentInfo[0],studentInfo[1],studentInfo[2]);
//                    saver.addStudent(student);
//                case 2:
//                    System.out.println("Инфо пары как в примере: 08:30 11:00 109");
//                    line = scanner.next();
//                    String [] lessonInfo = line.split(" ");
//                    Lesson lesson = new Lesson(lessonInfo[0],lessonInfo[1],lessonInfo[2]);
//                    saver.addLesson(lesson);
//                case 3:
//                case 4:
//                case 5:
//                    saver.showStudents();
//                case 6:
//            }




//        Student student10=saver.showStudents();
//        Student student11=saver.showStudents();


//        Lesson lesson2 = new Lesson("09:00","12:00","21");
//        saver.removeLesson("");


        }
    }
