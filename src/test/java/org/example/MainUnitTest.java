package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
public class MainUnitTest {

    @Test
   //DisplayName("U-Test 009:Test to see if player can play a card part 2")
    void TestPlayerCards(){
        String[] colors = {"Swrd","Arrw","Decp","Sorc", "Merl", "Appr", "Alch"};
        // Mocking the Scanner to simulate user input
       Player player1 = new Player("Player 1", 50);
       Player player2 = new Player("Player 2", 50);
        Player player3 = new Player("Player 3", 50);
        Player player4 = new Player("Player 4", 50);


      player1.pickCards(new Card(1, colors[0],5));
        player1.pickCards(new Card(1, colors[2],5));
        player1.pickCards(new Card(1, colors[2],5));
        player1.pickCards(new Card(1, colors[3],5));

        player2.pickCards(new Card(3, colors[0],5));
        player2.pickCards(new Card(1, colors[2],5));
        player2.pickCards(new Card(1, colors[2],5));
        player2.pickCards(new Card(1, colors[2],5));

        player3.pickCards(new Card(4, colors[0],5));
        player3.pickCards(new Card(1, colors[2],5));
        player3.pickCards(new Card(1, colors[2],5));
        player3.pickCards(new Card(1, colors[2],5));




        player4.pickCards(new Card(1, colors[3],5));
        player4.pickCards(new Card(1, colors[3],5));
        player4.pickCards(new Card(1, colors[3],5));
        //this takes the place of the current card
        Tourney tourney = new Tourney();

         tourney.playGame(player1, true, 0);
        tourney.playGame(player2, false, 0);
        tourney.playGame(player4, false, 3);
        tourney.playGame(player3, false, 0);




        assertEquals( tourney.findLoser(), 0);


        Player player01 = new Player("Player 1", 50);
        Player player02 = new Player("Player 2", 50);
        Player player03 = new Player("Player 3", 50);
        Player player04 = new Player("Player 4", 50);


        player01.pickCards(new Card(0, colors[4],5));
        player01.pickCards(new Card(1, colors[2],5));
        player01.pickCards(new Card(1, colors[2],5));
        player01.pickCards(new Card(1, colors[3],5));

        player02.pickCards(new Card(0, colors[6],5));
        player02.pickCards(new Card(0, colors[6],5));
        player02.pickCards(new Card(0, colors[6],5));
        player02.pickCards(new Card(0, colors[6],5));

        player03.pickCards(new Card(0, colors[5],5));
        player03.pickCards(new Card(0, colors[5],5));
        player03.pickCards(new Card(0, colors[5],5));
        player03.pickCards(new Card(0, colors[5],5));




        player4.pickCards(new Card(1, colors[3],5));
        player4.pickCards(new Card(10, colors[3],5));
        player4.pickCards(new Card(1, colors[3],5));


        Tourney tourney1 = new Tourney();

        tourney1.playGame(player01, true, 0);
        tourney1.playGame(player02, false, 0);
        tourney1.playGame(player04, false, 3);
        tourney1.playGame(player03, false, 0);




        assertEquals( tourney.findLoser(), 0);





    }
}
