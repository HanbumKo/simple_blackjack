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
    

    public void showAllCards() {
        for( int i=0 ; hand.getCurrentHandSize() > i ; i++ ) {
            System.out.println(hand.getHandList().get(i).getRankToString() + "    " + hand.getHandList().get(i).getSuitToString());
        }
    }
}
