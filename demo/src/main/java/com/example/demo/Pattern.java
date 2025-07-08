package com.example.demo;
import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size: ");
        int n=sc.nextInt();

        System.out.println("Choose pattern:\n1. Increment Triangle\n2. Repeated‑Row\n3. Inverted Triangle\n4. Increasing‑Start\n5. Floyd's Triangle\n6. Pascal’s Triangle");
        int choice=sc.nextInt();

        switch(choice) {
            case 1:
                incTriangle(n);
                break;
            case 2:
                repeatedRow(n);
                break;
            case 3:
                invertedTriangle(n);
                break;
            case 4:
                incStartTriangle(n);
                break;
            case 5:
                floydTriangle(n);
                break;
            case 6:
                pascalTriangle(n);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        sc.close();
    }

    static void incTriangle(int n) {
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=i;j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void repeatedRow(int n) {
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=i;j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void invertedTriangle(int n) {
        for (int i=n;i>=1;i--) {
            for (int j=1;j<=i;j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void incStartTriangle(int n) {
        for (int i=1;i<=n;i++) {
            for (int j=i;j<=n;j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void floydTriangle(int n) {
        int k=1;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=i;j++) {
                System.out.print((k++) + " ");
            }
            System.out.println();
        }
    }

    static void pascalTriangle(int n) {
        for (int i=0;i<n;i++) {
            int num=1;
            for (int s=0;s<(n - i - 1);s++)
                System.out.print("  ");

            for (int j=0;j<=i;j++) {
                System.out.printf("%4d", num);
                num=num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
