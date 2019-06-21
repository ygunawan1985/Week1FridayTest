package com.example.week1codingtest;

import java.util.Scanner;

public class Q2ArmstrongFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number to check: ");
        int aNumber = scanner.nextInt();
        if(isArmstrong(aNumber)){
            System.out.println(aNumber + " is an Armstrong number!");
        } else {
            System.out.println(aNumber + " is NOT an Armstrong number");
        }
    }

    public static boolean isArmstrong(int number) {
        int inputNumber = number;
        int remainder = 0;
        int result = 0;

        while(inputNumber != 0) {
            remainder = inputNumber % 10;
            result = result + cube(remainder);
            inputNumber = inputNumber / 10;
        }

        if (result == number)
            return true;
        else
            return false;
    }

    public static int cube(int number) {
        return number * number * number;
    }

}
