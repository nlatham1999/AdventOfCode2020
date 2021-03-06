package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

//completes the task for day one
public class DayOne {

    public static int getAnswer() {
        ArrayList<Integer> numbers = FileReader.getListOfNumbers("./src/com/company/DayOneInput");

        for(int i = 0; i < numbers.size(); i++){
            for(int j = i + 1; j < numbers.size(); j++){
                if(numbers.get(i) + numbers.get(j) == 2020){
                    return numbers.get(i) * numbers.get(j);
                }
            }
            System.out.println("Still Searching...");
        }

        return 0;
    }

}
