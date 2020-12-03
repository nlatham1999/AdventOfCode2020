package com.company;

import java.io.File;
import java.util.ArrayList;

public class DayOnePartTwo {
    public static int getAnswer() {
        ArrayList<Integer> numbers = FileReader.getListOfNumbers("./src/com/company/DayOneInput");

        for(int i = 0; i < numbers.size(); i++){
            for(int j = i + 1; j < numbers.size(); j++){
                for(int k = j + 1; k < numbers.size(); k++) {
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == 2020) {
                        return numbers.get(i) * numbers.get(j) * numbers.get(k);
                    }
                }
            }
            System.out.println("Still Searching...");
        }

        return 0;
    }
}
