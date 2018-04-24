package com.cnu.blackjack;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class GameTest {

    @Test
    public void 게임인원을_설정할수_있다() {
        Game game = new Game(2, 2);
        int numberOfGamer = game.getNumberOfGamer();
        assertTrue(numberOfGamer==2);
    }

    @Test
    public void 게임인원을_플레이어리스트에_추가할수있다() {
        Game game = new Game(3, 2);
        game.addGamer();
        int numberOfGamer = game.getNumberOfGamer();
        assertTrue(numberOfGamer==4);
    }

    @Test
    public void 게임진행() {
        Game game = new Game(3, 2);
        game.playBlackjack();
    }
}
