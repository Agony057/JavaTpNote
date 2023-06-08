package com.example.javatpnote;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    @DisplayName("Test getNom de Pizza")
    void TestGetNom() {
        Pizza pizza1 = new Pizza("Reine", 4.99, 2);

    }

    @Test
    @DisplayName("Test setNom de Pizza")
    void TestSetNom() {
    }

    @Test
    @DisplayName("Test constructeur de Pizza")
    void TestConstructor(){

    }
}