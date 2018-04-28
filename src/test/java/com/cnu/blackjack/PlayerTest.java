package com.cnu.blackjack;

import com.cnu.blackjack.exception.NoEnoughBalanceException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PlayerTest {

    @Test
    public void 플레이어는_시드머니를_가지고_생성할수있다() {
        Deck deck = new Deck(2);
        Player player = new Player(5000, deck);
        int balance = player.getBalance();
        assertTrue(balance == 5000);
    }

    @Test
    public void 플레이어는_배팅을_할수있다() {
        Deck deck = new Deck(2);
        Player player = new Player(5000, deck);
        player.placeBet(3000);
        int bat = player.getBalance();
        assertTrue(bat == 2000);
    }

    @Test(expected = NoEnoughBalanceException.class)
    public void 플레이어는_가진돈보다_많이_배팅할수없다() {
        Deck deck = new Deck(2);
        Player player = new Player(5000, deck);
        player.placeBet(10000);
    }

    @Test
    public void 플레이어는_스코어를_계산할수있다() {
        Deck deck = new Deck(2);
        Player player = new Player(5000, deck);
        int playerScore = player.getScore();
        System.out.println(playerScore);
    }

    @Test
    public void 플레이어의_초기_상태는_ALIVE이다() {
        Player player = new Player(5000, new Deck(1));
        Status player_status = player.getStatus();
        assertTrue(player_status == Status.ALIVE);
    }

    @Test
    public void 플레이어는_hit을_하면_카드개수가_1장이_늘어난다() {
        Player player = new Player(5000, new Deck(1)); // 새로 만들어진 플레이어는 0장의 카드를 가짐
        player.hit();
        int numberOfCard = player.getPlayerHand().getHandList().size();
        assertTrue(numberOfCard == 1);
    }

    @Test
    public void 플레이어는_stand를_하면_상태가_STOP이_된다() {
        Player player = new Player(5000, new Deck(1));
        player.stand();
        Status player_status = player.getStatus();
        assertTrue(player_status == Status.STOP);
    }

    @Test
    public void 플레이어의_상태를_DEATH로_바꿀_수_있다() {
        Player player = new Player(5000, new Deck(1));
        player.set_status_if_bust();
        Status player_status = player.getStatus();
        assertTrue(player_status == Status.DEATH);
    }
}
