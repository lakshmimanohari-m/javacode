package com.example.demo;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the students score:");
        int mark=scanner.nextInt();
        if(mark<0||mark>100) {
            System.out.println("Invalid mark");
        } else{
            String grade;
            String feedback;
            if (mark>=90) {
                grade="A";
                feedback="Excellent";
            } else if(mark>=80) {
                grade="B";
                feedback="Great";
            } else if(mark>=70) {
                grade="C";
                feedback="Good";
            } else if(mark>=60) {
                grade="D";
                feedback="Passed";
            } else {
                grade="F";
                feedback="Failed";
            }
            System.out.println("Grade="+grade);
            System.out.println("Feedback="+feedback);
        }
        scanner.close();

    }
}
