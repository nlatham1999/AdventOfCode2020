package com.company;

import java.util.ArrayList;

public class DayTwoPartTwo {

    public static int getAnswer() {
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<Integer> firstPos = new ArrayList<>();
        ArrayList<Integer> secondPos = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        int count = 0;

        FileReader.getInputForDayTwo(passwords, characters, firstPos, secondPos);

        for(int i = 0; i < passwords.size(); i++){
            int first = firstPos.get(i);
            int second = secondPos.get(i);
            char c = characters.get(i);
            String password = passwords.get(i);

            if(password.charAt(first-1) == c && password.charAt(second-1) == c){

            }else if(password.charAt(first-1) == c){
                count++;
            }else if(password.charAt(second-1) == c){
                count++;
            }

        }

        return count;
    }
}
