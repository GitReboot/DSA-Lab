package dsa.lab.lab0;

import java.util.*;

public class q2 {
    public static void main(String[] args) {
        int a,b,c,d,t1,t2,i,gcd = 0;
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter the numerator for 1st number: ");
        a = inp.nextInt();
        System.out.print("Enter the denominator for 1st number: ");
        b = inp.nextInt();
        System.out.print("Enter the numerator for 2nd number: ");
        c = inp.nextInt();
        System.out.print("Enter the denominator for 2nd number: ");
        d = inp.nextInt();

        t1=(a*d)+(b*c);
        t2=b*d;

        for(i=1; i<=t1 && i<=t2; ++i) {
            if(t1%i==0 && t2%i==0)
                gcd = i;
        }
        System.out.println("\nThe added fraction is: "+ t1/gcd + "/" + t2/gcd);
    }
}
