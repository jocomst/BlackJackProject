package com.blackjack;

import java.util.Scanner;

public class Player extends Person{

    private Scanner scanner = new Scanner(System.in);
    public Player() {
        super.setName("Player");
    }

    public void makeDecision(Deck deck, Deck discard) {
        int decision = 0;
        boolean getNum = true;

        while(getNum) {
            try {
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = scanner.nextInt();
                getNum = false;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
            System.out.println("You selected " + decision);
        }

        if (decision == 1) {
            this.hit(deck, discard);
            if (this.getHand().calculatedValue() > 20) return;
            this.makeDecision(deck, discard);
        } else System.out.println("You stand");
    }
}
