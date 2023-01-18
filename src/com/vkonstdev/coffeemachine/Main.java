package com.vkonstdev.coffeemachine;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine(400, 540, 120, 9, 550);
        while (true) {
            cm.chooseOperation();
        }
    }
}
