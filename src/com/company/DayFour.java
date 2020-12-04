package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayFour {
    public static int getResults(){
        return getResultFromPart();
    }

    public static int getResultFromPart(){
        int fields = 0;
        int count = 0;
        try {
            File myObj = new File("./src/com/company/DayFourInput");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.length() == 0){
                    if(fields > 6){
                        count++;
                    }
                    fields = 0;
                }else {
                    String[] temp1 = data.split(" ");
                    for (int i = 0; i < temp1.length; i++) {
                        String[] temp2 = temp1[i].split(":");
                        System.out.println(temp2[0] + " " + temp2[1]);
                        if (temp2[0].contains("byr") && Integer.parseInt(temp2[1]) <= 2002 && Integer.parseInt(temp2[1]) >= 1920) {
                            fields++;
                        }
                        if (temp2[0].contains("iyr") && Integer.parseInt(temp2[1]) <= 2020 && Integer.parseInt(temp2[1]) >= 2010) {
                            fields++;
                        }
                        if (temp2[0].contains("eyr") && Integer.parseInt(temp2[1]) <= 2030 && Integer.parseInt(temp2[1]) >= 2020) {
                            fields++;
                        }
                        if (temp2[0].contains("hgt")) {
                            if (temp2[1].contains("cm")) {
                                String[] temp3 = temp2[1].split("cm");
                                if (Integer.parseInt(temp3[0]) <= 193 && Integer.parseInt(temp3[0]) >= 150) {
                                    fields++;
                                }
                            } else if (temp2[1].contains("in")) {
                                String[] temp3 = temp2[1].split("in");
                                if (Integer.parseInt(temp3[0]) <= 76 && Integer.parseInt(temp3[0]) >= 59) {
                                    fields++;
                                }
                            }
                        }
                        if (temp2[0].contains("hcl") && temp2[1].length() == 7 && temp2[1].charAt(0) == '#' && isHexValue(temp2[1])) {
                            fields++;
                        }
                        if (temp2[0].contains("ecl") && (temp2[1].contains("amb") || temp2[1].contains("blu") ||
                                temp2[1].contains("brn") || temp2[1].contains("gry") || temp2[1].contains("grn") ||
                                temp2[1].contains("hzl") || temp2[1].contains("oth"))) {
                            fields++;
                        }
                        if (temp2[0].contains("pid") && temp2[1].length() == 9) {
                            fields++;
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return count;
    }

    private static boolean isHexValue(String str){
        for(int j = 1; j < str.length(); j++){
            if(Character.isDigit(str.charAt(j)) || (str.charAt(j) >= 'a' && str.charAt(j) <= 'f') ){
            }else{
                return false;
            }
        }
        return true;
    }
}
