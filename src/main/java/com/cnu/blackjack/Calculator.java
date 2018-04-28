package com.cnu.blackjack;

import java.util.List;

public class Calculator {

    public static int card_sum(List<Card> handList) {
        int result = 0;

        for( int i=0 ; i<handList.size() ; i++ ) {
            int current_card_rank = handList.get(i).getRank();

            switch (current_card_rank) {
                case 11:
                case 12:
                case 13:
                    result += 10;
                    break;

                default:
                    result += current_card_rank;
                    break;
            }
        }

        return result;
    }
}
