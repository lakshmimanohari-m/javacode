package com.example.demo;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        String input1 = scanner.nextLine();
        if(isNullOrBlank(input1)){
            System.out.println("First input number is empty.");
            scanner.close();
            return;
        }
        System.out.println("Enter second number: ");
        String input2 = scanner.nextLine();
        if(isNullOrBlank(input2)){
            System.out.println("Second number input is empty.");
            scanner.close();
            return;
        }
        System.out.println("Enter operator:");
        String operator = scanner.nextLine();
        if(isNullOrBlank(operator)){
            System.out.println("Operator input is empty.");
            scanner.close();
            return;
        }

        try {
            double num1 = parseToDouble(input1);
            double num2 = parseToDouble(input2);
            double ans;

            switch (operator) {
                case "+":
                    ans = num1 + num2;
                    System.out.println("Ans=" + ans);
                    break;
                case "-":
                    ans = num1 - num2;
                    System.out.println("Ans=" + ans);
                    break;
                case "*":
                    ans = num1 * num2;
                    System.out.println("Ans=" + ans);
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("can't divide by zero:");
                    } else {
                        ans = num1 / num2;
                        System.out.println("Ans=" + ans);
                    }
                    break;
                default:
                    System.out.println("Invalid operator");
            }
        } catch (NumberFormatException e) {
            System.out.println("invalid number");
        }
        scanner.close();
    }
    public static double parseToDouble (String input)throws NumberFormatException {
        return Double.parseDouble(input.trim());
    }
    public static boolean isNullOrBlank(String str){
        return str==null||str.trim().isEmpty();
    }
}