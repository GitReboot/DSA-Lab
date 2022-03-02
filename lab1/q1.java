package dsa.lab.lab1;

import java.io.*;
import java.util.*;

class stack {
    static final int capacity = 5;
    int top = -1;
    String[] a = new String[capacity];

    void push(String x) {
       a[++top] = x;
    }

    String pop() {
        if (top < 0) {
            return "0";
        }
        else {
            return a[top--];
        }
    }

    void print() {
        for(int i = top;i>-1;i--){
            System.out.print(" "+ a[i] + "\n");
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class q1 {
    public static void main(String[] args) throws IOException {
        File in = new File("C:\\Users\\suchi\\IdeaProjects\\BITS\\src\\dsa\\lab\\lab1\\trainin.dat");
        Scanner inp = new Scanner(in);
        FileWriter writer = new FileWriter("trainout.dat");
        stack s = new stack();

        while(inp.hasNextLine()) {
            s.push(inp.nextLine());
        }

        s.print();

        while(!s.isEmpty()) {
            writer.write(s.pop() + "\n");
        }

        writer.close();
    }
}