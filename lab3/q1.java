package dsa.lab.lab3;

import java.util.*;
import java.io.*;

class train{
    public String name, start, end;
    public int days;

    public train(String name, String start, String end, int days) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.days = days;
    }
}

class temp
{
    train data;
    temp next, prev;
}

class linkedList {
    static temp head = null;

    public void deleteTemp(temp del) {
        if (head == null || del == null) {
            return;
        }
        if (head == del) {
            head = del.next;
        }
        if (del.next != null) {
            del.next.prev = del.prev;
        }
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        del = null;
    }

    public void deleteTempPos(int n) {
        if (head == null || n <= 0) {
            return;
        }

        temp current = head;
        int i;

        for (i = 1; current != null && i < n; i++) {
            current = current.next;
        }

        if (current == null) {
            return;
        }
        deleteTemp(current);
    }

    public void push(train new_data) {
        temp temp1 = new temp();
        temp1.data = new_data;
        temp1.prev = null;
        temp1.next = head;

        if (head != null) {
            head.prev = temp1;
        }

        head = temp1;
    }

    public void print() {
        temp temp = head;
        if (temp == null) {
            System.out.print("Doubly Linked list empty");
        }
        while (temp != null) {
            train t = temp.data;
            System.out.print(t.name + "\t" + t.start + "\t" + t.end + "\t" + t.days + "\n");
            temp = temp.next;
        }
        System.out.println();
    }

    public void rPrint() {
        temp head_ref = head;
        temp tail = head_ref;

        while (tail.next != null) {
            tail = tail.next;
        }

        while (tail != head_ref) {
            train t = tail.data;
            System.out.print(t.name + "\t" + t.start + "\t" + t.end + "\t" + t.days + "\n");
            tail = tail.prev;
        }
        train t = tail.data;
        System.out.print(t.name + "\t" + t.start + "\t" + t.end + "\t" + t.days + "\n");
    }
}

public class q1 {
    public static void main(String[] args) throws IOException {
        File in = new File("C:\\Users\\suchi\\IdeaProjects\\BITS\\src\\dsa\\lab\\lab3\\trainin.dat");
        Scanner inp = new Scanner(in);
        linkedList l = new linkedList();
        while (inp.hasNext()) {
            String name = inp.next();
            String start = inp.next();
            String end = inp.next();
            int days = inp.nextInt();
            train t = new train(name, start, end, days);
            l.push(t);
        }
        System.out.println("Doubly linked list before deletion:");
        l.print();

        System.out.println("Doubly linked list before deletion (In reverse): ");
        l.rPrint();

        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter node position to delete: ");
        int n = s.nextInt();
        l.deleteTempPos(n);
        System.out.println("Doubly linked list after deletion:");
        l.print();
        inp.close();
    }
}
