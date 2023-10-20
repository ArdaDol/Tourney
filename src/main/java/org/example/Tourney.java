package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tourney {

    private Card current; // the current card or previously played card or starting card
    private Deck deck; // the deck of the game
    private ArrayList<Card> cardpile; //when players throw card, it piles up here. Also, creates a new deck if the current deck is empty

    private Scanner choice;

    private int pick; // players pick
    private Player  loser;
    public ArrayList<Player> players, playersOut;


    public Tourney(Card card) {
        /*constructor
         * constructs the game
         * prepares the game to play
         */
        deck = new Deck();
        deck.shuffle();

        cardpile = new ArrayList<Card>();

        choice = new Scanner(System.in);

        this.players = new ArrayList<Player>();
       // this.players.add(player1);
     //   this.players.add(player2);
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

      //  playGame(players.get(0),true);
     //   playGame(players.get(1), false);
     //   playGame(players.get(2),false);

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

    public void playGame(Player p, boolean con) {
		/*	 this method takes player that is currently playing as an argument.
			 this method contains entire process for the game.
		*/

            if(!con && !hasColor(p) && !hasSpecial(p)){
                System.out.print("You don't have a valid card. Discard a card");
              //  pick = choice.nextInt()-1;
                Random random = new Random();

                // nextInt(15) generates a number between 0 (inclusive) and 15 (exclusive)
                // So, we add 1 to shift the range to 1-15 inclusive.
                pick = random.nextInt(p.PlayerCards().size()-1) ;



                if(pick > p.PlayerCards().size()){
                    pick =0;
                    System.out.print("Bad Pick. Discarding the First Card.");
                }
                playersOut.add(p);
                //players.remove(p);
                p.suffer(5);
                p.throwCard(pick);
            }

            pick = choice.nextInt() - 1;
            while (!isValidChoice(p, pick, con)) {
                System.out.println("Pick a valid number!");
                pick = choice.nextInt() - 1;
            }
            Card card = p.throwCard(pick);


        if (card.isSpecial()) {
            System.out.println("Specify the value of the card: ");
            int value = choice.nextInt();
            if(value>  p.PlayerCards().size()){
                System.out.print("Bad Choice. Value is set to 1");
                value = 1;
            }
            if(current.getColor()!= "N") {
                card.modify(value, current.getColor());
            }else{
                System.out.println("Pick Between: \n Sword(1)  Arrow(2)   Sorrcery(3)  Deception(4)");
                int c = choice.nextInt();
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
        }

    private void findLoser(){

        int[] indexs = new int[cardpile.size()];

        int small = 99;
        for(int i=0;i<cardpile.size();i++){

            indexs[i]= i+1;
        }


        for (int i = 0; i < cardpile.size(); i++) {

            for (int j = i + 1; j < cardpile.size(); j++) {
                if (cardpile.get(i).getValue()==cardpile.get(j).getValue()) {
                    indexs[i]=0;
                    indexs[j]=0;


                }else{
                    small = i;
                }
            }
        }

        for(int i =0;i<indexs.length;i++){

            if(indexs[i]!=0){
                small = i;
            }
        }

        for(int i =0;i< indexs.length;i++){

            if(indexs[i]!=0){
                if(cardpile.get(i).getValue()<cardpile.get(small).getValue()){
                    small = i;
                }
            }
        }

        if(small ==99 ){
            System.out.println("No Losers This Melee");
        }else {
            loser = players.get(small);


            for (int i = 0; i < cardpile.size(); i++) {
                loser.addLost(cardpile.get(i));
            }

            cardpile.clear();
            players.remove(small);
            players.add(0, loser);
            System.out.println("LOSER IS: " + loser.toString());
        }
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

