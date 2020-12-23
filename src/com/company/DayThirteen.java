package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DayThirteen {
    static ArrayList<String> input = new ArrayList<>();
    public static long getResults(){
        input = FileReader.getListOfStrings("./src/com/company/DayThirteenInput");

        return partTwo();
    }

    static long partTwo(){

        String[] r = input.get(1).split(",");
        ArrayList<Integer> rides = new ArrayList<>();
        for(int i = 0; i < r.length; i++){
            if(!r[i].contains("x")){
                rides.add(Integer.parseInt(r[i]));
            }else{
                rides.add(1);
            }
        }

        int highest = 19;
        boolean found = false;
        for(long i = 9_999_999_999_248L; !found; i+= rides.get(highest)){
            boolean soFarSoGood = true;
            for(int j = 0; j < rides.size() && soFarSoGood; j++){
                if (rides.get(j) == 1 || (i + j - highest) % rides.get(j) == 0) {

                }else{
                    soFarSoGood = false;
                }
            }
            if(soFarSoGood)
                return i - highest;
        }

        return 0;
    }

    static int partOne(){
        int earliest = Integer.parseInt(input.get(0));
        String[] r = input.get(1).split(",");
        ArrayList<Integer> rides = new ArrayList<>();
        for(int i = 0; i < r.length; i++){
            if(!r[i].contains("x")){
                rides.add(Integer.parseInt(r[i]));
            }
        }

        boolean found = false;
        for(int i = earliest; !found; i++){
            for(int j = 0; j < rides.size(); j++){
                if(i % rides.get(j) == 0){
                    return (i - earliest) * rides.get(j);
                }
            }
        }
        return 0;
    }
}
