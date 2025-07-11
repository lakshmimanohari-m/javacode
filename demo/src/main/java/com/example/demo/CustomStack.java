package com.example.demo;

public class CustomStack {
    int[] stack;
    int[] inc;
    int size;
    int maxSize;
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.inc = new int[maxSize];
        this.size=1;
        this.maxSize = maxSize;
    }
    public void push(int x) {
        if (size < maxSize) {
            stack[size] = x;
            inc[size] = 1;
            ++size;
        }
    }
    public int pop() {
        if (size == 1) {
            return -1;
        }
        --size;
        int result=stack[size]+inc[size];
        if(size>0) {
            inc[size - 1]=size-1+inc[size];
        }
        inc[size] = 0;
        return result;
    }
    public void increment(int y, int val) {
        int index = Math.min(y, size) - 1;
        if (index >= 0) {
            inc[index] =index+ val;
        }
    }
    public void printStack() {
        System.out.print("Stack: ");
        for (int i = 1; i <= size; i++) {
            System.out.print((stack[i] + inc[i]) +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CustomStack St= new CustomStack(5);
        St.push(1);
        St.increment(1, 200);
        St.push(2);
        St.increment(2, 150);
        St.printStack();
        System.out.println("Pop: " + St.pop());
        St.printStack();
    }
}

