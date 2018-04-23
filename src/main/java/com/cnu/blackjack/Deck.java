package com.cnu.blackjack;

import com.cnu.blackjack.exception.noMoreCardException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void shuffle() {
        Random random = new Random();
        int randomIndexNumber;
        for( int i=0 ; i<cardList.size()*8 ; i++ ) {
            randomIndexNumber = random.nextInt(cardList.size());
            Card tempCard = cardList.get(randomIndexNumber);
            cardList.remove(randomIndexNumber);
            cardList.add(tempCard);
        }
    }

    public void showAllCardsList() {
        for( int i=0 ; i<cardList.size() ; i++ ) {
            System.out.println(cardList.get(i).getRankToString() + "    " + cardList.get(i).getSuitToString());
        }
    }
}
