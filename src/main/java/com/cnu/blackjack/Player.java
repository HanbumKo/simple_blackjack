package com.cnu.blackjack;


import com.cnu.blackjack.exception.NoEnoughBalanceException;
import lombok.Data;

@Data
public class Player {

    private int balance;
    private int currentBet;
    private Hand playerHand;
    private Status status;

    public Player(int balance, Deck deck) {
        this.balance = balance;
        this.playerHand = new Hand(deck);
        playerHand = new Hand(deck);
        status = Status.ALIVE;
    }

    public void placeBet(int bet) {
        if( bet > balance ) {
            throw new NoEnoughBalanceException();
        }
        balance = balance - bet;
        this.currentBet = bet;
    }

    public void showAllCards() {
        for( int i=0 ; playerHand.getCurrentHandSize() > i ; i++ ) {
            System.out.println(playerHand.getHandList().get(i).getRankToString() + "    " + playerHand.getHandList().get(i).getSuitToString());
        }
    }

    public Status getStatus() {
        return status;
    }

    public int getScore() {
        return playerHand.calculate_card_sum();
    }


    // Player selection
    public void hit() {
        playerHand.drawCard();
    }

    public void stand() {
        this.status = Status.STOP;
    }

    public void set_status_if_bust() {
        this.status = Status.DEATH;
    }
}
