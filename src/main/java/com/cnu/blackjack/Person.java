package com.cnu.blackjack;

public abstract class Person {
    protected Hand hand;

    public Person(Deck deck) {
        this.hand = new Hand(deck);
    }

    public int getScore() {
        return hand.calculate_card_sum();
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
