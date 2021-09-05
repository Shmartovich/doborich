package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentsLessonsSaver {
    static ArrayList<Student> students = new ArrayList<>(); //todo изначально нужно прочесть из файла
    static ArrayList<Lesson> lessons = new ArrayList<>();


    public StudentsLessonsSaver() throws IOException {
    }

    static public int convertTimeToInt(String time) {
        String[] arrString = time.split("|");
        int result = Integer.parseInt(arrString[0]) * 60 + Integer.parseInt(arrString[1]);
        return result;
    }

    public void showStudents() {
        try (FileInputStream fis = new FileInputStream("students.txt");
             ObjectInputStream in = new ObjectInputStream(fis)) {
            ArrayList<Student> students = (ArrayList<Student>) in.readObject();
            int count = 0;
            while (students.size() > count) {
                System.out.println(students.get(count));
                count++;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showLessons() {
        try (FileInputStream fis = new FileInputStream("lessons.txt");
             ObjectInputStream in = new ObjectInputStream(fis)) {
            ArrayList<Lesson> lessons = (ArrayList<Lesson>) in.readObject();
            int count = 0;
            while (lessons.size() > count) {
                System.out.println(lessons.get(count));
                count++;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static public void addStudent(Student student) {

        boolean flag = false;

        for(Student stud: students){
            if(stud.name.equals(student.name) && stud.surname.equals(student.surname)){
               flag = true;
            }
        }

        if(flag == false) {
            student.number = Student.numberStudent;
            Student.numberStudent++;

            students.add(student);

            try (FileOutputStream fos = new FileOutputStream("students.txt", false);
                 ObjectOutputStream out = new ObjectOutputStream(fos)) {
                out.writeObject(students);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("removed");
        }
    }

    public void removeStudent(String nameSurname){
        nameSurname = nameSurname.toLowerCase();

        for(Student student:StudentsLessonsSaver.students){

            String nameSurnameTemp = (student.surname + " " + student.name).toLowerCase();

            if(nameSurname.equals(nameSurnameTemp)){
                StudentsLessonsSaver.students.remove(student);

                try (FileOutputStream fos = new FileOutputStream("students.txt", false);
                     ObjectOutputStream out = new ObjectOutputStream(fos)) {
                    out.writeObject(students);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("added");
                break;
            }
        }
    }

    static public void addLesson(Lesson lesson) {
        boolean flag = false;
        try {
            File file = new File("lessons.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter fw = new FileWriter("lessons.txt", false);
                 FileInputStream fileInStream = new FileInputStream("lessons.txt")) {

                for(Lesson les: lessons){
                    if (lesson.lectureHall.equals(les.lectureHall)
                            && convertTimeToInt(les.startTime) <= convertTimeToInt(lesson.startTime)
                            & convertTimeToInt(les.endTime) >= convertTimeToInt(lesson.startTime)
                            | (convertTimeToInt(les.startTime) >= convertTimeToInt(lesson.startTime))
                            & convertTimeToInt(lesson.endTime) >= convertTimeToInt(lesson.startTime)) {

                        System.out.println("в это время аудитория занята");

                        if(lesson.teacher.equals(les.teacher)
                                && convertTimeToInt(les.startTime) <= convertTimeToInt(lesson.startTime)
                                & convertTimeToInt(les.endTime) >= convertTimeToInt(lesson.startTime)
                                | (convertTimeToInt(les.startTime) >= convertTimeToInt(lesson.startTime))
                                & convertTimeToInt(lesson.endTime) >= convertTimeToInt(lesson.startTime)) {

                            System.out.println("Этот преподаватель занят в это время");
                        }
                        flag = true;
                        break;
                    }
                }

                if (flag == false) {

                    try (FileOutputStream fos = new FileOutputStream("lessons.txt", false);
                         ObjectOutputStream out = new ObjectOutputStream(fos)) {

                        lesson.number = Lesson.numberLesson;
                        Lesson.numberLesson++;

                        lessons.add(lesson);
                        out.writeObject(lessons);
                        System.out.println("added");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void removeLesson(String lesson){
        lesson = lesson.toLowerCase(); //"11:10,12:40,102,Busanov,math"

        for(Lesson lessonTemp:StudentsLessonsSaver.lessons){

            String [] arrTemp = lessonTemp.toString().toLowerCase().split("\\|");

            String [] arr = new String[5];


            for(int i=1;i< arrTemp.length;i++){
                arr[i-1] = arrTemp[i];
            }

            for(String x:arr){
                System.out.println(x);
            }

            String lessonInfo = String.join(",", arr);

            System.out.println(lessonInfo + " info");
            System.out.println(lesson + " les");



            if(lessonInfo.equals(lesson)){

                StudentsLessonsSaver.lessons.remove(lessonTemp);

                try (FileOutputStream fos = new FileOutputStream("lessons.txt", false);
                     ObjectOutputStream out = new ObjectOutputStream(fos)) {
                    out.writeObject(lessons);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("removed");

                break;
            }

        }
    }
}