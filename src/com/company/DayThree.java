package com.company;

import java.util.ArrayList;

public class DayThree {
    public static int getResult() {

        System.out.println(getResultForPart(1, 1));
        System.out.println(getResultForPart(3, 1));
        System.out.println(getResultForPart(5, 1));
        System.out.println(getResultForPart(7, 1));
        System.out.println(getResultForPart(1, 2));

        return getResultForPart(1, 1) * getResultForPart(3, 1)* getResultForPart(5, 1) * getResultForPart(7, 1) * getResultForPart(1, 2);

    }

    public static int getResultForPart(int r, int d){
        ArrayList<String> numbers = FileReader.getListOfStrings("./src/com/company/DayThreeInput");

        int count = 0;
        int rightAmount = 0;
        for (int i = d; i < numbers.size(); i+=d) {
            rightAmount += r;
            if(numbers.get(i).charAt(rightAmount % numbers.get(i).length()) == '#')
                count++;
        }
        return count;
    }

}
