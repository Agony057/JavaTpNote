package com.example.javatpnote;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    @DisplayName("Test getter Recette de Pizza")
    void TestGetRecette() {
        Pizza pizza1 = new Pizza("Reine", 4.99, 2);

        assertEquals("Reine", pizza1.getRecette());

    }

    @Test
    @DisplayName("Test setter Recette de Pizza")
    void TestSetRecette() {
        Pizza pizza2 = new Pizza("reine", 4.99, 2);

        pizza2.setRecette("Marguerite");

        assertEquals("Marguerite", pizza2.getRecette());
    }

    @Test
    @DisplayName("Test constructeur de Pizza")
    void TestConstructor(){
    Pizza pizza3 = new Pizza("Flamme", 3.90, 2);

        assertAll(() -> assertEquals("Flamme", pizza3.getRecette()),
                () -> assertEquals(3.90, pizza3.getPrix()),
                () -> assertEquals(2, pizza3.getNb_ing()));
    }
}