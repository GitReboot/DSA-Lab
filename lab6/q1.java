package dsa.lab.lab6;

import java.io.*;
import java.util.*;

public class q1 {
    public static void main(String[] args) throws FileNotFoundException {
        File in = new File("C:\\Users\\suchi\\IdeaProjects\\BITS\\src\\dsa\\lab\\lab6\\source.txt");
        Scanner inp = new Scanner(in);
        String alpRegex = "[a-zA-Z]";
        String numRegex = "[0-9]";

        Hashtable<Integer, ArrayList<String>> ht = new Hashtable<>();
        ArrayList<String> a0 = new ArrayList<>();
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();
        ArrayList<String> a3 = new ArrayList<>();
        ArrayList<String> a4 = new ArrayList<>();
        ArrayList<String> a5 = new ArrayList<>();

        while(inp.hasNextLine()) {
            String input = inp.nextLine();
            int num=0, alp=0;

            for(int i = 0; i < 3; i++) {
                if((String.valueOf(input.charAt(i))).matches(alpRegex)) {
                    alp += input.charAt(i);
                }
                else if((String.valueOf(input.charAt(i))).matches(numRegex)){
                    num += input.charAt(i);
                }
            }

            int hashValue = (((alp + (2 * num)) * 17) + 5) % 6;

            if(hashValue == 0) {
                a0.add(input);
            }
            else if(hashValue == 1) {
                a1.add(input);
            }
            else if(hashValue == 2) {
                a2.add(input);
            }
            else if(hashValue == 3) {
                a3.add(input);
            }
            else if(hashValue == 4) {
                a4.add(input);
            }
            else if(hashValue == 5) {
                a5.add(input);
            }

            System.out.println("The Hash value of "+input+" is "+hashValue);
        }

        ht.put(0, a0);
        ht.put(1, a1);
        ht.put(2, a2);
        ht.put(3, a3);
        ht.put(4, a4);
        ht.put(5, a5);

        for(int i = 0; i <= 5; i++) {
            System.out.println("The Subset of "+i+" : "+ht.get(i));
        }
    }
}
