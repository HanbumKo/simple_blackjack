package com.cnu.blackjack;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Dealer extends Person {

    public Dealer(Deck deck) {
        super(deck);
    }

    /*
        Dealer must show a one card from dealerHand.
        In this, show card index 0
    */

    public void showOneCard() {
        System.out.println(hand.getHandList().get(0).getRankToString() + "    " + hand.getHandList().get(0).getSuitToString());
    }
}