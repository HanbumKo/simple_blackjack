package com.cnu.blackjack;


import com.cnu.blackjack.exception.NoEnoughBalanceException;
import lombok.Data;

@Data
public class Player {

    private int balance;
    private int currentBet;

    public Player(int balance) {
        this.balance = balance;
    }

    public void placeBet(int bet) {
        if( bet > balance ) {
            throw new NoEnoughBalanceException();
        }
        balance = balance - bet;
        this.currentBet = bet;
    }
}
