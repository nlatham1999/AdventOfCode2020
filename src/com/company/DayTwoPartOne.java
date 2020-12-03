package com.company;

import java.util.ArrayList;


public class DayTwoPartOne {

    public static int getAnswer() {
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<Integer> charMin = new ArrayList<>();
        ArrayList<Integer> charMax = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        int count = 0;

        FileReader.getInputForDayTwo(passwords, characters, charMin, charMax);

        for(int i = 0; i < passwords.size(); i++){
            int min = charMin.get(i);
            int max = charMax.get(i);
            char c = characters.get(i);
            String password = passwords.get(i);

            int numOfChar = 0;
            for(int j = 0; j < password.length(); j++){
                if(password.charAt(j) == c){
                    numOfChar++;
                }
            }

            if(numOfChar <= max && numOfChar >= min){
                count++;
            }

        }

        return count;
    }

}
