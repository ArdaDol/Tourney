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
        player1.pickCards(new Card(1, colors[2],5));
        player1.pickCards(new Card(1, colors[3],5));




        //this takes the place of the current card
        Tourney tourney = new Tourney(new Card(1, colors[1],5));

         tourney.playGame(player1, true);


        assertEquals(tourney.playersOut.get(o), player1);











    }
}
