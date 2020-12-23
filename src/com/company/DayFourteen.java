package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class DayFourteen {

    static long[] memory = new long[70000];
    static Hashtable<Long, Integer> table = new Hashtable<>();

    public static long getResults(){
        String mask = "";
        int memoryAddress = 0;
        int value = 0;

        try {
            File myObj = new File("./src/com/company/DayFourteenInput");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] command = data.split(" ");
                if(command[0].contains("mask")){
                    mask = command[2];
                }else{
                    memoryAddress = Integer.parseInt(command[0].substring(4,command[0].length()-1));
                    value = Integer.parseInt(command[2]);
                    applyMask2(mask, value, memoryAddress);

                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        long count = 0;
//        for(int i = 0; i < memory.length; i++){
//            count += memory[i];
//        }
        Set<Long> keys = table.keySet();
        for(Long key: keys){
            count += table.get(key);
        }

        return count;
    }

    static void applyMask(String mask, int value, int address){
        String binary = Integer.toBinaryString(value);
        binary = String.format("%36s", binary).replaceAll(" ", "0");
        String newBinary = "";
        System.out.println(mask + "\n" + binary);

        for(int i = 0; i < mask.length(); i++){
            if(mask.charAt(i) == '1' || mask.charAt(i) == '0'){
                newBinary += mask.charAt(i);
            }else{
                newBinary += binary.charAt(i);
            }
        }

        long integerValue = Long.parseLong(newBinary, 2);
        memory[address] = integerValue;
    }

    static void applyMask2(String mask, int value, int address){
        String binary = Integer.toBinaryString(address);
        binary = String.format("%36s", binary).replaceAll(" ", "0");
        String newBinary = "";

        ArrayList<String> addresses = new ArrayList<>();
        addresses.add("");

        for(int i = 0; i < mask.length(); i++){
            if(mask.charAt(i) == '0'){
                for(int j = 0; j < addresses.size(); j++){
                    String a = addresses.get(j);
                    a += binary.charAt(i);
                    addresses.set(j, a);
                }
            }else if(mask.charAt(i) == '1'){
                for(int j = 0; j < addresses.size(); j++){
                    String a = addresses.get(j);
                    a += '1';
                    addresses.set(j, a);
                }
            }else{
                ArrayList<String> doubles = new ArrayList<>();
                for(int j = 0; j < addresses.size(); j++){
                    String a = addresses.get(j);
                    doubles.add(a);
                    a += '1';
                    addresses.set(j, a);
                }
                for(int j = 0; j < doubles.size(); j++){
                    String a = doubles.get(j);
                    a += '0';
                    addresses.add(a);
                }
            }
        }

        for(int j = 0; j < addresses.size(); j++){
            String a = addresses.get(j);
            System.out.println(a);
            long integerValue = Long.parseLong(a, 2);
            table.put(integerValue, value);
        }
        System.out.println();
    }
}
