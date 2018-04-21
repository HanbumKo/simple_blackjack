package com.cnu.blackjack;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PlayerTest {

    @Test
    public void 플레이어는_히드머니를_가지고_생성할수있다() {
        Player player = new Player(5000);
        int balance = player.getBalance();
        assertTrue(balance == 5000);
    }

    @Test
    public void 플레이어는_배팅을_할수있다() {
        Player player = new Player(5000);
        player.placeBet(3000);
        int bat = player.getBalance();
        assertTrue(bat == 2000);
    }

    @Test(expected = Exception.class)
    public void 플레이어는_가진돈보다_많이_배팅할수없다() {
        Player player = new Player(5000);
        player.placeBet(10000);
    }
}
