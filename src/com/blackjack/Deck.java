package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public Deck(boolean makeDeck) {
        this.deck = new ArrayList<Card>();
        if (makeDeck) {
            for (Suits suit : Suits.values()) {
                for (Values value : Values.values()) {
                    this.deck.add(new Card(suit, value));
                }
            }
        }
    }

    public void createFullDeck() {
    }

    public void shuffleDeck(){
        ArrayList<Card> newDeck = new ArrayList<>();
        while(this.deck.size() > 0) {
            int card = (int) (Math.random() * this.deck.size() - 1);
            newDeck.add(this.deck.get(card));
            this.deck.remove(card);
        }
        this.deck = newDeck;

    }

    public Card getCard(int i){
        return this.deck.get(i);
    }

    public void removeCard(int i){
        this.deck.remove(i);
    }

    public void addCard(Card addCard) {
        this.deck.add(addCard);
    }
    public void addCards(ArrayList<Card> cards) {
        this.deck.addAll(cards);
    }
    // Get the size of the deck
    public int deckSize() {
        return this.deck.size();
    }

    // Draws from the deck
    public Card takeCard() {
       Card cardToTake = this.deck.get(0);
       this.deck.remove(0);
       return cardToTake;
    }

    // This will move cards back into the deck to continue playing
    public void moveAllToDeck(Deck moveTo) {
      this.addCards(moveTo.getCards());
      this.shuffleDeck();
      moveTo.emptyDeck();
        System.out.println("Ran out of cards, creating new from discard pile and shuffling them.");
    }

    public ArrayList<Card> getCards() {
        return this.deck;
    }

    public void emptyDeck() {
        this.deck.clear();
    }

    public boolean hasCards() {
        return this.deck.size() > 0;
    }

    public String toString() {
        String output = "";

        for (Card card: this.deck) {
            output += card;
            output += "\n";
        }

        return output;
    }


}