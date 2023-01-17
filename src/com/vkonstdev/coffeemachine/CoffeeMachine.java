package com.vkonstdev.coffeemachine;

public class CoffeeMachine {

    public static final int WATER_PER_CUP = 200;
    public static final int MILK_PER_CUP = 50;
    public static final int COFFEE_PER_CUP = 15;

    private int waterQuantity;
    private int milkQuantity;
    private int coffeeQuantity;

    public CoffeeMachine(int waterQuantity, int milkQuantity, int coffeeQuantity) {
        this.waterQuantity = waterQuantity;
        this.milkQuantity = milkQuantity;
        this.coffeeQuantity = coffeeQuantity;
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

    /*public void printMessage(int countCups) {
        System.out.printf("For %d cups of coffee you will need:\n", countCups);
        System.out.printf("%d ml of water\n", countCups * WATER_PER_CUP);
        System.out.printf("%d ml of milk\n", countCups * MILK_PER_CUP);
        System.out.printf("%d g of coffee beans\n", countCups * COFFEE_PER_CUP);
    }*/
    private int calculateAvailableCups() {
        return min(waterQuantity / WATER_PER_CUP, milkQuantity / MILK_PER_CUP, coffeeQuantity / COFFEE_PER_CUP);
    }

    private int min(int a, int b, int c) {
        return (a <= b && a <= c) ? a : (b <= a && b <= c) ? b : c;
    }

    public void printMessage(int countCups) {
        int availableCups = calculateAvailableCups();
        if (countCups == availableCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (countCups < availableCups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", availableCups - countCups);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", availableCups);
        }
    }
}
