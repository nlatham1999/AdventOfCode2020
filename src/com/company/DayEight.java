package com.company;

import javafx.util.Pair;

import java.util.ArrayList;

public class DayEight {

    static int accumulator = 0;
    static ArrayList<Pair<String, Integer>> opcodes = new ArrayList<>();

    public static int getResults(){
        opcodes = FileReader.getOpCOde("./src/com/company/DayEightInput");

        return partTwo();
    }

    private static int partOne(){
        return runThroughOpCodes();
    }

    private static int partTwo(){
        for(int  i = 0; i < opcodes.size(); i++){
            if(opcodes.get(i).getKey().contains("nop")){
                opcodes.set(i, new Pair<>("jmp", opcodes.get(i).getValue()));
                if(runsToEnd()){
                    return runThroughOpCodes();
                }else{
                    opcodes.set(i, new Pair<>("nop", opcodes.get(i).getValue()));
                }
            }else if(opcodes.get(i).getKey().contains("jmp")){
                opcodes.set(i, new Pair<>("nop", opcodes.get(i).getValue()));
                if(runsToEnd()){
                    return runThroughOpCodes();
                }else{
                    opcodes.set(i, new Pair<>("jmp", opcodes.get(i).getValue()));
                }
            }
        }
        return 0;
    }

    private static int runThroughOpCodes(){
        accumulator = 0;

        ArrayList<Boolean> used = new ArrayList<>();
        for(int i = 0; i < opcodes.size(); i++){
            used.add(true);
        }

        int i = 0;
        while(i < opcodes.size() && used.get(i)){
            System.out.println(opcodes.get(i).getKey());
            if(opcodes.get(i).getKey().contains("nop")){
                used.set(i, false);
                i++;
            }else if(opcodes.get(i).getKey().contains("acc")){
                accumulator += opcodes.get(i).getValue();
                used.set(i, false);
                i++;
            }else if(opcodes.get(i).getKey().contains("jmp")){
                used.set(i, false);
                i += opcodes.get(i).getValue();
            }else{
                System.out.println("ERROR");
            }
        }


        return accumulator;
    }

    private static boolean runsToEnd(){

        ArrayList<Boolean> used = new ArrayList<>();
        for(int i = 0; i < opcodes.size(); i++){
            used.add(true);
        }

        int i = 0;
        while(i < opcodes.size() && used.get(i)){
            System.out.println(opcodes.get(i).getKey());
            if(opcodes.get(i).getKey().contains("nop")){
                used.set(i, false);
                i++;
            }else if(opcodes.get(i).getKey().contains("acc")){
                used.set(i, false);
                i++;
            }else if(opcodes.get(i).getKey().contains("jmp")){
                used.set(i, false);
                i += opcodes.get(i).getValue();
            }else{
                System.out.println("ERROR");
            }
        }

        if(i >= opcodes.size()){
            return true;
        }
        return false;
    }
}
