/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crazyeights;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    
    public boolean playCard(Card card) {
        if (hand.contains(card)) {
            hand.remove(card);
            return true; // Card played successfully
        }
        return false; // Card not found in hand
    }
    

    public int getHandSize() {
        return hand.size();
    }

    public Card chooseCardToPlay(Card topDiscardCard) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your hand:");
        displayHand();

        System.out.println("Top discard card: " + topDiscardCard.toString());
        System.out.print("Enter the index of the card you want to play, or -1 to draw a card: ");
        int index = scanner.nextInt();

        if (index == -1) {
            return null;
        }

        if (index >= 0 && index < hand.size()) {
            Card selectedCard = hand.get(index);
            if (selectedCard.getRank().equals(topDiscardCard.getRank()) ||
                selectedCard.getSuit().equals(topDiscardCard.getSuit())) {
                return selectedCard;
            } else {
                System.out.println("Invalid card selection. Must match rank or suit.");
            }
        } else {
            System.out.println("Invalid index. Please choose a valid card or -1 to draw.");
        }

        return chooseCardToPlay(topDiscardCard);
    }

    public String chooseNewSuit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a new suit for the '8' card:");
        System.out.println("1. Hearts");
        System.out.println("2. Diamonds");
        System.out.println("3. Clubs");
        System.out.println("4. Spades");
        System.out.print("Enter the number corresponding to the suit: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return "Hearts";
            case 2:
                return "Diamonds";
            case 3:
                return "Clubs";
            case 4:
                return "Spades";
            default:
                System.out.println("Invalid choice. Please choose a valid suit.");
                return chooseNewSuit();
        }
    }

    private void displayHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + ": " + hand.get(i).toString());
        }
    }
}
