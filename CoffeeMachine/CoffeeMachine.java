package com.company;

import java.util.Scanner;

public class CoffeeMachine {
    Scanner sc = new Scanner(System.in);
    String command = "";
    int amountOfCups;
    int possibleCups;
    final int[] neededWater = {250, 350, 200};
    final int[] neededMilk = {0, 75, 100};
    final int[] neededCoffeBeans = {16, 20, 12};
    final int[] price = {4, 7, 6};
    int water = 400;
    int milk = 540;
    int coffeBeans = 120;
    int cups = 9;
    int money = 550;
    int drink;
    String option;
    boolean runStatus;

    void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
    }

    void remaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

    void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeBeans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += sc.nextInt();
        System.out.println();
    }

    void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        option = sc.next();
        if (option.equals("1") || option.equals("2") || option.equals("3")) {
            drink = Integer.parseInt(option) - 1;
            if (water >= neededWater[drink] && milk >= neededMilk[drink] && coffeBeans >= neededCoffeBeans[drink] && cups >= 1) {
                water -= neededWater[drink];
                milk -= neededMilk[drink];
                coffeBeans -= neededCoffeBeans[drink];
                cups--;
                money += price[drink];
                System.out.println("I have enough resources, making you a coffee!");
            } else if (water <= neededWater[drink]) {
                System.out.println("Sorry, not enough water!");
            } else if (milk <= neededMilk[drink]) {
                System.out.println("Sorry, not enough milk!");
            } else if (coffeBeans <= neededCoffeBeans[drink]) {
                System.out.println("Sorry, not enough coffee beans!");
            } else if (cups <= 1) {
                System.out.println("Sorry, not enough disposable cups!");
            }
        }
        System.out.println();
    }

    void run() {
        runStatus=true;
        while (runStatus) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            command = sc.next();
            System.out.println();

            switch (command) {
                case "buy": {
                    this.buy();
                    break;
                }
                case "fill": {
                    this.fill();
                    break;
                }
                case "remaining": {
                    this.remaining();
                    break;
                }
                case "take": {
                    this.take();
                    break;
                }
                case "exit": {
                    runStatus=false;
                    break;
                }
            }

        }
    }
}