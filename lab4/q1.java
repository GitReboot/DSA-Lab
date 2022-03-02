package dsa.lab.lab4;

import java.lang.*;

class search {
    void sort(double[] arr){
        boolean swapped = true;
        int start = 0;
        int end = arr.length;
        while (swapped) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }
    public int bSearch(double[] arr, int val){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (arr[mid] == val){
                return mid;
            }
            if (arr[mid] < val){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public int lSearch(double[] arr, int x){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == x){
                return i;
            }
        }
        return -1;
    }
    public void print(int x, long endTime) {
        if (x == -1) {
            System.out.println("Not Found");
            System.out.println("Execution Time(ns): " + endTime);
        }
        else {
            System.out.println("Found at position: " + x);
            System.out.println("Execution Time(ns): " + endTime);
        }
    }
    public long endTime(long startTime) {
        return System.nanoTime() - startTime;
    }
}

public class q1 {
    public static void main(String[] args) {
        double[] arr = new double[10000];
        search s = new search();

        for (int i = 0; i < 10000; i++) {
            arr[i] = Math.random()*10000;
        }
        s.sort(arr);

        //Linear
        System.out.println("Linear search");
        System.out.println("\nInput: 5000");
        long startTime = System.nanoTime();
        s.print(s.lSearch(arr, 5000), s.endTime(startTime));

        System.out.println("\nInput: 9997");
        startTime = System.nanoTime();
        s.print(s.lSearch(arr, 9997), s.endTime(startTime));

        System.out.println("\nInput: 50000");
        startTime = System.nanoTime();
        s.print(s.lSearch(arr, 50000), s.endTime(startTime));

        //Binary
        System.out.println("\n\nBinary search");
        System.out.println("\nInput: 5000");
        startTime = System.nanoTime();
        s.print(s.bSearch(arr, 5000), s.endTime(startTime));

        System.out.println("\nInput: 9997");
        startTime = System.nanoTime();
        s.print(s.bSearch(arr, 9997), s.endTime(startTime));

        System.out.println("\nInput: 50000");
        startTime = System.nanoTime();
        s.print(s.bSearch(arr, 50000), s.endTime(startTime));
    }
}