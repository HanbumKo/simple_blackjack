package com.cnu.blackjack;

import com.cnu.blackjack.exception.noMoreCardException;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private int numberOfDeck;
    private List<Card> cardList;

    public Deck(int numberOfDeck) {
        this.numberOfDeck = numberOfDeck;
        this.cardList = new ArrayList<Card>();
        for( int j=0 ; j<numberOfDeck ; j++ ) {
            for (int i = 1; i < 14; i++) {
                for (Suit suit : Suit.values()) {
                    cardList.add(new Card(i, suit));
                }
            }
        }
    }

    public int getTotalCardCount() {
        return cardList.size();
    }

    public Card drawCard() {
        if( cardList.size() == 0 ) {
            throw new noMoreCardException();
        }
        return cardList.remove(0);
    }
}
