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
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
   //DisplayName("U-Test 009:Test to see if player can play a card part 2")
    void TestPlayerCards(){
        String[] colors = {"Swrd","Arrw","Decp","Sorc", "Merl", "Appr", "Alch"};
        // Mocking the Scanner to simulate user input
       Player player1 = new Player("Player 1", 50);
       Player player2 = new Player("Player 2", 50);


      player1.pickCards(new Card(1, colors[0],5));
        player1.pickCards(new Card(1, colors[1],5));
        player1.pickCards(new Card(1, colors[2],5));
        player1.pickCards(new Card(1, colors[3],5));
        player1.pickCards(new Card(0, colors[4], 25));
        player1.pickCards(new Card(0,colors[5], 5));
        player1.pickCards(new Card(0,colors[6],5));

        player2.pickCards(new Card(0,colors[6],5));

        //this takes the place of the current card
        Tourney tourney = new Tourney(new Card(1, colors[1],5));
        //Checks when player plays first, the cards that he can play from his hand. He should not be able to play alchemy only
        Card card = tourney.playGame(player1, true, 1);
        assertEquals(card, player1.PlayerCards().get(0));

         card = tourney.playGame(player1, true, 2);
        assertEquals(card, player1.PlayerCards().get(1));

         card = tourney.playGame(player1, true, 3);
        assertEquals(card, player1.PlayerCards().get(2));

         card = tourney.playGame(player1, true, 4);
        assertEquals(card, player1.PlayerCards().get(3));

        card = tourney.playGame(player1, true, 5);
        assertEquals(card, player1.PlayerCards().get(4));

        card = tourney.playGame(player1, true, 6);
        assertEquals(card, player1.PlayerCards().get(5));

        card = tourney.playGame(player1, true, 7);
        assertEquals(card, player1.PlayerCards().get(6));


        //Checks when player plays second, the cards that he can play from his hand. He should only be able to play sword , apprentice or merlin.
        tourney.current = new Card(1, colors[0],5);
         card = tourney.playGame(player1, false, 1);
        assertEquals(card, player1.PlayerCards().get(0));

       card = tourney.playGame(player1, false, 2);
        assertEquals(card, player1.PlayerCards().get(1));

        card = tourney.playGame(player1, false, 3);
        assertEquals(card, player1.PlayerCards().get(2));

         card = tourney.playGame(player1, false, 4);
        assertEquals(card, player1.PlayerCards().get(3));

         card = tourney.playGame(player1, false, 5);
        assertEquals(card, player1.PlayerCards().get(4));

         card = tourney.playGame(player1, false, 6);
        assertEquals(card, player1.PlayerCards().get(5));

         card = tourney.playGame(player1, false, 7);
        assertEquals(card, player1.PlayerCards().get(6));


        //when the only card the player has is alchemy
       card = tourney.playGame(player2, false, 0);
        assertEquals(card, player2.PlayerCards().get(0));











    }
}
