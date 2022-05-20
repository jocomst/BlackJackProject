package com.blackjack;

public class Money {
    private int balance;

    public Money() {
        this.balance = 100;
    }

    public int getBalance() {
        return this.balance;
    }

    public void lose(int amount) {
        this.balance -= amount;
    }

    public void win(int amount) {
        this.balance += amount;
    }





}
