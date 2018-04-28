package com.cnu.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SituationTest {
    Deck deck;
    Player player;
    Dealer dealer;

    @Before
    public void 플레이어와_딜러_세팅() {
        deck = new Deck(1);
        player = new Player(5000, deck);
        dealer = new Dealer(deck);
    }

    @Test
    public void 플레이어의_카드_합이_딜러의_카드_합보다_작으면_딜러가_이긴다() {
        dealer.getDealerHand().getHandList().add(new Card(10, Suit.SPADE));
        dealer.getDealerHand().getHandList().add(new Card(10, Suit.SPADE));

        player.getPlayerHand().getHandList().add(new Card(1, Suit.SPADE));
        player.getPlayerHand().getHandList().add(new Card(1, Suit.SPADE));

        assertTrue(Situation.who_win(dealer, player) == Situation.result.DEALER_WIN);
    }

    @Test
    public void 플레이어의_카드_합이_딜러의_카드_합보다_크면_플레이어가_이긴다() {
        dealer.getDealerHand().getHandList().add(new Card(1, Suit.SPADE));
        dealer.getDealerHand().getHandList().add(new Card(1, Suit.SPADE));

        player.getPlayerHand().getHandList().add(new Card(10, Suit.SPADE));
        player.getPlayerHand().getHandList().add(new Card(10, Suit.SPADE));

        assertTrue(Situation.who_win(dealer, player) == Situation.result.PLAYER_WIN);
    }

    @Test
    public void 플레이어의_카드_합이_딜러의_카드_합이_같으면_비긴다() {
        dealer.getDealerHand().getHandList().add(new Card(10, Suit.SPADE));
        dealer.getDealerHand().getHandList().add(new Card(10, Suit.SPADE));

        player.getPlayerHand().getHandList().add(new Card(10, Suit.SPADE));
        player.getPlayerHand().getHandList().add(new Card(10, Suit.SPADE));

        assertTrue(Situation.who_win(dealer, player) == Situation.result.DRAW);
    }
}
