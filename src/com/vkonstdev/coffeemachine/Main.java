package com.vkonstdev.coffeemachine;

public class Main {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int countCups = sc.nextInt();*/
        CoffeeMachine cm = new CoffeeMachine(400, 540, 120, 9, 550);
        while (true) {
            cm.chooseOperation();
        }
        //cm.printStateOfCoffeeMachine();

    }
}
