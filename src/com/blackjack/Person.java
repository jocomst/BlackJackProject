package com.blackjack;

public abstract class Person {
    private Hand hand;
    private String name;
    private Money balance;

    public Person() {
        this.hand = new Hand();
        this.name = "";
        this.balance = new Money();
    }

    public boolean hasBlackJack() {
        return this.getHand().calculatedValue() == 21;
    }

    public void printHand() {
        System.out.println(this.name + "'s hand looks like this:");
        System.out.println(this.hand + " Valued at: " + this.hand.calculatedValue());
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hit(Deck deck, Deck discard) {
        if (!deck.hasCards()) {
            deck.moveAllToDeck(discard);
        }

        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        this.printHand();
    }

    public Money accountInfo() {
        return this.balance;
    }




}
