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
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            reshuffleFromDiscardPile(cards);
        }

        if (!cards.isEmpty()) {
            return cards.remove(0);
        }

        return null; // Deck is still empty after reshuffle
    }

    
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void reshuffleFromDiscardPile(List<Card> discardPile) {
        Card topDiscardCard = discardPile.remove(discardPile.size() - 1);
        cards.addAll(discardPile);
        discardPile.clear();
        Collections.shuffle(cards);
        cards.add(0, topDiscardCard);
    }

    public int getNumberOfCards() {
        return cards.size();
    }
    
}
