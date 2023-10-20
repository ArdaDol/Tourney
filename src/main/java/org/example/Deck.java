package org.example;


import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {

        /*
         * The constructor creates a new deck
         * There are 4 colors: red, blue, green, yellow
         * Each suit has two of the same card except 0 (it only appears once in each suit).
         * For example: green suit has two 1s but only 1 zero
         */


        deck = new ArrayList<Card>();
        String[] colors = {"Swrd","Arrw","Decp","Sorc"};
        String[] specialnumbers = {"Merl", "Appr", "Alch"};

        deck.add(new Card(1, colors[0],5));
        deck.add(new Card(2, colors[0],5));
        deck.add(new Card(3, colors[0],5));
        deck.add(new Card(4, colors[0],5));
        deck.add(new Card(5, colors[0],5));
        deck.add(new Card(6, colors[0],10));
        deck.add(new Card(7, colors[0],10));
        deck.add(new Card(8, colors[0],10));
        deck.add(new Card(9, colors[0],10));
        deck.add(new Card(10, colors[0],5));
        deck.add(new Card(11, colors[0],5));
        deck.add(new Card(12, colors[0],5));
        deck.add(new Card(13, colors[0],5));
        deck.add(new Card(14, colors[0],5));
        deck.add(new Card(15, colors[0],5));

        deck.add(new Card(1, colors[1],5));
        deck.add(new Card(2, colors[1],5));
        deck.add(new Card(3, colors[1],5));
        deck.add(new Card(4, colors[1],5));
        deck.add(new Card(5, colors[1],5));
        deck.add(new Card(6, colors[1],5));
        deck.add(new Card(7, colors[1],5));
        deck.add(new Card(8, colors[1],10));
        deck.add(new Card(9, colors[1],10));
        deck.add(new Card(10, colors[1],10));
        deck.add(new Card(11, colors[1],10));
        deck.add(new Card(12, colors[1],5));
        deck.add(new Card(13, colors[1],5));
        deck.add(new Card(14, colors[1],5));
        deck.add(new Card(15, colors[1],5));

        deck.add(new Card(1, colors[1],5));
        deck.add(new Card(2, colors[1],5));
        deck.add(new Card(3, colors[1],5));
        deck.add(new Card(4, colors[1],5));
        deck.add(new Card(5, colors[1],10));
        deck.add(new Card(6, colors[1],10));
        deck.add(new Card(7, colors[1],5));
        deck.add(new Card(8, colors[1],5));
        deck.add(new Card(9, colors[1],5));
        deck.add(new Card(10, colors[1],5));
        deck.add(new Card(11, colors[1],10));
        deck.add(new Card(12, colors[1],10));
        deck.add(new Card(13, colors[1],5));
        deck.add(new Card(14, colors[1],5));
        deck.add(new Card(15, colors[1],5));

        deck.add(new Card(1, colors[1],5));
        deck.add(new Card(2, colors[1],5));
        deck.add(new Card(3, colors[1],5));
        deck.add(new Card(4, colors[1],5));
        deck.add(new Card(5, colors[1],5));
        deck.add(new Card(6, colors[1],10));
        deck.add(new Card(7, colors[1],10));
        deck.add(new Card(8, colors[1],5));
        deck.add(new Card(9, colors[1],10));
        deck.add(new Card(10, colors[1],10));
        deck.add(new Card(11, colors[1],5));
        deck.add(new Card(12, colors[1],5));
        deck.add(new Card(13, colors[1],5));
        deck.add(new Card(14, colors[1],5));
        deck.add(new Card(15, colors[1],5));


        for(int i =0; i<3;i++) {
            deck.add(new Card(0, specialnumbers[0], 25));
        }
        for(int i=0;i<2;i++){
            deck.add(new Card(0,specialnumbers[1], 5));

        }

        for(int i=0;i<15;i++){
            deck.add(new Card(0,specialnumbers[1],5));
        }



    }


    public Deck(ArrayList<Card> c) { //overloaded constructor
        /*
         * incase the current deck becomes empty, all the thrown cards are collected and it becomes the new deck;
         *
         */
        deck = c;
    }

    public boolean addCard(int value, String colour, int  damage){

       return false;

    }

    public boolean isEmpty() { //is deck empty?
        /*
         * Checks the size of the deck. If it is greater than 0 then returns false. If not, returns true
         */

        if(deck.size()>0) {
            return false;
        }
        return true;
    }

    public void shuffle() {

        /*
         *  Shuffles the deck
         */

        Collections.shuffle(deck);

    }

    public Card getTopCard() {
        /*
         * gets the topmost card from a inverted deck
         */
        return deck.remove(deck.size()-1);
    }

    public Card peek() {

        return deck.get(deck.size()-1);
    }


    public String toString() {

        String deck="";

        for(Card c:this.deck) {

            deck = deck +c+ " ";
        }

        return deck;

    }










}