package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainUnitTest {

    @Test
   //DisplayName("U-Test 002:Test to see if the right card is remvoed")
    void TestToString(){
        Deck deck = new Deck();
        Card card = new Card(1, "Test", 0);
        deck.addCard(1,"Test1",0);
        deck.addCard(1,"Test2",0);
        deck.addCard(1,"Test3",0);
        deck.addCard(card);





        assertEquals(deck.getTopCard(), card);


    }
}
