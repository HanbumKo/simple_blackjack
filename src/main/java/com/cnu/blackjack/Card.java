package com.cnu.blackjack;

import com.cnu.blackjack.exception.NoRankException;
import lombok.Data;

@Data
public class Card {

    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit) {
        if( rank > 13 ) {
            throw new NoRankException();
        }
        this.rank = rank;
        this.suit = suit;
    }

    public String getRankToString(Card card) {
        switch( card.getRank() ) {
            case 1: return "Rank : 1";
            case 2: return "Rank : 2";
            case 3: return "Rank : 3";
            case 4: return "Rank : 4";
            case 5: return "Rank : 5";
            case 6: return "Rank : 6";
            case 7: return "Rank : 7";
            case 8: return "Rank : 8";
            case 9: return "Rank : 9";
            case 10: return "Rank : 10";
            case 11: return "Rank : 11";
            case 12: return "Rank : 12";
            case 13: return "Rank : 13";
            default: return "-----There is no appropriate rank number-----";
        }
    }

    public String getSuitToString(Card card) {
        switch( card.getSuit() ) {
            case DIAMOND: return "Suit : DIAMOND";
            case SPADE:   return "Suit : SPADE";
            case CLUB:    return "Suit : CLUB";
            case HEART:   return "Suit : HEART";
            default:      return "-----There is no aapropriate suit type-----";
        }
    }
}
