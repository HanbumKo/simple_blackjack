package com.cnu.blackjack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class CalculatorTest {

    @Test
    public void J는_점수계산할때_10점으로_값이_정해져야한다() {
        List<Card> cardList = new ArrayList<Card>();
        Card J = new Card(11, Suit.DIAMOND);
        Calculator calculator = new Calculator();
        cardList.add(J);

        int result = Calculator.card_sum(cardList);
        assertTrue(result == 10);

    }

    @Test
    public void Q는_점수계산할때_10점으로_값이_정해져야한다() {
        List<Card> cardList = new ArrayList<Card>();
        Card J = new Card(11, Suit.DIAMOND);
        Calculator calculator = new Calculator();
        cardList.add(J);

        int result = Calculator.card_sum(cardList);
        assertTrue(result == 10);

    }

    @Test
    public void K는_점수계산할때_10점으로_값이_정해져야한다() {
        List<Card> cardList = new ArrayList<Card>();
        Card J = new Card(11, Suit.DIAMOND);
        Calculator calculator = new Calculator();
        cardList.add(J);

        int result = Calculator.card_sum(cardList);
        assertTrue(result == 10);

    }

    @Test
    public void 카드들의_랭크_합이_21이어야_한다() {
        List<Card> cardList = new ArrayList<Card>();
        cardList.add(new Card(11,Suit.DIAMOND));
        cardList.add(new Card(12,Suit.DIAMOND));
        cardList.add(new Card(1,Suit.DIAMOND));

        int result = Calculator.card_sum(cardList);
        assertTrue(result == 21);
    }
}
