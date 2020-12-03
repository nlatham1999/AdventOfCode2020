package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    public static ArrayList<Integer> getListOfNumbers(String fileName){
        ArrayList<Integer> list = new ArrayList<>();
        try {
            File myObj = new File(fileName);
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

    public static ArrayList<String> getListOfStrings(String fileName){
        ArrayList<String> list = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }

    //takes in empty lists for the input and fills them
    public static void getInputForDayTwo(ArrayList<String> passwords, ArrayList<Character> characters, ArrayList<Integer> charMin, ArrayList<Integer> charMax){
        ArrayList<Integer> list = new ArrayList<>();
        try {
            File myObj = new File("./src/com/company/DayTwoInput");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp1 = data.split("-");
                charMin.add(Integer.parseInt(temp1[0]));
                String[] temp2 = temp1[1].split(" ");
                charMax.add(Integer.parseInt(temp2[0]));
                characters.add(temp2[1].charAt(0));
                passwords.add(temp2[2]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
