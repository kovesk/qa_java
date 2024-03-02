package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedMeat = List.of("Животные", "Птицы", "Рыба");
        List<String> actualMeat = feline.eatMeat();
        assertEquals(expectedMeat, actualMeat);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        int expectedKittens = 3;
        int actualKittens = feline.getKittens(3);
        assertEquals(expectedKittens, actualKittens);
    }

}
