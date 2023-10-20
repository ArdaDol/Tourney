package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainUnitTest {

    @Test
   //DisplayName("U-Test 002:Test to see if the right card is remvoed")
    void TestToString(){
        Player player = new Player("TEST", 0);

        player.pickCards(new Card(1,"Test1",0));
        player.pickCards(new Card(1,"Test2",0));
        player.pickCards(new Card(1,"Test3",0));



        String card = "Value: 1, Color: Test1, Damage: 0 \n" +
                "Value: 1, Color: Test2, Damage: 0 \n" + "Value: 1, Color: Test3, Damage: 0 ";


        assertEquals(player.hideCards(), card);


    }
}
