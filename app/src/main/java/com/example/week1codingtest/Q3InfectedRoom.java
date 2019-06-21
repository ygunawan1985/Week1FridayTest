package com.example.week1codingtest;

public class Q3InfectedRoom {

    public static void main(String[] args) {

        Room[][] verticalTrue = new Room[][] {
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new
                        Room(true), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) }
        };

        if(isOutbreak(verticalTrue))
            System.out.println("The room is infected because 5 or more connected rooms are infected!");
        else
            System.out.println("The room is free of infection!");
    }

    public static boolean isOutbreak(Room[][] floor) {
        int countRight = 0;
        int countLeft = 0;
        int countTop = 0;
        int countBottom = 0;

        for(int i = 0; i < floor.length; i++) {
            for(int j = 0; j < floor[i].length; j++) {
                if(floor[i][j].isInfected){
                    countRight += checkRight(floor, i, j);
                    countLeft += checkLeft(floor, i, j);
                    countBottom += checkBottom(floor, i, j);
                    countTop += checkTop(floor, i, j);
                }

            }
        }

        if(countTop >= 5 || countBottom >= 5 || countLeft >= 5 || countRight >= 5)
            return true;
        else
            return false;
    }

    public static int checkRight(Room[][] floor, int i, int j){
        int count = 0;
        if(j != floor[0].length - 1){
            if(floor[i][j+1].isInfected){
                return count += 1 + checkRight(floor, i, j+1);
            }
        }

        return 0;
    }

    public static int checkLeft(Room[][] floor, int i, int j){
        int count = 0;
        if(j != 0){
            if(floor[i][j-1].isInfected){
                return count += 1 + checkLeft(floor, i, j-1);
            }
        }

        return 0;
    }

    public static int checkTop(Room[][] floor, int i, int j){
        int count = 0;
        if(i != 0){
            if(floor[i-1][j].isInfected){
                return count += 1 + checkTop(floor, i-1, j);
            }
        }

        return 0;
    }

    public static int checkBottom(Room[][] floor, int i, int j){
        int count = 0;
        if(i != floor.length + 1){
            if(floor[i+1][j].isInfected){
                return count += 1 + checkTop(floor, i+1, j);
            }
        }

        return 0;
    }

}