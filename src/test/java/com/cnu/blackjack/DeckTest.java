package com.cnu.blackjack;

import com.cnu.blackjack.exception.noMoreCardException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeckTest {

    @Test
    public void 하나의_덱은_총_52장의_카드를가진다() {
        Deck deck = new Deck(1);
        int totalCardCount = deck.getTotalCardCount();
        assertTrue(totalCardCount==52);
    }

    @Test
    public void 세게의_덱은_총_156장의_카드를가진다() {
        Deck deck = new Deck(3);
        int totalCardCount = deck.getTotalCardCount();
        assertTrue(totalCardCount==156);
    }

    @Test
    public void 하나의_덱에서_카드한장을뽑으면_51장의_카드가_남아야한다() {
        Deck deck = new Deck(1);
        deck.drawCard();
        int totalCardCount = deck.getTotalCardCount();
        assertTrue(totalCardCount==51);
    }

    @Test(expected = noMoreCardException.class)
    public void 하나의_덱에서_모든카드를_뽑으면_에러가_발생해야한다() {
        Deck deck = new Deck(1);
        for( int i=1 ; i<=53 ; i++ )
            deck.drawCard();
        int totalCardCount = deck.getTotalCardCount();
    }
}
