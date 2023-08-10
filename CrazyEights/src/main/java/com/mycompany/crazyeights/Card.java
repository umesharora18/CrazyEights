/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crazyeights;

/**
 *
 * @author LENOVO
 */
public class Card {
    private String rank; // "2", "3", ..., "10", "J", "Q", "K", "A", "8"
    private String suit; // "Hearts", "Diamonds", "Clubs", "Spades"

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isEight() {
        return rank.equals("8");
    }

    // Define special effects for "8" cards
    public void applySpecialEffect(String newSuit) {
        if (isEight()) {
            this.suit = newSuit;
        }
    }
    @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Card otherCard = (Card) obj;
    return rank.equals(otherCard.rank) && suit.equals(otherCard.suit);
}


    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
