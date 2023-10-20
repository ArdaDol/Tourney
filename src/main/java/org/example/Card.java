package org.example;

public class Card {

    private String color;
    private int value;
    private int damage;

    private boolean special;

    public Card(int value,String color, int damage) {

        /*
         * constructs a non speicla card
         * sets the color and numerical value
         * sets it to the normal card category
         */

        this.damage = damage;
        this.color = color;
        this.value = value;
        this.special = false;
        if(value ==0){
            this.special = true;
        }

    }



    public Card(int specialValue) { // constructor for special cards like +4 and +2

        /*
         * assigns special value to the card
         * sets the card to special category
         */

        this.color="";
        // this.specialValue = specialValue;
        this.value = 0;
        this.special = true;
    }
    public void modify(int value, String color){
        this.value = value;
        this.color = color;
    }
    public String getColor() {
        /*
         * returns color of the card
         */

        return this.color;
    }

    public int getValue() {

        /*
         * returns numerical value of the card
         */

        return this.value;



    }
    public int getDamage(){
        return this.damage;
    }

    public String toString() {

     return "TESTING";



    }


    public boolean isSpecial() {

        /*
         * returns true if card is a special card
         * returns false if card is not a special card
         */


        if(special) {
            return true;
        }

        return false;
    }





}
