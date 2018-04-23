package com.cnu.blackjack;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DealerTest {

    @Test
    public void 딜러는_17에서_25사이의_점수를_반환한다() {
        Deck deck = new Deck(2);
        Dealer dealer = new Dealer(deck);
        int score = dealer.getScore();
        assertTrue(score > 17 && score < 25);
    }




}
