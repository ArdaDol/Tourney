package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainUnitTest {

    @Test
   //DisplayName("U-Test 009:Test to see if player can play a card part 2")
    void TestToString(){
        Player player1 = new Player("Player 1", 50);
        player1.pickCards(new Card(0,"Alch",0));
        player1.pickCards(new Card(0,"Arrw",0));
        player1.pickCards(new Card(0,"Alch",0));


        //Tourney.isValidChoice(player1, 0, false);







      assertEquals(Tourney.hasSpecial(player1), false);



    }
}
