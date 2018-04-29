package com.cnu.blackjack;

import lombok.Data;
//import sun.jvm.hotspot.types.basic.BasicOopField;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {

    private int numberOfGamer;
    private Deck deck;
    private List<Player> playerList;
    private Dealer dealer;


    // Constructor
    public Game(int numberOfGamer, int numberOfDeck) {
        this.numberOfGamer = numberOfGamer;
        this.deck = new Deck(numberOfDeck);
        playerList = new ArrayList<>();
        dealer = new Dealer(this.deck);
        for( int i=1 ; i<=numberOfGamer ; i++ ) {
            playerList.add(new Player(50000, deck));
        }
    }


    // Game Play
    public void playBlackjack() {
        dealerGetTwoCard();
        playersGetTwoCard();

        while( dealerScoreIsUnder17() ) {
            dealerGetOneCard();
        }

        if( dealerIsBlackjack() ) {
            playersLostMoney();
            return;
        }
        else if( dealerIsBurst() ) {
            playersGetMoney();
            return;
        }


        dealerShowOneCard();
        showPlayersCard();
        showOtherPlayersCard();
        askPlayerHitOrStand();

    }

    // public methods
    public Boolean addGamer(int balance) {
        numberOfGamer++;
        return playerList.add(new Player(balance, deck));
    }

    // private methods
    private void dealerGetTwoCard() {
        dealer.getDealerHand().drawCard();
        dealer.getDealerHand().drawCard();
    }

    private void dealerGetOneCard() {
        dealer.getDealerHand().drawCard();
    }

    private void playersGetTwoCard() {
        for( int i=0 ; i<numberOfGamer ; i++ ) {
            playerList.get(i).getPlayerHand().drawCard();
            playerList.get(i).getPlayerHand().drawCard();
        }
    }

    private void playerGetOneCard() {
        for( int i=0 ; i<numberOfGamer ; i++ ) {
            playerList.get(i).getPlayerHand().drawCard();
        }
    }

    private void dealerShowOneCard() {
        System.out.println("dealer has : ");
        dealer.showOneCard();
        for( int i=1 ; i<dealer.getDealerHand().getCurrentHandSize() ; i++ ) {
            System.out.println("[Invisible Card]");
        }
        System.out.println("_______________________________________");
    }

    private void showPlayersCard() {
        System.out.println("You have : ");
        playerList.get(0).showAllCards();
        System.out.println("_______________________________________");

    }

    private Boolean dealerIsBlackjack() {
        if( dealer.getScore() == 21 ) {
            System.out.println("Dealer is blackjack!!");
            System.out.println("_______________________________________");
            return true;
        }
        else {
            return false;
        }
    }

    private Boolean dealerIsBurst() {
        if( dealer.getScore() > 21 ) {
            System.out.println("Dealer is burst");
            System.out.println("_______________________________________");
            return true;
        }
        else {
            return false;
        }
    }

    private void playersLostMoney() {
        for( int i=0 ; i<numberOfGamer ; i++ ) {
            playerList.get(i).setBalance(playerList.get(i).getBalance() - playerList.get(i).getCurrentBet());
        }
    }

    private void playersGetMoney() {
        for( int i=0 ; i<numberOfGamer ; i++ ) {
            playerList.get(i).setBalance(playerList.get(i).getBalance() + playerList.get(i).getCurrentBet()*2);
        }
    }

    private Boolean dealerScoreIsUnder17() {
        return dealer.getScore()<17;
    }

    private void showOtherPlayersCard() {
        for( int i=1 ; i<numberOfGamer ; i++ ) {
            System.out.println("Other Players have : ");
            playerList.get(i).showAllCards();
        }
        System.out.println("_______________________________________");
    }

    private void askPlayerHitOrStand() {
        System.out.println("1. Hit");
        System.out.println("2. Stand");
    }
}
