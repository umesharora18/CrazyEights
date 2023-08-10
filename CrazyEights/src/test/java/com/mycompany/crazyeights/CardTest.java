/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.crazyeights;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LENOVO
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRankGood() {
        System.out.println("getRank");
        Card instance = new Card("8","Hearts");
        String expResult = "8";
        String result = instance.getRank();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuitGood() {
        System.out.println("getSuit");
        Card instance = new Card("8","Hearts");
        String expResult = "Hearts";
        String result = instance.getSuit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isEight method, of class Card.
     */
    @Test
    public void testIsEightGood() {
        System.out.println("isEight");
        Card instance = new Card("8","Hearts");
        boolean expResult = true;
        boolean result = instance.isEight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of applySpecialEffect method, of class Card.
     */
    @Test
    public void testApplySpecialEffectGood() {
        System.out.println("applySpecialEffect");
        String newSuit = "Diamonds";
        Card instance = new Card("8","Hearts");
        instance.applySpecialEffect(newSuit);
        assertEquals(newSuit, instance.getSuit());

        // TODO review the generated test code and remove the default call to fail.
       /// fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Card.
     */
    @Test
    public void testEqualsGood() {
        System.out.println("equals");
        Card instance1=new Card("7","Hearts");
        Card instance2 = new Card("7","Hearts");
        boolean expResult = true;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToStringGood() {
        System.out.println("toString");
        Card instance = new Card("9","Clubs");
        String expResult = "9 of Clubs";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     @Test
    public void testGetRankBad() {
        System.out.println("Testing getRank() method in Card class (Bad Scenario)");
        Card instance = new Card("8", "Hearts");
        String expResult = "9"; // Incorrect expected result
        String result = instance.getRank();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testGetSuitBad() {
        System.out.println("Testing getSuit() method in Card class (Bad Scenario)");
        Card instance = new Card("8", "Hearts");
        String expResult = "Diamonds"; // Incorrect expected result
        String result = instance.getSuit();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testIsEightBad() {
        System.out.println("Testing isEight() method in Card class (Bad Scenario)");
        Card instance = new Card("8", "Hearts");
        boolean expResult = false; // Incorrect expected result
        boolean result = instance.isEight();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testApplySpecialEffectBad() {
        System.out.println("Testing applySpecialEffect() method in Card class (Bad Scenario)");
        String newSuit = "Diamonds";
        Card instance = new Card("7", "Hearts");
        instance.applySpecialEffect(newSuit);
        String result = instance.getSuit();
        assertNotEquals(newSuit, result);
    }

    @Test
    public void testEqualsBad() {
        System.out.println("Testing equals() method in Card class (Bad Scenario)");
        Card instance1 = new Card("7", "Hearts");
        Card instance2 = new Card("7", "Diamonds"); // Different suit
        boolean expResult = true; // Incorrect expected result
        boolean result = instance1.equals(instance2);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testToStringBad() {
        System.out.println("Testing toString() method in Card class (Bad Scenario)");
        Card instance = new Card("9", "Clubs");
        String expResult = "10 of Clubs"; // Incorrect expected result
        String result = instance.toString();
        assertNotEquals(expResult, result);
    }
    
    
    @Test
    public void testGetRankBoundary() {
        System.out.println("Testing getRank() method in Card class (Boundary Scenario)");
        Card instance = new Card("8", "Hearts");
        String expResult = "8"; // Correct expected result
        String result = instance.getRank();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSuitBoundary() {
        System.out.println("Testing getSuit() method in Card class (Boundary Scenario)");
        Card instance = new Card("8", "Hearts");
        String expResult = "Hearts"; // Correct expected result
        String result = instance.getSuit();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEightBoundary() {
        System.out.println("Testing isEight() method in Card class (Boundary Scenario)");
        Card instance = new Card("8", "Hearts");
        boolean expResult = true; // Correct expected result for "8" rank
        boolean result = instance.isEight();
        assertEquals(expResult, result);
    }

    @Test
    public void testApplySpecialEffectBoundary() {
        System.out.println("Testing applySpecialEffect() method in Card class (Boundary Scenario)");
        String newSuit = ""; // Empty string
        Card instance = new Card("8", "Hearts");
        instance.applySpecialEffect(newSuit);
        String result = instance.getSuit();
        assertEquals(newSuit, result);
    }

    @Test
    public void testEqualsBoundary() {
        System.out.println("Testing equals() method in Card class (Boundary Scenario)");
        Card instance1 = new Card("7", "Hearts");
        Card instance2 = new Card("", ""); // Empty strings
        boolean expResult = false; // Correct expected result
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testToStringBoundary() {
        System.out.println("Testing toString() method in Card class (Boundary Scenario)");
        Card instance = new Card("", ""); // Empty strings
        String expResult = " of "; // Correct expected result
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    
}
