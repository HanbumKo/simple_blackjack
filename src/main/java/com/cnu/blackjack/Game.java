package com.cnu.blackjack;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class Game {
    
    private int numberOfGamer;
    private Deck deck;
    private List<Player> playerList;
    private Dealer dealer;


    // Constructor
    public Game() {
        playerList = new ArrayList<>();
        default_setting();
        dealer = new Dealer(this.deck);

    }

    // Game Setting (The number of Deck and Player)
    public void default_setting() {
        set_NumberOfDeck(1);
        set_NumberOfGamer(1);
    }

    public void set_NumberOfDeck(int numberOfDeck) {
        this.deck = new Deck(numberOfDeck);
    }

    public void set_NumberOfGamer(int numberOfGamer) {
        this.numberOfGamer = numberOfGamer;
        for( int i = 0 ; i < numberOfGamer ; i++ ) {
            playerList.add(new Player(50000, this.deck));
        }
    }
    
    public Boolean addGamer() {
        numberOfGamer++;
        return playerList.add(new Player(50000, deck));
    }

    // Game Play
    public void playBlackjack() {
        betting();

        dealerGetTwoCard();
        playersGetTwoCard();

        dealerShowOneCard();

        players_turn();

        dealer_turn();

        dealerShowAllCard_and_Score();

        conclude_the_game();

        show_score_board();
    }

    private void betting() {
        System.out.println("===============[BETTING]===============");
        for (int i = 0; i < numberOfGamer; i++) {
            Player player = playerList.get(i);
            Scanner sc = new Scanner(System.in);
            System.out.print("\t PLAYER " + (i+1) + "'s bet : ");
            int betting_money = sc.nextInt();
            player.setCurrentBet(betting_money);
        }
        System.out.println("=======================================");
    }

    private void show_score_board() {
        System.out.println();
        System.out.println("=============[SCORE BOARD]=============");
        for (int i = 0; i < numberOfGamer; i++) {
            Player player = playerList.get(i);
            System.out.println("\t PLAYER " + (i+1) + "'s balance : " + player.getBalance());
        }
        System.out.println("=======================================");
    }

    // 승패를 정함
    private void conclude_the_game() {
        // 만약 딜러가 bust이면 플레이어 모두 승자(BUST인 플레이어는 제외)
        if (Situation.is_bust(dealer) == true) {
            for (int i = 0; i < numberOfGamer; i++) {
                Player player = playerList.get(i);
                Status status = player.getStatus();

                switch (status) {
                    case STOP:
                        getMoney(player);
                        break;
                    case BUST:
                        lostMoney(player);
                        break;
                }
            }
        }
        // 그게 아니라면 승패를 따짐
        else {
            for (int i = 0; i < numberOfGamer; i++) {
                Player player = playerList.get(i);
                Status status = player.getStatus();

                switch (status) {
                    case STOP:
                        Situation.result who_win = Situation.who_win(dealer,player);
                        switch(who_win) {
                            case PLAYER_WIN:
                                getMoney(player);
                                break;
                            case DEALER_WIN:
                                lostMoney(player);
                                break;
                        }
                        break;
                    case BUST:
                        lostMoney(player);
                        break;
                }
            }
        }
    }

    // private methods
    private void dealerGetTwoCard() {
        dealer.getHand().drawCard();
        dealer.getHand().drawCard();
    }

    private void dealerGetOneCard() {
        dealer.getHand().drawCard();
    }

    private void playersGetTwoCard() {
        for( int i = 0 ; i<numberOfGamer ; i++ ) {
            playerList.get(i).getHand().drawCard();
            playerList.get(i).getHand().drawCard();
        }
    }

    private void dealerShowOneCard() {
        System.out.println("dealer has : ");
        dealer.showOneCard();
        for( int i=1 ; i<dealer.getHand().getCurrentHandSize() ; i++ ) {
            System.out.println("[Invisible Card]");
        }
        System.out.println("_______________________________________");
    }

    private void dealerShowAllCard_and_Score() {
        System.out.println("dealer has : ");
        dealer.showAllCards();

        System.out.println("dealear's score is : " + dealer.getScore());
        System.out.println("_______________________________________");
    }

    private Boolean dealerScoreIsUnder17() {
        return dealer.getScore()<17;
    }

    private void lostMoney(Player player) {
        player.setBalance(player.getBalance() - player.getCurrentBet());
    }

    private void getMoney(Player player) {
        player.setBalance(player.getBalance() + player.getCurrentBet()*2);
    }

    private void dealer_turn() {
        while( dealerScoreIsUnder17() ) {
            dealerGetOneCard();
        }
    }

    private void players_turn() {
        for (int i = 0; i < numberOfGamer; i++) {
            Player player = playerList.get(i);

            System.out.println("[PLAYER " + (i+1) + " TRUN]");
            System.out.println("You have : ");
            player.showAllCards();

            // Stand나 Bust가 될 때까지 선택함
            while (player.getStatus() == Status.ALIVE) {
                System.out.println();
                System.out.println("Select Hit or Stand");
                System.out.println("1. Hit");
                System.out.println("2. Stand");

                action(player);
                System.out.println("_______________________________________");
            }
        }
    }

    // 1이면 hit, 2이면 stand에 대한 취하는 행동
    private void action(Player player) {
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        switch (select) {
            case 1:
                player.hit();
                System.out.println("Hit!");

                System.out.println("You have : ");
                player.showAllCards();

                if (Situation.is_bust(player) == true){
                    player.set_status_if_bust();
                    System.out.println("Bust!");
                };
                break;

            case 2:
                player.stand();
                System.out.println("Stand!");
                break;
        }
    }
}
