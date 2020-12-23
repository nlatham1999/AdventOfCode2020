package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DaySeven {


    static Hashtable<String, ArrayList<String>> table = new Hashtable<>();
    static Hashtable<String, Hashtable<String, Integer>> table2 = new Hashtable<>();
    static boolean constainsBag = false;
    static int count = 0;

    static int getResult(){

        try {
            File myObj = new File("./src/com/company/DaySevenInput");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp1 = data.split(",");
                String[] temp2 = data.split(" ");
                String bag = temp2[0] + temp2[1];
                ArrayList<String> bags = new ArrayList<>();
                if(!temp2[4].contains("no")) {
                    bags.add(temp2[5] + temp2[6]);
                }
                for (int i = 1; i < temp1.length; i++) {
                    temp2 = temp1[i].split(" ");
                    bags.add(temp2[2] + temp2[3]);
                }
                System.out.println(bag);
                for(int i = 0; i < bags.size(); i++){
                    System.out.println("\t" + bags.get(i));
                }
                table.put(bag, bags);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Enumeration<String> keys = table.keys();

        while( keys.hasMoreElements() ){
            String element = keys.nextElement();
            goThroughLuggage(element);
            if(constainsBag) {
                count++;
                constainsBag = false;
            }
        }

        return count;
    }

    private static void goThroughLuggage(String element){
        ArrayList<String> bags = table.get(element);
        if(bags.contains("shinygold")){
            constainsBag = true;
        }
            for (int i = 0; i < bags.size(); i++) {
                if(!bags.get(i).contains("shinygold"))
                    goThroughLuggage(bags.get(i));
            }
    }

    public static int getResultPart2(){
        try {
            File myObj = new File("./src/com/company/DaySevenInput");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp1 = data.split(",");
                String[] temp2 = data.split(" ");
                String bag = temp2[0] + temp2[1];
                Hashtable<String, Integer> bags = new Hashtable<>();
                if(!temp2[4].contains("no")) {
                    bags.put(temp2[5] + temp2[6], Integer.parseInt(temp2[4]));
                }
                for (int i = 1; i < temp1.length; i++) {
                    temp2 = temp1[i].split(" ");
                    bags.put(temp2[2] + temp2[3], Integer.parseInt(temp2[1]));
                }
                System.out.println(bag);
                for(int i = 0; i < bags.size(); i++){
                    System.out.println("\t" + bags.get(i));
                }
                table2.put(bag, bags);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



        return goThroughLuggageTwo("shinygold");
    }

    private static int goThroughLuggageTwo(String element){
        Hashtable<String, Integer> bags = table2.get(element);
        int c = 0;

        Enumeration<String> keys = bags.keys();

        while( keys.hasMoreElements() ){
            String el = keys.nextElement();
            c += bags.get(el) + (bags.get(el) * goThroughLuggageTwo(el));
        }
        return c;
    }
}
