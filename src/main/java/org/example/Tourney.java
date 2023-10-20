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


    public Tourney() {
        /*constructor
         * constructs the game
         * prepares the game to play
         */
        deck = new Deck();
        deck.shuffle();
        current = new Card(0, "N",0);
        cardpile = new ArrayList<Card>();
        playersOut = new ArrayList<Player>();
        choice = new Scanner(System.in);

        this.players = new ArrayList<Player>();
       // this.players.add(player1);
     //   this.players.add(player2);
       // this.players.add(player3);
        /*
        for (int i = 0; i < players.size(); i++) {
            this.players.add(new Player(players.get(i), health));
        }*/


        distributecards();


    }

    private void distributecards() {
        for (int j = 0; j < players.size(); j++) {
            for (int i = 0; i < 12; i++) {


                players.get(j).pickCards(deck.getTopCard());


            }
        }

    }
    public void game( ) {
        System.out.println("How many health?");
        int health = choice.nextInt();
        System.out.println("How many rounds?");
        int rounds = choice.nextInt();
        System.out.println("How Many Players? (3-6)");
        pick = choice.nextInt();
        while(!(pick<3 || pick<=6)){
            System.out.println("How Many Players? (3-6)");
            pick = choice.nextInt();
        }
        for(int i=0;i<pick;i++){
            System.out.println("Enter Player "+i+"'s Name: ");
            String name = choice.next();
            players.add(new Player(name, health));
        }

        for(int k=0; k<rounds;k++) {
            distributecards();
            for (int j = 0; j < 12; j++) {
                System.out.println("Round " + j + "!");
                boolean con = true;
                playGame(this.players.get(0), con);
                con = false;
                for (int i = 1; i < players.size(); i++) {
                    playGame(players.get(i), con);
                }
                int loser = findLoser();
                handleLoser(loser);
                handleOuts();

            }
            cardpile.clear();
            current = new Card(0,"N",0);
            SubtractPoints();
            DisplayPoints();
            KickPlayers();
            if(players.size() <=1){
                System.out.println("Not Enough Players To Play");
                break;
            }

        }


    }

    private void KickPlayers(){
           ArrayList<Player> kickedPlayers = new ArrayList<Player>();
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getHealth() <= 0) {
                    System.out.println(players.get(i).toString() + " Has Lost!");
                    kickedPlayers.add(players.get(i));
                }
            }
            for(int i = 0; i < kickedPlayers.size(); i++){
                for(int j=0; j<players.size();j++){
                    if(players.get(j)==players.get(i)){
                        players.remove(j);
                        break;
                    }
                }
            }

    }
    private void SubtractPoints(){
        int winner = players.get(0).getHealth();
        for(int i=0;i<players.size();i++){
            for(int j = 0;j<players.get(i).LostCards().size();j++){
                players.get(i).suffer(players.get(i).LostCards().get(j).getDamage());
                deck.addCard(players.get(i).LostCards().get(j));


            }
            players.get(i).clearLostCards();

        }
    }
    private void DisplayPoints(){
       int winner = players.get(0).getHealth();
       Player win = players.get(0);
        for(int i=0;i<players.size();i++){
            System.out.println(players.get(i).toString()+ " Has "+ players.get(i).getHealth() );
            if(players.get(i).getHealth()>winner){
                winner = players.get(i).getHealth();
                win = players.get(i);
            }
        }
        System.out.println("Winner of This Round is: "+ win.toString());
    }
    private void handleOuts(){
        if(!playersOut.isEmpty()){
            players.addAll(playersOut);
            playersOut.clear();
        }
    }
    private void handleLoser(int num){
        if(num>=0){
            Player loser = players.get(num);
            players.remove(num);
            for (int i = 0; i < cardpile.size(); i++) {
                loser.addLost(cardpile.get(i));
            }

            players.add(0, loser);
            System.out.println("LOSER IS: " + loser.toString());
        }
    }

    public void playGame(Player p, boolean con) {
		/*	 this method takes player that is currently playing as an argument.
			 this method contains entire process for the game.
		*/
        //Random random = new Random();
        decorate();
        System.out.println(p+", It is your turn: ");

        decorate();
        showBoard(p);
        decorate();
        System.out.println("Please pick a card:");

            if((!con) && !hasColor(p) && !hasSpecial(p)){
                System.out.print("You don't have a valid card. Discard a card");
                pick = choice.nextInt()-1;


                // nextInt(15) generates a number between 0 (inclusive) and 15 (exclusive)
                // So, we add 1 to shift the range to 1-15 inclusive.
               // pick = random.nextInt(p.PlayerCards().size()-1) ;



                if(pick > p.PlayerCards().size()){
                    pick =0;
                    System.out.print("Bad Pick. Discarding the First Card.");
                }
                playersOut.add(p);
                players.remove(p);
                p.suffer(5);
                p.throwCard(pick);

            } else {
                if(current.getColor()!= "N") {
                    System.out.println(p + "The current card on play is:\n" + current);
                }
                pick = choice.nextInt() - 1;

            while (!isValidChoice(p, pick, con)) {
                System.out.println("Pick a valid number!");
                pick = choice.nextInt() - 1;
                //pick = random.nextInt(p.PlayerCards().size() - 1);
            }
            Card card = p.throwCard(pick);


            if (card.isSpecial()) {
                System.out.println("Specify the value of the card: ");
                 int value = choice.nextInt();
               // int value = random.nextInt(15) + 1;
                if (value > p.PlayerCards().size()) {
                    System.out.print("Bad Choice. Value is set to 1");
                    value = 1;
                }
                if (current.getColor() != "N") {
                    card.modify(value, current.getColor());
                } else {
                    System.out.println("Pick Between: \n Sword(1)  Arrow(2)   Sorrcery(3)  Deception(4)");
                    int c = choice.nextInt();
                   // int c = random.nextInt(4) + 1;
                    if (c == 1) {
                        card.modify(value, "Swrd");
                    } else if (c == 2) {
                        card.modify(value, "Arrw");
                    } else if (c == 3) {
                        card.modify(value, "Sorc");
                    } else {
                        card.modify(value, "Decp");
                    }
                }
            }
            current = card;
            cardpile.add(current);
        }
    }

    public int findLoser(){

        int[] indexs = new int[cardpile.size()];
        int loser = -1;
        //int small = 99;
        for(int i=0;i<cardpile.size();i++){

            indexs[i]= i+1;
        }


        for (int i = 0; i < cardpile.size(); i++) {

            for (int j = i + 1; j < cardpile.size(); j++) {
                if (cardpile.get(i).getValue()==cardpile.get(j).getValue()) {
                    indexs[i]=0;
                    indexs[j]=0;


                }
            }
        }

        for(int i=0;i<indexs.length;i++){
            if(indexs[i]!=0){
                loser = i;
            }
        }

        for(int i =0;i< indexs.length;i++){

            if(indexs[i]!=0){
                if(cardpile.get(i).getValue()<cardpile.get(loser).getValue()){
                    loser = i;
                }
            }
        }

        return loser;


    }

    public void handleLoser(Player p){
        for (int i = 0; i < cardpile.size(); i++) {
            p.addLost(cardpile.get(i));
        }

        players.add(0, loser);
        System.out.println("LOSER IS: " + loser.toString());

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
                int counter=0;
                for(int i =0; i<p.PlayerCards().size();i++){
                    if(!p.PlayerCards().get(i).isExtraSpecial() && !p.PlayerCards().get(i).isSpecial() && !p.PlayerCards().get(i).getColor().equals(current.getColor()) ){
                        counter++;
                    }else if(p.PlayerCards().get(i).isExtraSpecial()){
                        counter++;
                    }
                }
                if(counter == p.PlayerCards().size()) {
                    return true;
                }else{
                    return false;
                }
            }
            if(con==false){
                if(p.PlayerCards().get(choice).getColor().equals(current.getColor()) || p.PlayerCards().get(choice).isSpecial()) {
                    return true;
                }

            }else{

               return true;
            }



        }

        return false;
    }

    private void decorate() {
        /*
         * draws asterik lines
         */


        System.out.println("***********************************************************************************");
    }

    public void showBoard(Player p) {
        System.out.println(p.toString());
        p.showCards();
    }

}

