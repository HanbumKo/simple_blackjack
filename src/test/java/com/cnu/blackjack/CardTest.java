package com.cnu.blackjack;

import com.cnu.blackjack.exception.NoRankException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CardTest {

    @Test
    public void 스페이드_1_카드를_생성할수_있다() {
        Card card = new Card(1, Suit.SPADE);
        int rank = card.getRank();
        Suit suit = card.getSuit();
        assertTrue(rank == 1);
        assertTrue(suit == Suit.SPADE);
    }

    @Test
    public void 하트_1_카드를_생성할수_있다() {
        Card card = new Card(1, Suit.HEART);
        int rank = card.getRank();
        Suit suit = card.getSuit();
        assertTrue(rank == 1);
        assertTrue(suit == Suit.HEART);
    }

    @Test
    public void 클럽_1_카드를_생성할수_있다() {
        Card card = new Card(1, Suit.CLUB);
        int rank = card.getRank();
        Suit suit = card.getSuit();
        assertTrue(rank == 1);
        assertTrue(suit == Suit.CLUB);
    }

    @Test
    public void 다이아몬드_1_카드를_생성할수_있다() {
        Card card = new Card(1, Suit.DIAMOND);
        int rank = card.getRank();
        Suit suit = card.getSuit();
        assertTrue(rank == 1);
        assertTrue(suit == Suit.DIAMOND);
    }

    @Test(expected = NoRankException.class)
    public void 카드의_랭크는_13_이하여야한다() {
        Card card = new Card(15, Suit.SPADE);
    }

    @Test
    public void 랭크를_스트링으로_변환할수있다() {
        Card card1 = new Card(1, Suit.DIAMOND);
        String stringOfCard1 = card1.getRankToString();
        assertTrue(stringOfCard1 instanceof String);
    }

    @Test
    public void 카드타입을_스트링으로_변환할수있다() {
        Card card1 = new Card(1, Suit.DIAMOND);
        String stringOfCard1 = card1.getSuitToString();
        assertTrue(stringOfCard1 instanceof String);
    }
}
