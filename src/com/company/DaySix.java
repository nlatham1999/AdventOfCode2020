package com.company;

import java.util.ArrayList;
import java.util.Map;

public class DaySix {

    public static int getResults(){
        return partTwo();



    }

    private static int partTwo(){

        int count = 0;
        ArrayList<String> list = FileReader.getListOfStrings("./src/com/company/DaySixInput");
        ArrayList<String> group = new ArrayList<>();


        for(int i =0; i < list.size(); i++){
            System.out.println(list.get(i));


            if(list.get(i).length() == 0){
                if(group.size() > 0){
                    for(int j = 0; j < group.get(0).length(); j++){
                        boolean inAll = true;
                        for(int k = 0; k < group.size() && inAll; k++){
                            if(!group.get(k).contains(String.valueOf(group.get(0).charAt(j)))){
                                inAll = false;
                            }
                        }
                        if(inAll){
                            count++;
                        }
                    }
                }


                group = new ArrayList<>();
                System.out.println(count);
            }else{
                group.add(list.get(i));
            }
        }

        return count;
    }

    private static int partOne(){
        int count = 0;
        ArrayList<String> list = FileReader.getListOfStrings("./src/com/company/DaySixInput");
        ArrayList<Character> found = new ArrayList<>();


        for(int i =0; i < list.size(); i++){
            System.out.println(list.get(i));


            if(list.get(i).length() == 0){
                found = new ArrayList<>();
                System.out.println(count);
            }else{
                for(int j = 0; j < list.get(i).length(); j++){
                    if(!found.contains(list.get(i).charAt(j))){
                        found.add(list.get(i).charAt(j));
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
