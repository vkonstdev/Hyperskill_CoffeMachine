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

    public void printStateOfCoffeeMachine() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", waterQuantity);
        System.out.printf("%d ml of milk\n", milkQuantity);
        System.out.printf("%d g of coffee beans\n", coffeeQuantity);
        System.out.printf("%d disposable cups\n", cupsQuantity);
        System.out.printf("$%d of money\n", moneyQuantity);
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int water = Integer.parseInt(sc.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        int milk = Integer.parseInt(sc.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffee = Integer.parseInt(sc.nextLine());
        System.out.println("Write how many disposable cups you want to add:");
        int cups = Integer.parseInt(sc.nextLine());
        addIngredients(water, milk, coffee, cups);
    }

    private void addIngredients(int water, int milk, int coffee, int cups) {
        waterQuantity += water;
        milkQuantity += milk;
        coffeeQuantity += coffee;
        cupsQuantity += cups;
    }

    private void makeCupOfCoffee(Coffee cof) {
        if (waterQuantity < cof.water) {
            System.out.println("Sorry, not enough water!");
        } else if (milkQuantity < cof.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeQuantity < cof.coffee) {
            System.out.println("Sorry, not enough coffee!");
        } else if (coffeeQuantity < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            waterQuantity -= cof.water;
            milkQuantity -= cof.milk;
            coffeeQuantity -= cof.coffee;
            moneyQuantity += cof.cost;
            cupsQuantity--;
        }
    }

    public void take() {
        if (moneyQuantity > 0) {
            System.out.println("I gave you $" + moneyQuantity);
            moneyQuantity = 0;
        }
    }

    public void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Coffee cof = null;
        switch(sc.nextLine()) {
            case "1":
                cof = Coffee.ESPRESSO;
                break;
            case "2":
                cof = Coffee.LATTE;
                break;
            case "3":
                cof = Coffee.CAPPUCCINO;
                break;
            case "back":
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sc.nextLine());
        }
        if (cof != null) {
            makeCupOfCoffee(cof);
        }
    }

    public void chooseOperation() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String operation = sc.nextLine();
        switch (operation) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
            case "remaining" -> printStateOfCoffeeMachine();
            case "exit" -> exit();
        }
    }

    public void exit() {
        System.exit(0);
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
