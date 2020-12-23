package com.company;

import java.util.ArrayList;

public class DayEleven {

    static ArrayList<String> seating = new ArrayList<>();

    public static int getResults(){
        seating = FileReader.getListOfStrings("./src/com/company/DayElevenInput");

        ArrayList<String> newSeating = getReorder();

        while(!seating.equals(newSeating)){
            seating = newSeating;
            newSeating = getReorder();
        }


        return getOccupied();
    }

    static int getOccupied(){
        int count = 0;
        for(int i = 0; i < seating.size(); i++){
            for(int j = 0; j < seating.get(i).length(); j++){
                if(seating.get(i).charAt(j) == '#'){
                    count++;
                }
            }
        }
        return count;
    }

    static ArrayList<String> getReorder(){
        ArrayList<String> newSeating = new ArrayList<>();
        for(int i = 0; i < seating.size(); i++){
            String row = "";
            for(int j = 0; j < seating.get(i).length(); j++){
//                int neighbors = getNeighbors(i, j);
                int neighbors = getNeighbors2(i, j);
                if(seating.get(i).charAt(j) == 'L'){
                    if(neighbors == 0)
                        row += '#';
                    else
                        row += 'L';
                }else if(seating.get(i).charAt(j) == '#'){
                    if(neighbors >= 5)
                        row += 'L';
                    else
                        row += '#';
                } else {
                    row += seating.get(i).charAt(j);
                }
            }
            newSeating.add(row);
        }
        return newSeating;
    }

    static int getNeighbors2(int i, int j){
        int neighbors = 0;
        boolean found = false;
        int tempI = i;
        int tempJ = j;

        //look for the top left diagonal
        while(tempI > 0 && tempJ > 0 && !found){
            if(seating.get(tempI-1).charAt(tempJ-1) == '#'){
                neighbors++;
                found = true;
            }else if(seating.get(tempI-1).charAt(tempJ-1) == 'L'){
                found = true;
            }else{
                tempI --;
                tempJ --;
            }
        }

        //look upwards
        tempI = i;
        found = false;
        while(tempI > 0 && !found){
            if(seating.get(tempI-1).charAt(j) == '#'){
                neighbors++;
                found = true;
            }else if(seating.get(tempI-1).charAt(j) == 'L'){
                found = true;
            }else{
                tempI --;
            }
        }

        //look top right diagonal
        tempI = i;
        tempJ = j;
        found = false;
        while(tempI > 0 && tempJ < seating.get(tempI).length()-1 && !found){
            if(seating.get(tempI-1).charAt(tempJ+1) == '#'){
                neighbors++;
                found = true;
            }else if(seating.get(tempI-1).charAt(tempJ+1) == 'L'){
                found = true;
            }else{
                tempI --;
                tempJ ++;
            }
        }

        //look left
        tempJ = j;
        found = false;
        while(tempJ > 0 && !found){
            if(seating.get(i).charAt(tempJ-1) == '#'){
                neighbors++;
                found = true;
            }else if(seating.get(i).charAt(tempJ-1) == 'L'){
                found = true;
            }else{
                tempJ --;
            }
        }

        //look right
        tempJ = j;
        found = false;
        while(tempJ < seating.get(i).length()-1 && !found){
            if(seating.get(i).charAt(tempJ+1) == '#'){
                neighbors++;
                found = true;
            }else if(seating.get(i).charAt(tempJ+1) == 'L'){
                found = true;
            }else{
                tempJ ++;
            }
        }

        //look bottom left
        tempI = i;
        tempJ = j;
        found = false;
        while(tempI < seating.size()-1 && tempJ > 0 && !found){
            if(seating.get(tempI+1).charAt(tempJ-1) == '#'){
                neighbors++;
                found = true;
            }else if(seating.get(tempI+1).charAt(tempJ-1) == 'L'){
                found = true;
            }else{
                tempI ++;
                tempJ --;
            }
        }

        //look bottom
        tempI = i;
        found = false;
        while(tempI < seating.size()-1 && !found){
            if(seating.get(tempI+1).charAt(j) == '#'){
                neighbors++;
                found = true;
            }else if(seating.get(tempI+1).charAt(j) == 'L'){
                found = true;
            }else{
                tempI ++;
            }
        }

        //look bottom right
        tempI = i;
        tempJ = j;
        found = false;
        while(tempI < seating.size()-1 && tempJ < seating.get(i).length()-1 && !found){
            if(seating.get(tempI+1).charAt(tempJ+1) == '#'){
                neighbors++;
                found = true;
            }else if(seating.get(tempI+1).charAt(tempJ+1) == 'L'){
                found = true;
            }else{
                tempI ++;
                tempJ ++;
            }
        }

        return neighbors;
    }

    static int getNeighbors(int i, int j){
        System.out.println(i + " " + j);
        int neighbors = 0;
        if(i > 0){
            if(j > 0){
                if(seating.get(i-1).charAt(j-1) == '#') {
                    neighbors++;
                }
            }
            if(seating.get(i-1).charAt(j) == '#'){
                neighbors++;
            }
            if(j < seating.get(i-1).length() - 1){
                if(seating.get(i-1).charAt(j+1) == '#'){
                    neighbors++;
                }
            }
        }
        if(j > 0){
            if(seating.get(i).charAt(j-1) == '#'){
                neighbors++;
            }
        }
        if(j < seating.get(i).length() - 1){
            if(seating.get(i).charAt(j+1) == '#'){
                neighbors++;
            }
        }
        if(i < seating.size()-1){
            if(j > 0){
                if(seating.get(i+1).charAt(j-1) == '#') {
                    neighbors++;
                }
            }
            if(seating.get(i+1).charAt(j) == '#'){
                neighbors++;
            }
            if(j < seating.get(i+1).length() - 1){
                if(seating.get(i+1).charAt(j+1) == '#'){
                    neighbors++;
                }
            }
        }
        return neighbors;
    }
}
