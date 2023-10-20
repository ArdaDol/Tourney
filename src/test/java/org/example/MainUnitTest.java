package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainUnitTest {

    @Test
   //DisplayName("U-Test 006:Test to see if cards dealt are 12 for each player and random")
    void TestToString(){
        Player player1 = new Player("Player 1", 50);
        Player player2 = new Player("Player 2", 50);

       Tourney tourney = new Tourney(player1, player2, 50);






        assertEquals(player1.getCards(), 12);
        assertEquals(player2.getCards(), 12);


    }
}
