package com.cnu.blackjack;


import com.cnu.blackjack.exception.NoEnoughBalanceException;
import lombok.Data;

@Data
public class Player {

    private int balance;
    private int currentBet;
    private Hand playerHand;

    public Player(int balance, Deck deck) {
        this.balance = balance;
        this.playerHand = new Hand(deck);
        playerHand = new Hand(deck);

    }

    public void placeBet(int bet) {
        if( bet > balance ) {
            throw new NoEnoughBalanceException();
        }
        balance = balance - bet;
        this.currentBet = bet;
    }

    public int getScore() {
        return playerHand.calculate_card_sum();
    }

    public void showAllCards() {
        for( int i=0 ; playerHand.getCurrentHandSize() > i ; i++ ) {
            System.out.println(playerHand.getHandList().get(i).getRankToString() + "    " + playerHand.getHandList().get(i).getSuitToString());
        }
    }
}
