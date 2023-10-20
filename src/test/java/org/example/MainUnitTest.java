package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainUnitTest {

    @Test
   //DisplayName("U-Test 002:Test to see if the right card is added to the deck")
    void TestToString(){
        Deck deck = new Deck();

        //deck.addCard(1,"Test",0);





        assertEquals(deck.addCard(1,"Test",0), true);


    }
}
