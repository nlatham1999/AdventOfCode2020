package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DayTen {

    static ArrayList<Integer> numbers = new ArrayList<>();
    static int count = 0;

    public static int getResults(){
        numbers = FileReader.getListOfNumbers("./src/com/company/DayTenInput");

        Collections.sort(numbers);

        int numOnes = 0;
        int numThrees = 0;


//        for(int i = 0; i < numbers.size()-1; i++){
//            System.out.println(numbers.get(i));
//            if(numbers.get(i+1) - numbers.get(i) == 1){
//                numOnes++;
//                System.out.println("\t1");
//            }
//            else if(numbers.get(i+1) - numbers.get(i) == 3){
//                numThrees++;
//                System.out.println("\t3");
//            }
//        }
        adapterCounter(0);
        adapterCounter(1);
        adapterCounter(2);



//        return (numOnes+1) * (numThrees+1);
        return count;
    }

    static void adapterCounter(int i){
        if(i == numbers.size()-1){
            count++;
            System.out.println("DONE " + count);
            return;
        }
        if(i < numbers.size() - 1){
            if(numbers.get(i+1) - numbers.get(i) <= 3){
                adapterCounter(i+1);
            }
        }
        if(i < numbers.size() - 2){
            if(numbers.get(i+2) - numbers.get(i) <= 3){
                adapterCounter(i+2);
            }
        }
        if(i < numbers.size() - 3){
            if(numbers.get(i+3) - numbers.get(i) <= 3){
                adapterCounter(i+3);
            }
        }
    }
}
