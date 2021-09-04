package com.company;

import java.io.Serializable;

public class Lesson implements Serializable{
    static int numberLesson = 1;
    int number;
    public String lesson;
    public String lectureHall;
    public String teacher;

    public String startTime;
    public String endTime;

    public Lesson(String startTime,String endTime,String lectureHall, String teacher, String lesson){
        this.startTime = startTime;
        this.endTime = endTime;
        this.lectureHall = lectureHall;
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return this.number + "|" + this.startTime + "|" + this.lesson + "|" + this.endTime + "|" + this.lectureHall;
    }

}
