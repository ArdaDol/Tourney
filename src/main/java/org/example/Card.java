package org.example;

public class Card {

    private String color;
    private int value;
    private int damage;

    private boolean special;
    private boolean extraSpecial;

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
        if(color == "Alch"){
            this.extraSpecial = true;
        }

    }


    public boolean isExtraSpecial() {
        return extraSpecial;
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

        /*
         * prints the card.
         * prints [ color - card value ] if the card is not a special card
         * prints [ + value ] if it is a special card
         */

//		if(!special) {
//			return "[ "+this.color+"-"+this.value+" ]";
//		}
//
//		else if(special){
//
//			return "[ "+"+"+this.specialValue+" ]";
//		}
//		return null;

        String[] card = {" ----- ","|     |","|     |"," ----- "};
        String c = "";


        for(int i=0;i<card.length;i++) {

            for(int j=0;j<1;j++) {

                if(i==1) {

                    c = c +"| "+this.getColor()+" |"+" ";

                }

                else if(i==2) {

                    c = c + "|  "+this.getValue()+"  |"+" ";
                }

                else {
                    c = c + card[i]+" ";
                }



            }

            c +="\n";

        }




        return c;




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
