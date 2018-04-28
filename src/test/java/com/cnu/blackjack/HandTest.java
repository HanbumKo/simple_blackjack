package com.cnu.blackjack;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class HandTest {

    @Test
    public void 핸드는_카드를_한장씩_받을수_있다() {
        Hand hand = new Hand(new Deck(1));
        Card card = hand.drawCard();
        int handSize = hand.getCurrentHandSize();
        assertTrue(card != null);
        assertTrue(handSize == 1);
    }


    // 해당 테스트는 그냥 카드를 더 할때는 JQK가 10으로 변환이 안된다.
    // 하지만 계산기는 10으로 변환을 해주기 때문에
    // 결과가 다를 수도 있다.
    // 좀더 나은 테스트 방법을 찾는게 좋을듯함.
    /*
    @Test
    public void 뽑은_카드들의_합과_핸드의_카드들의_합_계산기의_결과는_같아야한다() {
        Hand hand = new Hand(new Deck(1));
        Card card1 = hand.drawCard();
        Card card2 = hand.drawCard();

        int card_sum = card1.getRank() + card2.getRank();
        int calculator_result = hand.calculate_card_sum();
        assertTrue(card_sum == calculator_result);
    }
    */
}
