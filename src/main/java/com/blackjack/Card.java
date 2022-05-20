package com.blackjack;

import java.util.Random;

public class Card {

    private Suits suit;
    private Values value;

    // create arrays for values and suits - need these to generate random cards
    private Values[] values = Values.values();
    private Random randomValues = new Random();
    private Suits[] suits = Suits.values();
    private Random randomSuits = new Random();

    public Card(Suits suit, Values value) {
        this.value = value;
        this.suit = suit;
    }

    public Card(Card card) {
        this.suit = card.getSuit();
        this.value = card.value;
    }

    // random card generated
    public Card() {
        this.suit = getRandomSuit();
    }

    public String toString() {
        return this.value + " of " + this.suit.toString() + "(" + this.value.value + ")";
    }

    public int getValue() {
        return this.value.value;
    }

    public Suits getSuit() {
        return this.suit;
    }

    public Suits getRandomSuit() {
        return suits[randomSuits.nextInt(values.length)];
    }
}