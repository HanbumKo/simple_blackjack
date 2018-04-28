package com.cnu.blackjack;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class GameTest {

    @Test
    public void 게임을_기본으로_설정값은_플레이어_한명과_덱_한개이다() {
        Game game = new Game();
        int numberOfGamer = game.getNumberOfGamer();
        int numberOfDeckOfCard = game.getDeck().getTotalCardCount();
        assertTrue(numberOfGamer == 1);
        assertTrue(numberOfDeckOfCard == 52); // 덱 1개는 52장의 카드를 가진다.
    }

    @Test
    public void 게임인원을_설정할수_있다() {
        Game game = new Game();
        game.setNumberOfGamer(3);
        int numberOfGamer = game.getNumberOfGamer();
        assertTrue(numberOfGamer==3);
    }

    @Test
    public void 게임인원을_플레이어리스트에_추가할수있다() {
        Game game = new Game();
        game.addGamer();
        int numberOfGamer = game.getNumberOfGamer();
        assertTrue(numberOfGamer==2);
    }

    @Test
    public void 게임진행() {
        Game game = new Game();
        game.playBlackjack();
    }
}
