package com.cnu.blackjack;


import com.cnu.blackjack.exception.NoBalanceException;
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
        if(balance <= 0){
            throw new NoBalanceException();
        }
        if( bet > balance ) {
            throw new NoEnoughBalanceException();
        }
        balance = balance - bet;
        this.currentBet = bet;
    }

    public int getScore() {
        int score = 0;

        for( int i=0 ; i<playerHand.getCurrentHandSize() ; i++ ) {
            score += playerHand.getHandList().get(i).getRank();
        }
        return score;
    }

    public void showAllCards() {
        for( int i=0 ; playerHand.getCurrentHandSize() > i ; i++ ) {
            System.out.println(playerHand.getHandList().get(i).getRankToString() + "    " + playerHand.getHandList().get(i).getSuitToString());
        }
    }
}
