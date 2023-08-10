/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.crazyeights;
import java.util.ArrayList;
import java.util.List;
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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetNameGood() {
        System.out.println("getName");
        String playerName = "Player 1";
        Player instance = new Player(playerName);
        String expResult = playerName;
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHand method, of class Player.
     */
    @Test
    public void testGetHandGood() {
        System.out.println("getHand");
        Player instance = new Player("Player 1");
        List<Card> expResult = new ArrayList<>();
        List<Card> result = instance.getHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addCardToHand method, of class Player.
     */
    @Test
    public void testAddCardToHandGood() {
        System.out.println("addCardToHand");
        Card card = new Card("2", "Hearts");
        Player instance = new Player("Player 1");
        instance.addCardToHand(card);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of playCard method, of class Player.
     */
    @Test
    public void testPlayCardGood() {
        System.out.println("playCard");
        Card card = new Card("2", "Hearts");
        Player instance = new Player("Player 1");
        instance.addCardToHand(card);
        boolean expResult = true;
        boolean result = instance.playCard(card);
        assertEquals(expResult, result);
        assertEquals(0, instance.getHandSize());

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHandSize method, of class Player.
     */
    @Test
    public void testGetHandSizeGood() {
        System.out.println("getHandSize");
        Player instance = new Player("Player 1");
        int expResult = 0;
        int result = instance.getHandSize();
        assertEquals(expResult, result);

        Card card = new Card("2", "Hearts");
        instance.addCardToHand(card);
        assertEquals(1, instance.getHandSize());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of chooseCardToPlay method, of class Player.
     */
    @Test
    public void testChooseCardToPlayGood() {
        System.out.println("chooseCardToPlay");
       Card card = new Card("2", "Hearts");
        Player instance = new Player("Player 1");
        instance.addCardToHand(card);
        Card topDiscardCard = new Card("3", "Hearts");
        Card expResult = card;
        Card result = instance.chooseCardToPlay(topDiscardCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of chooseNewSuit method, of class Player.
     */
    @Test
    public void testChooseNewSuitGood() {
        System.out.println("chooseNewSuit");
        Player instance = new Player("Player 1");
        String expResult = "Hearts";
        String result = instance.chooseNewSuit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testGetNameBad() {
        System.out.println("getName (Bad)");
        Player instance = new Player("Player 1");
        String expResult = "WrongName";
        String result = instance.getName();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testGetHandBad() {
        System.out.println("getHand (Bad)");
        Player instance = new Player("Player 1");
        List<Card> expResult = new ArrayList<>();
        Card card = new Card("2", "Hearts");
        expResult.add(card);
        List<Card> result = instance.getHand();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testAddCardToHandBad() {
        System.out.println("addCardToHand (Bad)");
        Card card = new Card("2", "Hearts");
        Player instance = new Player("Player 1");
        instance.addCardToHand(card);
        assertFalse(instance.getHand().isEmpty());
    }

    @Test
    public void testPlayCardBad() {
        System.out.println("playCard (Bad)");
        Card card = new Card("2", "Hearts");
        Player instance = new Player("Player 1");
        boolean expResult = true;
        boolean result = instance.playCard(card);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testGetHandSizeBad() {
        System.out.println("getHandSize (Bad)");
        Player instance = new Player("Player 1");
        int expResult = 1;
        int result = instance.getHandSize();
        assertNotEquals(expResult, result);

        Card card = new Card("2", "Hearts");
        instance.addCardToHand(card);
        assertNotEquals(0, instance.getHandSize());
    }

    @Test
    public void testChooseCardToPlayBad() {
        System.out.println("chooseCardToPlay (Bad)");
        Card card = new Card("2", "Hearts");
        Player instance = new Player("Player 1");
        instance.addCardToHand(card);
        Card topDiscardCard = new Card("3", "Hearts");
        Card expResult = new Card("4", "Diamonds");
        Card result = instance.chooseCardToPlay(topDiscardCard);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testChooseNewSuitBad() {
        System.out.println("chooseNewSuit (Bad)");
        Player instance = new Player("Player 1");
        String expResult = "Spades";
        String result = instance.chooseNewSuit();
        assertNotEquals(expResult, result);
    }
    
    @Test
    public void testGetNameBoundary() {
        System.out.println("getName (Boundary)");
        Player instance = new Player("");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandBoundary() {
        System.out.println("getHand (Boundary)");
        Player instance = new Player("");
        int expResult = 0;
        int result = instance.getHand().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddCardToHandBoundary() {
        System.out.println("addCardToHand (Boundary)");
        Card card = new Card("2", "Hearts");
        Player instance = new Player("");
        instance.addCardToHand(card);
        int expResult = 1;
        int result = instance.getHand().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testPlayCardBoundary() {
        System.out.println("playCard (Boundary)");
        Card card = new Card("2", "Hearts");
        Player instance = new Player("");
        boolean expResult = false;
        boolean result = instance.playCard(card);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandSizeBoundary() {
        System.out.println("getHandSize (Boundary)");
        Player instance = new Player("");
        int expResult = 0;
        int result = instance.getHandSize();
        assertEquals(expResult, result);
    }

    @Test
    public void testChooseCardToPlayBoundary() {
        System.out.println("chooseCardToPlay (Boundary)");
        Card topDiscardCard = new Card("2", "Hearts");
        Player instance = new Player("");
        Card expResult = null;
        Card result = instance.chooseCardToPlay(topDiscardCard);
        assertEquals(expResult, result);
    }

    @Test
    public void testChooseNewSuitBoundary() {
        System.out.println("chooseNewSuit (Boundary)");
        Player instance = new Player("");
        String expResult = "";
        String result = instance.chooseNewSuit();
        assertEquals(expResult, result);
    }
    
    
}
