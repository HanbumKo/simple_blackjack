package com.cnu.blackjack;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Dealer {

    private Hand dealerHand;

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

    public void showOneCard() {
        System.out.println(dealerHand.getHandList().get(0).getRankToString() + "    " + dealerHand.getHandList().get(0).getSuitToString());
    }

}
