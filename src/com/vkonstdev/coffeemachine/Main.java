package com.vkonstdev.coffeemachine;

import java.util.Scanner;

public class Main {

    public static final int WATER_PER_CUP = 200;
    public static final int MILK_PER_CUP = 50;
    public static final int COFFEE_PER_CUP = 15;

    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need:");
        Scanner sc = new Scanner(System.in);
        int countCups = sc.nextInt();
        printMessage(countCups);
    }

    private static void printMessage(int countCups) {
        System.out.printf("For %d cups of coffee you will need:\n", countCups);
        System.out.printf("%d ml of water\n", countCups * WATER_PER_CUP);
        System.out.printf("%d ml of milk\n", countCups * MILK_PER_CUP);
        System.out.printf("%d g of coffee beans\n", countCups * COFFEE_PER_CUP);
    }
}
