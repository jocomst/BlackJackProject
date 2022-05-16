package com.blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    public void takeCardFromDeck(Deck deck) {
        this.hand.add(deck.takeCard());
    }

    public String toString() {
        String output = "";
        for (Card card: this.hand) {
            output += card + " - ";
        }

        return output;
    }

    public int calculatedValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card: this.hand) {
            value += card.getValue();

            if (card.getValue() == 11) {
                aceCount++;
            }
        }

        if (value > 0 && aceCount > 0) {
            while (aceCount > 0 && value > 21) {
                aceCount--;
                value -= 10;
            }
        }

        return value;
    }

    public Card getCard(int idx) {
        return this.hand.get(idx);
    }

    public void discardHand(Deck discardDeck) {
        discardDeck.addCards(this.hand);
        this.hand.clear();
    }


}
