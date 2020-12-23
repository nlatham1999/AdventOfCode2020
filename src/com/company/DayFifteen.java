package com.company;

import java.util.Hashtable;

public class DayFifteen {

    public static int getResults(){

        int[] startingInput = {16,12,1,0,15,7,11};

        Hashtable<Integer, Integer> table = new Hashtable<>();

        for(int i = 0; i < startingInput.length; i++){
            table.put(startingInput[i], i);
        }
        int i = startingInput.length;
        int value = 0;

        while(i < 30000000){
            System.out.println(i + ": " + value);
            if(table.containsKey(value)){
                int distance = i - table.get(value);
                table.put(value, i);
                value = distance;
            }else{
                table.put(value, i);
                value = 0;
            }
            i++;
        }

        return value;
    }
}
