package com.cnu.blackjack;

public class Situation {

    enum result {
        DEALER_WIN,
        PLAYER_WIN,
        DRAW
    }

    public static result who_win(Dealer dealer, Player player) {
        if (dealer.getScore() > player.getScore()) {
            return result.DEALER_WIN;
        }
        else if (dealer.getScore() < player.getScore()){
            return result.PLAYER_WIN;
        }
        else {
            return result.DRAW;
        }
    }

    public static boolean check_bust(Person person) {
        if (person.getScore() > 21) {
            return true;
        }
        else {
            return false;
        }
    }
}