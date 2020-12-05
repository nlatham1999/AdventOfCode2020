package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class DayFive {
    public static int getResult(){

        ArrayList<String> passes = FileReader.getListOfStrings("./src/com/company/DayFiveInput");
        int biggest = 0;

        //this is for part 2
        boolean[] tickets = new boolean[1023];
        Arrays.fill(tickets, false);


        for(int i = 0; i < passes.size(); i++){

            int min = 0;
            int max = 127;
            int min2 = 0;
            int max2 = 7;
            System.out.println(passes.get(i));
            for(int j = 0; j < 7; j++){
                if(passes.get(i).charAt(j) == 'F') {
                    max -= (max - min + 1) / 2;
                }else{
                    min += (max - min + 1) / 2;
                }
                System.out.println(passes.get(i).charAt(j) + " " + min + " " + max);
            }
            for(int j = 7; j < 10; j++){
                if(passes.get(i).charAt(j) == 'L') {
                    max2 -= (max2 - min2 + 1) / 2;
                }else{
                    min2 += (max2 - min2 + 1) / 2;
                }
                System.out.println(passes.get(i).charAt(j) + " " + min2 + " " + max2);
            }
            tickets[min * 8 + min2] = true;
            if(biggest < min * 8 + min2){
                biggest = min * 8 + min2;
            }

        }

        //this is for part 2
        for(int i = 0; i < tickets.length; i++){
            if(!tickets[i]){
                if(i > 0 && tickets[i-1]){
                    if(i < tickets.length - 1 && tickets[i+1]){
                        return i;
                    }
                }
            }
        }

        return biggest;
    }
}
