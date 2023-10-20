package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainUnitTest {

    @Test
   //DisplayName("U-Test 001:Test to see if tostring is going to output the correct values")
    void TestToString(){
        Card newCard = new Card(0,"Test",0);

        String output = "Value: 0, Colour: Test, Damage: 0";

        assertEquals(newCard.toString(), output);


    }
}
