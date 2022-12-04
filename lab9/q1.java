package dsa.lab.lab9;

import java.util.*;
import java.io.*;

class Hsort {
    private final String[] Heap;
    private int size;
    private final int maxsize;

    public Hsort(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;

        Heap = new String[this.maxsize + 1];
        Heap[0] ="";
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private void swap(int fpos, int spos) {
        String tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    public void insert(String element)
    {
        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current].compareTo(Heap[parent(current)]) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void printHeap() {
        for (int i = 1; i <= size; ++i) {
            System.out.print(Heap[i] + " ");
        }
        System.out.println();
    }
}

public class q1 {
    public static void main(String[] args) throws FileNotFoundException {
        File in = new File("C:\\Users\\suchi\\IdeaProjects\\BITS\\src\\dsa\\lab\\lab9\\hsorting.txt");
        Scanner inp = new Scanner(in);
        Hsort h = new Hsort(100);

        while(inp.hasNextLine()) {
            h.insert(inp.nextLine());
            h.printHeap();
        }

        System.out.println("Array after sorting:");
        h.printHeap();
    }
}

