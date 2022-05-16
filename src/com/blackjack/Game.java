package com.blackjack;

public class Game {

    private Deck deck, discarded;
    private int wins, losses, pushes;
    private Dealer dealer;
    private Player player;

    public Game() {
        this.deck = new Deck(true);
        this.discarded = new Deck();
        this.dealer = new Dealer();
        this.player = new Player();
        this.deck.shuffleDeck();
        this.startRound();
        this.wins = 0;
        this.losses = 0;
        this.pushes = 0;
    }

    private void startRound() {
        if (this.wins > 0 || this.losses > 0 || this.pushes > 0) {
            System.out.println();
            System.out.println("Starting next round, wins: " + this.wins + ", losses: " + this.losses + ", pushes: " + this.pushes);
            this.player.getHand().discardHand(this.discarded);
            this.dealer.getHand().discardHand(this.discarded);
        }

        if (this.deck.deckSize() < 4) {
            this.deck.moveAllToDeck(this.discarded);
        }
        this.dealer.getHand().takeCardFromDeck(this.deck);
        this.dealer.getHand().takeCardFromDeck(this.deck);

        this.player.getHand().takeCardFromDeck(this.deck);
        this.player.getHand().takeCardFromDeck(this.deck);

        this.dealer.printFirstHand();
        this.player.printHand();

        //blackjack checks
        if (this.dealer.hasBlackJack()) {
           this.dealer.printHand();
           if (this.player.hasBlackJack()) {
               System.out.println("You both have 21 - Push");
               this.pushes++;
               this.startRound();
           } else {
               System.out.println("Dealer has blackjack. You lose.");
               this.dealer.printHand();
               this.losses++;
               this.startRound();
           }
        }

        if (this.player.hasBlackJack()) {
            System.out.println("You have blackjacK! You Won :)");
            this.wins++;
            this.startRound();
        }

        this.player.makeDecision(this.deck, this.discarded);
        if (player.getHand().calculatedValue() > 21) {
            System.out.println("You have gone over 21.");
            this.losses++;
            this.startRound();
        }

        this.dealer.printHand();
        while(dealer.getHand().calculatedValue() < 17) {
            this.dealer.hit(deck, discarded);
        }

        if (this.dealer.getHand().calculatedValue() > 21) {
            System.out.println("Dealer busts");
            this.wins++;
        } else if (this.dealer.getHand().calculatedValue() > this.player.getHand().calculatedValue()) {
            System.out.println("You lost");
            this.losses++;
        } else if(this.player.getHand().calculatedValue() > this.dealer.getHand().calculatedValue()) {
            System.out.println("You win!");
            this.wins++;
        } else System.out.println("Push");

        this.startRound();
    }

}
