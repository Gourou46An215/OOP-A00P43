package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	char[] characters={'a','D','v','d','A','z','v','d','a','g','a','h','v','a','a','f','h','d'};
	Arrays.sort(characters);
	int[][] counter=arrayCounter(characters);
	printFigure(counter);
    }

    public static int[][] arrayCounter(char[] characters) {
        int[][] counter;
        // Defining an array with the maximum number of characters {{Characters Table},{Counter Table}}
        counter = new int[characters.length][characters.length];

        String charList=""; // For the moment we use a String to stock only one time each character. The Strings methods are more convenient for the moment.
        // We count the number of occurrence for each character :
        for(int i=0;i<characters.length;i++) {
            if(charList.indexOf((char)characters[i])<0) {
                charList+=(char)characters[i];
            }
            counter[1][charList.indexOf((char)characters[i])]+=1;
        }

        // Now we can convert the String to the character table Counter[0]
        for (int i=0;i<charList.length();i++){
            counter[0][i]=charList.charAt(i);
        }
        return counter;
    }


    public static void printFigure(int[][] counter) {
        for (int i=0;i<counter[0].length;i++) {
            if(counter[1][i]>0) {
                System.out.print((char)counter[0][i]);
                System.out.printf("%5d ",counter[1][i]);
                for(int j=0;j<counter[1][i];j++) {
                    System.out.print("+");
                }
                System.out.println();
            }
        }
    }
}
