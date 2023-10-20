package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Player {



    private ArrayList<Card> playercards;
    private ArrayList<Card> loserPile;
    private String name; //player name

    private int health;

    private int damageSuffered;

    public Player(String name, int health) {
        /*
         * creates a array list that will store player cards
         * assigns name to the player
         */

        //

        playercards = new ArrayList<Card>();
        loserPile = new ArrayList<Card>();
        this.name = name;
        this.health = health;
        this.damageSuffered = 0;

    }
    public void suffer(int damage){
        this.health -= damage;
    }
    public int numberOfCards() {
        /*
         * returns number of cards player has in hand
         */
        return playercards.size();
    }

    public ArrayList<Card> PlayerCards(){
        /*
         * returns all the cards player has in hand as an ArrayList
         * This is used mainly to check if player has any valid cards to play.
         */

        return playercards;
    }

    public void addLost(Card c){
        loserPile.add(c);
    }

    public void pickCards(Card c) {
        /*
         *
         */
        playercards.add(c);

    }

    public Card throwCard(int c) {
        /*
         * player throws a card from hand which is at position 'c'. c is a integer value and is passed as an argument.
         */


        return playercards.remove(c);
    }




    public String showCards() {



        /*
         * this is graphical representation of a card
         * just to make cards look more look like cards
         *
         */

        String[] card = {" ----- ","|     |","|     |"," ----- "};
        String c = "";


        for(int i=0;i<card.length;i++) {

            for(int j=0;j<playercards.size();j++) {


                if(i==1) {

                    c = c +"| "+playercards.get(j).getColor()+" |"+" ";

                }

                else if(i==2) {

                    c = c + "|  "+playercards.get(j).getValue()+"  |"+" ";
                }

                else {
                    c = c + card[i]+" ";
                }




            }

            c +="\n";

        }

        return c;
    }

    public String hideCards() {

        return "___";
    }



    public String toString() {
        /*
         * text representation of player
         */
        return this.name;
    }




}
