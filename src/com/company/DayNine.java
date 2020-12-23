package com.company;

import java.util.ArrayList;

public class DayNine {

    static ArrayList<Long> numbers = new ArrayList<>();
    static int preamble = 25;

    public static Long getResults(){
        numbers = FileReader.getListOfNumbersLong("./src/com/company/DayNineInput");


        System.out.println(numbers.get(4));

        long invalidNumber = getFirstInvalidNumber();

        for(int i = 0; i < numbers.size(); i++){
            long sum = 0;
            long smallest = numbers.get(i);
            long largest = numbers.get(i);
            for(int j = i; sum < invalidNumber; j++){
                sum += numbers.get(j);
                if(numbers.get(j) < smallest){
                    smallest = numbers.get(j);
                }
                if(numbers.get(j) > largest){
                    largest = numbers.get(j);
                }
                if(sum == invalidNumber) {
                    return smallest + largest;
                }
            }
        }


        return Long.valueOf(0);
    }

    static long getFirstInvalidNumber(){
        for(int i = preamble; i < numbers.size(); i++){
            System.out.println(numbers.get(i));
            if(!isNumberValid(i)){
                return numbers.get(i);
            }
        }
        return 0;
    }

    static boolean isNumberValid(int i){
        for(int j = i - preamble;  j < i; j++){
            for(int k = j; k < i; k++){
                System.out.println(i + " " + j + " " + k);
                if(numbers.get(j) + numbers.get(k) == numbers.get(i)){
                    return true;
                }
            }
        }
        return false;
    }


}
