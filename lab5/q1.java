package dsa.lab.lab5;

import java.io.*;
class mSort {
    public static void sort(double[] arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(double[] arr, int low, int mid, int high) {
        double[] lArr = new double[mid - low + 1];
        double[] rArr = new double[high - mid];

        for (int i = 0; i < lArr.length; i++) {
            lArr[i] = arr[low + i];
        }

        for (int i = 0; i < rArr.length; i++) {
            rArr[i] = arr[mid + i + 1];
        }

        int lIndex = 0;
        int rIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (lIndex < lArr.length && rIndex < rArr.length) {
                if (lArr[lIndex] >= rArr[rIndex]) {
                    arr[i] = lArr[lIndex];
                    lIndex++;
                }
                else {
                    arr[i] = rArr[rIndex];
                    rIndex++;
                }
            }
            else if (lIndex < lArr.length) {
                arr[i] = lArr[lIndex];
                lIndex++;
            }
            else if (rIndex < rArr.length) {
                arr[i] = rArr[rIndex];
                rIndex++;
            }
        }
    }
}

public class q1 {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\suchi\\IdeaProjects\\BITS\\src\\dsa\\lab\\lab5\\mergeout.txt");
        double[] A = new double[10000];

        for (int i = 0; i <= 9999; i++) {
            A[i] = Math.random()*9999;
        }

        long startTime = System.nanoTime();
        mSort.sort(A, 0, 9999);
        long endTime = System.nanoTime() - startTime;

        System.out.println("Execution Time(ns): " + endTime);

        for (int i = 0; i <= 9999; i++) {
            writer.write(A[i]+"\n");
        }
    }
}