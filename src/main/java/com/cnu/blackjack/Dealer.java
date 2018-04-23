package com.cnu.blackjack;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Dealer {

    private Hand dealerHand;

    /*
    In contructor, first, dealer draw two cards from deck.
    If score is less equal than 16, draw card until the score is higher than 16.
     */
    public Dealer(Deck deck) {
        this.dealerHand = new Hand(deck);
        dealerHand.drawCard();
        dealerHand.drawCard();
        while( getScore()<=16 ) {
            dealerHand.drawCard();
        }
    }

    public int getScore() {
        int score = 0;
        for( int i=0 ; i<dealerHand.getCurrentHandSize() ; i++ ) {
            score += dealerHand.getHandList().get(i).getRank();
        }
        return score;
    }

    /*
    Dealer must show a one card from dealerHand.
    In this, show card index 0
     */
    public void showOneCard() {
        System.out.println(dealerHand.getHandList().get(0).getRankToString() + "    " + dealerHand.getHandList().get(0).getSuitToString());
    }

}
