package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Tourney {

    private Card current; // the current card or previously played card or starting card
    private Deck deck; // the deck of the game
    private ArrayList<Card> cardpile; //when players throw card, it piles up here. Also, creates a new deck if the current deck is empty

    private Scanner choice;

    private int pick; // players pick
    private ArrayList<Player> players;


    public Tourney(ArrayList<String> players, int health) {
        /*constructor
         * constructs the game
         * prepares the game to play
         */
        deck = new Deck();
        deck.shuffle();

        cardpile = new ArrayList<Card>();

        choice = new Scanner(System.in);

        this.players = new ArrayList<Player>();

        for (int i = 0; i < players.size(); i++) {
            this.players.add(new Player(players.get(i), health));
        }


        distributecards();


    }

    private void distributecards() {
        for (int j = 0; j < players.size(); j++) {
            for (int i = 0; i < 12; i++) {


                players.get(j).pickCards(deck.getTopCard());


            }
        }

    }
    public void game() {
			/* this method simulates turns between the two players. when turn is even, player 1 plays and when
			   turn is odd player 2 plays.
			*/
        playGame(new Player("Josh", 50), false);




    }

    public void playGame(Player p, boolean con) {
		/*	 this method takes player that is currently playing as an argument.
			 this method contains entire process for the game.
		*/



            pick = choice.nextInt() - 1;
            while (!isValidChoice(p, pick, con)) {

            }
            current = p.throwCard(pick);
            cardpile.add(current);



    }
    public static boolean isValidChoice(Player p,int choice, boolean con) {

        /*
         * checks if the user selection was a valid choice or not
         *
         */

        if(choice <= p.PlayerCards().size()) {
            //add for special

            if(p.PlayerCards().get(choice).isExtraSpecial()){

                for(int i =0; i<p.PlayerCards().size();i++){
                    if(!p.PlayerCards().get(i).isExtraSpecial()){
                        return false;
                    }
                }
                return true;
            }




        }

        return false;
    }

}

