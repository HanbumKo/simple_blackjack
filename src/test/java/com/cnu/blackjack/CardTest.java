package com.cnu.blackjack;

import com.cnu.blackjack.exception.NoRankException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CardTest {

    @Test
    public void 스페이드_10_카드를_생성할수_있다() {
        Card card = new Card(1, Suit.SPADE);
        int rank = card.getRank();
        Suit suit = card.getSuit();
        assertTrue(rank == 1);
        assertTrue(suit == Suit.SPADE);
    }

    @Test(expected = NoRankException.class)
    public void 카드의_랭크는_13_이하여야한다() {
        Card card = new Card(15, Suit.SPADE);
    }


}
