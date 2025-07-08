package com.example.demo;


import java.util.ArrayList;
import java.util.Scanner;

public class ListApplication {

    static class Task {
        String description;
        boolean isFinished;

        Task(String description) {
            this.description = description;
            this.isFinished = false;
        }

        void markFinished() {
            this.isFinished = true;
        }

        public String toString() {
            return (isFinished ? "(yes)":"(no)")+description;
        }
    }

    public static void main(String[] args) {
        ArrayList<Task>tasks=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String input;

        System.out.println("List Application");

        while (true) {
            System.out.println("1-Add Task");
            System.out.println("2-View Tasks");
            System.out.println("3-Mark Task as Finished");
            System.out.println("4-Exit");
            System.out.print("Enter your choice: ");
            input=scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter task : ");
                    String desc=scanner.nextLine();
                    tasks.add(new Task(desc));
                    System.out.println("Task added.");
                    break;

                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("Tasks:");
                        for (int i=0;i<tasks.size();i++) {
                            System.out.println((i + 1) + ". "+tasks.get(i));
                        }
                    }
                    break;
                case "3":
                    System.out.print("Enter task number to mark as finished: ");
                    int index=Integer.parseInt(scanner.nextLine()) - 1;
                    tasks.get(index).markFinished();
                    System.out.println("Task finished.");
                    break;
                case "4":
                    System.out.println("bye");
                    return;
            }
        }
    }
}
