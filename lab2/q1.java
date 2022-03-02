package dsa.lab.lab2;

import java.io.*;
import java.util.*;

class cQueue {
    private final int s=5;
    private int f=-1, r=-1;
    private final ArrayList<String> q = new ArrayList<>(s);

    public boolean isEmpty() {
        return f != -1;
    }

    public void enQueue(String data) {
        if(f == -1) {
            f = 0;
            r = 0;
            q.add(r, data);
        }

        else if(r == s - 1 && f != 0) {
            r = 0;
            q.set(r, data);
        }

        else {
            r = (r + 1);

            if(f <= r) {
                q.add(r, data);
            }

            else {
                q.set(r, data);
            }
        }
    }

    public String deQueue() {
        String t;
        t = q.get(f);

        if(f == r) {
            f = -1;
            r = -1;
        }

        else if(f == s - 1) {
            f = 0;
        }

        else {
            f = f + 1;
        }

        return t;
    }

    public void print() {
        if(f == -1) {
            return;
        }

        if(r >= f) {
            for(int i = f; i <= r; i++) {
                System.out.println(q.get(i));
            }
        }

        else {
            for(int i = f; i < s; i++) {
                System.out.println(q.get(i));
            }

            for(int i = 0; i <= r; i++) {
                System.out.println(q.get(i));
            }
        }
    }

    public void print7() {
        for(String line:q) {
            if(line.contains("7")) {
                System.out.println(line);
            }
        }
    }
}

public class q1 {
    public static void main(String[] args) throws IOException {
        File in = new File("C:\\Users\\suchi\\IdeaProjects\\BITS\\src\\dsa\\lab\\lab2\\trainin.dat");
        Scanner inp = new Scanner(in);
        FileWriter writer = new FileWriter("trainout.dat");
        cQueue q = new cQueue();

        while(inp.hasNextLine()) {
            q.enQueue(inp.nextLine());
        }

        q.print();
        System.out.println("\n");
        q.print7();

        while(q.isEmpty()) {
            writer.write(q.deQueue() + "\n");
        }

        writer.close();
    }
}