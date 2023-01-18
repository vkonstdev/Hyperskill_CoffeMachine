package com.vkonstdev.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {

    public static final Scanner sc = new Scanner(System.in);

    private int waterQuantity;
    private int milkQuantity;
    private int coffeeQuantity;
    private int cupsQuantity;
    private int moneyQuantity;

    public CoffeeMachine(int waterQuantity, int milkQuantity, int coffeeQuantity, int cupsQuantity, int moneyQuantity) {
        this.waterQuantity = waterQuantity;
        this.milkQuantity = milkQuantity;
        this.coffeeQuantity = coffeeQuantity;
        this.cupsQuantity = cupsQuantity;
        this.moneyQuantity = moneyQuantity;
    }

    public int getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(int waterQuantity) {
        this.waterQuantity = waterQuantity;
    }

    public int getMilkQuantity() {
        return milkQuantity;
    }

    public void setMilkQuantity(int milkQuantity) {
        this.milkQuantity = milkQuantity;
    }

    public int getCoffeeQuantity() {
        return coffeeQuantity;
    }

    public void setCoffeeQuantity(int coffeeQuantity) {
        this.coffeeQuantity = coffeeQuantity;
    }

    public int getCupsQuantity() {
        return cupsQuantity;
    }

    public void setCupsQuantity(int cupsQuantity) {
        this.cupsQuantity = cupsQuantity;
    }

    public int getMoneyQuantity() {
        return moneyQuantity;
    }

    public void setMoneyQuantity(int moneyQuantity) {
        this.moneyQuantity = moneyQuantity;
    }

    /*private int calculateAvailableCups() {
        return min(waterQuantity / WATER_PER_CUP, milkQuantity / MILK_PER_CUP, coffeeQuantity / COFFEE_PER_CUP);
    }*/

    /*private int min(int a, int b, int c) {
        return (a <= b && a <= c) ? a : (b <= a && b <= c) ? b : c;
    }*/

    /*public void printMessage(int countCups) {
        int availableCups = calculateAvailableCups();
        if (countCups == availableCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (countCups < availableCups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", availableCups - countCups);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", availableCups);
        }
    }*/

    public void printStateOfCoffeeMachine() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", waterQuantity);
        System.out.printf("%d ml of milk\n", milkQuantity);
        System.out.printf("%d g of coffee beans\n", coffeeQuantity);
        System.out.printf("%d disposable cups\n", cupsQuantity);
        System.out.printf("$%d of money\n", moneyQuantity);
        System.out.println();
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffee = sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int cups = sc.nextInt();
        addIngredients(water, milk, coffee, cups);
    }

    private void addIngredients(int water, int milk, int coffee, int cups) {
        waterQuantity += water;
        milkQuantity += milk;
        coffeeQuantity += coffee;
        cupsQuantity += cups;
    }

    private void makeCupOfCoffee(Coffee cof) {
        waterQuantity -= cof.water;
        milkQuantity -= cof.milk;
        coffeeQuantity -= cof.coffee;
        moneyQuantity += cof.cost;
        cupsQuantity--;
    }

    public void take() {
        if (moneyQuantity > 0) {
            System.out.println("I gave you $" + moneyQuantity);
            moneyQuantity = 0;
        }
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        Coffee cof;
        switch(sc.nextInt()) {
            case 1 -> cof = Coffee.ESPRESSO;
            case 2 -> cof = Coffee.LATTE;
            case 3 -> cof = Coffee.CAPPUCCINO;
            default -> throw new IllegalStateException("Unexpected value: " + sc.nextInt());
        }
        makeCupOfCoffee(cof);
    }

    public void chooseOperation() {
        System.out.println("Write action (buy, fill, take):");
        String operation = sc.nextLine();
        switch (operation) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
        }
    }

    private enum Coffee {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        private final int water;
        private final int milk;
        private final int coffee;
        private final int cost;

        Coffee(int water, int milk, int coffee, int cost) {
            this.water = water;
            this.milk = milk;
            this.coffee = coffee;
            this.cost = cost;
        }
    }
}
