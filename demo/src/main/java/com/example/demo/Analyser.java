package com.example.demo;

import java.util.Scanner;

public class Analyser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text:");
        String input=sc.nextLine().toLowerCase().trim();

        String[] words=cleanAndSplit(input);
        int[] counts=countFrequencies(words);

        printFrequencies(words, counts);

        int wordCount=words.length;
        int charCount=input.length();
        int sentenceCount=input.split("[.!?]+").length;

        System.out.println("\nWords: "+wordCount);
        System.out.println("Sentences: "+sentenceCount);
        System.out.println("Characters: "+charCount);
    }

    static String[] cleanAndSplit(String text) {
        text=text.replaceAll("[^a-z ]", "");
        return text.split("\\s+");
    }

    static int[] countFrequencies(String[] words) {
        int[] count=new int[words.length];
        java.util.Arrays.fill(count,-1);

        for (int i=0;i<words.length;i++) {
            if (count[i]==-1) {
                count[i]=1;
                for (int j=i+1;j<words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count[i]++;
                        count[j]=0;
                    }
                }
            }
        }

        return count;
    }

    static void printFrequencies(String[] words,int[] count) {
        System.out.println("\nWord Frequencies:");
        for (int i=0;i<words.length;i++) {
            if (count[i]>0) {
                System.out.println(words[i]+" : "+count[i]);
            }
        }
    }
}










