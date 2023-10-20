package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tourney {

    public Card current; // the current card or previously played card or starting card
    private Deck deck; // the deck of the game
    private ArrayList<Card> cardpile; //when players throw card, it piles up here. Also, creates a new deck if the current deck is empty

    private Scanner choice;

    private int pick; // players pick
    private ArrayList<Player> players;


    public Tourney(Card card) {
        /*constructor
         * constructs the game
         * prepares the game to play
         */
        deck = new Deck();
        deck.shuffle();

        cardpile = new ArrayList<Card>();

        choice = new Scanner(System.in);
        current = card;
        this.players = new ArrayList<Player>();
        //this.players.add(player1);
       // this.players.add(player2);
       // this.players.add(player3);
        /*
        for (int i = 0; i < players.size(); i++) {
            this.players.add(new Player(players.get(i), health));
        }*/


      //  distributecards();


    }

    private void distributecards() {
        for (int j = 0; j < players.size(); j++) {
            for (int i = 0; i < 12; i++) {


                players.get(j).pickCards(deck.getTopCard());


            }
        }

    }
    public void game() {

        //playGame(players.get(0),true);
        //playGame(players.get(1), false);
        //playGame(players.get(2),false);

        /*
        for(int j =0;j<12;j++) {
            System.out.println("Round "+j+"!");
            boolean con = true;
            playGame(players.get(0), con, 0);
            con = false;
            for (int i = 1; i < players.size(); i++) {
                playGame(players.get(i), con, i);
            }
            findLoser();
            if(!playersOut.isEmpty()) {
                players.addAll(playersOut);
                playersOut.clear();
            }
        }*/




    }

    public Card playGame(Player p, boolean con,  int pick) {
		/*	 this method takes player that is currently playing as an argument.
			 this method contains entire process for the game.
		*/

            if(!con && !hasColor(p) && !hasSpecial(p)){
                System.out.print("You don't have a valid card. Discard a card");
               // pick = choice.nextInt()-1;
                if(pick > p.PlayerCards().size()){
                    pick =0;
                    System.out.print("Bad Pick. Discarding the First Card.");
                }
                p.suffer(5);
                p.throwCard(pick);
                return current;
            }

           // pick = choice.nextInt() - 1;

            if (!isValidChoice(p, pick, con)) {
                System.out.println("Pick a valid number!");
                return current;
            }
            Card card = p.throwCard(pick);


        if (card.isSpecial()) {
            System.out.println("Specify the value of the card: ");
           Random random = new Random();

            int value = random.nextInt(15) + 1;

            if(!con) {
                card.modify(value, current.getColor());
            }else{
                System.out.println("Pick Between: \n Sword(1)  Arrow(2)   Sorrcery(3)  Deception(4)");
                int c =  random.nextInt(4) + 1;
                    if(c==1){
                        card.modify(value, "Swrd");
                    }else if(c==2){
                        card.modify(value, "Arrw");
                    }else if(c==3){
                        card.modify(value, "Sorc");
                    }else {
                        card.modify(value, "Decp");
                    }
                }
            }
        current = card;
        cardpile.add(current);
        return current;
        }





    public String getCurrentColor(){
        return current.getColor();
    }
    private boolean hasColor(Player p) {
        /*
         * checks if player has card of the same color as the current card that is being played
         */
        for(Card c:p.PlayerCards()) {

            if(c.getColor().equals(current.getColor())) {
                return true;
            }


        }

        return false;
    }

    private boolean hasSpecial(Player p) {
        for(Card c:p.PlayerCards()) {

            if(c.isSpecial()) {
                return true;
            }

        }




        return false;
    }
    private  boolean isValidChoice(Player p,int choice, boolean con) {

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
            if(!con){
                if(p.PlayerCards().get(choice).getColor().equals(current.getColor()) || p.PlayerCards().get(choice).isSpecial()) {
                    return true;
                }

            }



        }

        return false;
    }

}

