package com.company;

import java.util.ArrayList;

public class DayTwelve {

    static ArrayList<String> commands = new ArrayList<>();
    static int heading = 0;
    static int xPos = 0;
    static int yPos = 0;

    public static int getResults(){

        commands = FileReader.getListOfStrings("./src/com/company/DayTwelveInput");

        return partTwo();
    }

    static int partTwo(){
        xPos = 0;
        yPos = 0;
        int wayPointX = 10;
        int wayPointY = 1;

        for(int i = 0; i < commands.size(); i++){
            char action = commands.get(i).charAt(0);
            int value = Integer.parseInt(commands.get(i).substring(1));
//            System.out.println(action + " " + value + " (" + xPos + "," + yPos + ") " + heading);
            switch (action) {
                case 'N':
                    wayPointY += value;
                    break;
                case 'S':
                    wayPointY -= value;
                    break;
                case 'E':
                    wayPointX += value;
                    break;
                case 'W':
                    wayPointX -= value;
                    break;
                case 'F':
                    xPos += wayPointX * value;
                    yPos += wayPointY * value;
                    break;
                case 'L':
                    value *= -1;
                case 'R':
                    int newWayPointX = wayPointX * (int) Math.cos(Math.toRadians(value)) + wayPointY * (int) Math.sin(Math.toRadians(value));
                    int newWayPointY = -wayPointX * (int) Math.sin(Math.toRadians(value)) + wayPointY * (int) Math.cos(Math.toRadians(value));
                    wayPointX = newWayPointX;
                    wayPointY = newWayPointY;
                    break;
                default:
                    System.out.println("unrecognized command");

            }
            System.out.println(xPos + " " + yPos + " " + wayPointX + " " + wayPointY + " \n");
        }

        System.out.println((int)(-.0000012));
        return Math.abs(xPos) + Math.abs(yPos);
    }

    static int partOne(){
        for(int i = 0; i < commands.size(); i++){
            char action = commands.get(i).charAt(0);
            int value = Integer.parseInt(commands.get(i).substring(1));
            System.out.println(action + " " + value + " (" + xPos + "," + yPos + ") " + heading);
            switch (action) {
                case 'N':
                    yPos += value;
                    break;
                case 'S':
                    yPos -= value;
                    break;
                case 'E':
                    xPos += value;
                    break;
                case 'W':
                    xPos -= value;
                    break;
                case 'F':
                    double frontX = value * (int)Math.cos(Math.toRadians(heading));
                    double frontY = value * (int)Math.sin(Math.toRadians(heading));
                    xPos += frontX;
                    yPos += frontY;
                    System.out.println(heading);
                    System.out.println(frontX);
                    System.out.println(frontY);
                    break;
                case 'L':
                    heading = (heading+value)%360;
                    break;
                case 'R':
                    heading = (heading-value)%360;
                    break;
                default:
                    System.out.println("unrecognized command");

            }
            System.out.println(xPos + " " + yPos + " " + heading + " \n");
        }

        System.out.println((int)(-.0000012));
        return Math.abs(xPos) + Math.abs(yPos);
    }
}
