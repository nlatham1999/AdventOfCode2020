package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

//completes the task for day one
public class DayOne {

    public static int getAnswer() {
        ArrayList<Integer> numbers = getFile();

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

    public static ArrayList<Integer> getFile(){
        ArrayList<Integer> list = new ArrayList<>();
        try {
            File myObj = new File("./src/com/company/DayOneInput");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }

}
