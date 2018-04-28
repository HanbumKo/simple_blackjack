package com.cnu.blackjack;


import com.cnu.blackjack.exception.NoEnoughBalanceException;
import lombok.Data;

@Data
public class Player extends Person {

    private int balance;
    private int currentBet;
    private Status status;

    public Player(int balance, Deck deck) {
        super(deck);
        this.balance = balance;
        this.status = Status.ALIVE;
    }

    public void placeBet(int bet) {
        if( bet > balance ) {
            throw new NoEnoughBalanceException();
        }
        balance = balance - bet;
        this.currentBet = bet;
    }

    public Status getStatus() {
        return status;
    }

    // Player selection
    public void hit() {
        hand.drawCard();
    }

    public void stand() {
        this.status = Status.STOP;
    }

    public void set_status_if_bust() {
        this.status = Status.BUST;
    }
}
