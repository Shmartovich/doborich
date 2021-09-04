package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentsLessonsSaver {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Lesson> lessons = new ArrayList<>();


    public StudentsLessonsSaver() throws IOException {
    }

//    public String [] studentIntoTempArr(String line){
//        String[] tempArr = new String[2];
//        String[] splitLineArr = line.split("\\|");
//        tempArr[0] = splitLineArr[0];
//        tempArr[1] = splitLineArr[1];
//        return tempArr;
//    }
//    public String [] lessonIntoTempArr(String line){
//        String[] tempArr = new String[3];
//        String[] splitLineArr = line.split("\\|");
//        tempArr[0] = splitLineArr[0];
//        tempArr[1] = splitLineArr[1];
//        tempArr[2] = splitLineArr[2];
//        return tempArr;
//    }

    public int convertTimeToInt(String time) {
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

    public void addStudent(Student student) {
//        boolean flag = false;
//        try {
//            File file = new File("students.txt");
//            if(!file.exists()) {
//                file.createNewFile();
//            }
//
//            try (FileWriter fw = new FileWriter("students.txt", true);
//                 FileInputStream fileInStream = new FileInputStream("students.txt")) {
//
//                Scanner in = new Scanner(fileInStream);
//
//                while(in.hasNextLine()) {
//                    String line = in.nextLine();
//
//                    if (studentIntoTempArr(line)[0].equals(student.surname) & studentIntoTempArr(line)[1].equals(student.name)) {
//                        System.out.println("копия");
//                        flag = true;
//                        break;
//                    }
//                }
//                if(flag == false){
//                    fw.write(student.toString() + "\n");
//                    System.out.println(student.toString());
//                }
//
//            }
//
//
//            catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
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

        }
    }

    //    public void removeStudent(String student){
//        boolean flag = false;
//
//        try (FileWriter fw = new FileWriter("temp.txt", true);
//             FileInputStream fileInStream = new FileInputStream("students.txt")) {
//
//            Scanner in = new Scanner(fileInStream);
//
//            File temp = new File("temp.txt");
//            if(!temp.exists()) {
//                temp.createNewFile();
//            }
//
//            while(in.hasNextLine()) {
//                String line = in.nextLine();
//                if(!line.equals(student)){ //TODO чувствителен к регистру
//                    fw.write(line + "\n");
//                }
//                else{
//                    flag = true;
//                }
//            }
//            if(flag == false){
//                System.out.println("этого студента не существует");
//            }
//
//            fw.close();
//            fileInStream.close();
//
//            File dump = new File("students.txt");
//            if(dump.exists()){
//                dump.delete();
//            }
//            File file = new File("students.txt");
//            temp.renameTo(file);
//
//
//
//        }
//        catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public void addLesson(Lesson lesson) {
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
                        out.writeObject(lessons);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    public void removeLesson(String lesson){
//        try (FileWriter fw = new FileWriter("temp.txt", true);
//             FileInputStream fileInStream = new FileInputStream("lessons.txt")) {
//
//            Scanner in = new Scanner(fileInStream);
//
//            File temp = new File("temp.txt");
//            if(!temp.exists()) {
//                temp.createNewFile();
//            }
//
//            while(in.hasNextLine()) {
//                String line = in.nextLine();
//                if(!line.equals(lesson.toString())){
//                    fw.write(line + "\n");
//                }
//            }
//
//            fw.close();
//            fileInStream.close();
//
//            File dump = new File("lessons.txt");
//            if(dump.exists()){
//                dump.delete();
//            }
//            File file = new File("lessons.txt");
//            temp.renameTo(file);
//
//
//
//        }
//        catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}