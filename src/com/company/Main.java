package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);


        StudentsLessonsSaver saver = new StudentsLessonsSaver();


        Lesson lesson1 = new Lesson("08:30", "11:00", "101", "Hasanov", "chemistry");
        Lesson lesson2 = new Lesson("11:10", "12:40", "102", "Busanov", "math");

        StudentsLessonsSaver.addLesson(lesson1);
        StudentsLessonsSaver.addLesson(lesson2);


        Student student1 = new Student("sa", "ba", "11-000");
        Student student2 = new Student("ja", "jo", "11-001");


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
        saturday.add(lesson2.toString());
        sunday.add(lesson1.toString());


        student1.schedule.put("monday", monday);
        student1.schedule.put("tuesday", tuesday);
        student1.schedule.put("wednesday", wednesday);
        student1.schedule.put("thursday", thursday);
        student1.schedule.put("friday", friday);
        student1.schedule.put("saturday", saturday);
        student1.schedule.put("sunday", sunday);


        StudentsLessonsSaver.addStudent(student1);
        StudentsLessonsSaver.addStudent(student2);
//
//        Student.showLessonsForWeek(1);


        while (true) {
            System.out.println("1. Добавить студента");
            System.out.println("2. Добавить пару");
            System.out.println("3. Удалить студента");
            System.out.println("4. Удалить пару");
            System.out.println("5. Отобразить всех студентов");
            System.out.println("6. Отобразить все пары");
            System.out.println("7. Расписание на неделю");
            System.out.println("8. Расписание на конкретный день");

            int x = scanner.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Инфо студента как в примере: Иванов,Иван,11-001");
                    String line = scanner.next();
                    String[] studentInfo = line.split(",");
                    Student student = new Student(studentInfo[0], studentInfo[1], studentInfo[2]);
                    saver.addStudent(student);
                    break;
                case 2:
                    System.out.println("Инфо пары как в примере: 08:30,11:00,109,Хасанов,Химия");
                    line = scanner.next();
                    String[] lessonInfo = line.split(",");
                    Lesson lesson = new Lesson(lessonInfo[0], lessonInfo[1], lessonInfo[2], lessonInfo[3], lessonInfo[4]);
                    saver.addLesson(lesson);
                    break;
                case 3:
                    System.out.println("Инфо студента как в примере: Иванов Иван");
//                    line = scanner.next();
                    saver.removeStudent("sa ba");
                    break;
                case 4:
                    System.out.println("Инфо пары как в примере: 08:30 11:00 109 Хасанов Химия");
                    //line = scanner.next();
                    saver.removeLesson("11:10,12:40,102,Busanov,math");
                    break;
                case 5:
                    saver.showStudents();
                    break;
                case 6:
                    saver.showLessons();
                    break;
                case 7:
                    break;
                case 8:
                    int number = scanner.nextInt();
                    Student.showLessonsForWeek(number);
                    break;
            }

        }
    }
}
