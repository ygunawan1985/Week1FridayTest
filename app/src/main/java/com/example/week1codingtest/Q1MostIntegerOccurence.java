package com.example.week1codingtest;

public class Q1MostIntegerOccurence {

    public static void main(String[] args) {

        int[] numbers = new int[10];
        numbers[0] = 2;
        numbers[1] = 3;
        numbers[2] = 3;
        numbers[3] = 5;
        numbers[4] = 10;
        numbers[5] = 20;
        numbers[6] = 20;
        numbers[7] = 20;
        numbers[8] = 15;
        numbers[9] = 1;

        int mostFrequentNumber = findMostOccurence(numbers);
        System.out.println("The most frequent number is: " + mostFrequentNumber);
    }

    public static int findMostOccurence(int[] numbers) {
        int mostfrequent = numbers[0];
        int previousNumber = numbers[0], count = 1, popularCount = 1;

        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] == previousNumber) {
                count++;
            } else {
                if(count > popularCount){
                    popularCount = count;
                    mostfrequent = numbers[i-1];
                }
                previousNumber = numbers[i];
                count = 1;
            }
        }

        if (count > popularCount){
            return numbers[numbers.length - 1];
        } else {
            return mostfrequent;
        }
    }
}
