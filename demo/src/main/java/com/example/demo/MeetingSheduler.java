package com.example.demo;
import java.util.Scanner;
public class MeetingSheduler {
    static Scanner kb=new Scanner(System.in);
    static Meeting[] meetings=new Meeting[100];
    static int count=0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("1=add  2=list  3=exit");
            String c=kb.nextLine();
            if(c.equals("1")) add();
            else if(c.equals("2")) list();
            else break;
        }
    }

    static void add() {
        if (count>=meetings.length) {
            System.out.println("Meeting limit reached.");
            return;
        }

        System.out.print("Title: ");
        String t=kb.nextLine();
        System.out.print("Start (YYYY-MM-DD HH:MM): ");
        String s=kb.nextLine();
        System.out.print("End (YYYY-MM-DD HH:MM): ");
        String e=kb.nextLine();

        if (!(s.compareTo(e)<0)) {
            System.out.println("Start must be before end!");
            return;
        }

        Meeting m=new Meeting(t,s,e);
        for (int i=0;i<count;i++) {
            if (m.overlaps(meetings[i])) {
                System.out.println("Conflict with: "+meetings[i]);
                return;
            }
        }

        int pos=count;
        for (int i=0;i<count;i++) {
            if (s.compareTo(meetings[i].start) < 0) {
                pos=i;
                break;
            }
        }
        for (int i=count;i>pos;i--) {
            meetings[i]=meetings[i-1];
        }
        meetings[pos]=m;
        count++;
        System.out.println("Added.");
    }

    static void list() {
        if (count==0) {
            System.out.println("No meetings.");
        } else {
            for (int i=0;i<count;i++) {
                System.out.println(meetings[i]);
            }
        }
    }

    static class Meeting{
        String title,start,end;
        Meeting(String t,String s,String e) {
            title=t;
            start=s;
            end =e;
        }

        boolean overlaps(Meeting o) {
            return start.compareTo(o.end)<0&& o.start.compareTo(end)<0;
        }

        public String toString() {
            return title+": "+start+" to "+end;
        }
    }
}