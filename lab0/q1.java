package dsa.lab.lab0;

import java.util.*;

public class q1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int i,n,t=0;
        System.out.println("Enter an integer:");
        n = inp.nextInt();
        for(i=1; i<n; i++) {
            if(n%i==0)
                t+=i;
        }
        if(t==n)
            System.out.println(n+" is a Perfect Number");
        else if(t>n)
            System.out.println(n+" is a Abundant Number");
        else
            System.out.println(n+" is a Deficient Number");
    }
}
