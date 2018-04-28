package com.cnu.blackjack;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DealerTest {

    @Test
    public void 딜러는_17이상의_점수를_반환한다() {
        Deck deck = new Deck(2);
        Dealer dealer = new Dealer(deck);
        dealer.getDealerHand().drawCard();
        dealer.getDealerHand().drawCard();
        while( dealer.getScore()<17 ) {
            dealer.getDealerHand().drawCard();
        }

        int score = dealer.getScore();
        assertTrue(score >= 17);
    }

    @Test
    public void 딜러는_카드를_한장_보여준다() {
        Deck deck = new Deck(2);
        Dealer dealer = new Dealer(deck);
        dealer.getDealerHand().drawCard();
        dealer.getDealerHand().drawCard();
        dealer.showOneCard();
    }
}
