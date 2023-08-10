/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crazyeights;

/**
 *
 * @author LENOVO
 */
import java.util.List;
import java.util.Scanner;  
import java.util.ArrayList;


public class Game {
    private List<Player> players;
    private Deck deck;
    private List<Card> discardPile;
    private int currentPlayerIndex;

    public Game(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }

        deck = new Deck();
        discardPile = new ArrayList<>();
        dealInitialCards();
        currentPlayerIndex = 0;
    }
    public List<Player> determineWinner() {
        List<Player> potentialWinners = new ArrayList<>();
        Player winner = players.get(0);
        int minCards = winner.getHandSize();
    
        for (Player player : players) {
            int handSize = player.getHandSize();
            if (handSize < minCards) {
                minCards = handSize;
                potentialWinners.clear();
                potentialWinners.add(player);
            } else if (handSize == minCards) {
                potentialWinners.add(player);
            }
        }
    
        return potentialWinners;
    }
    
    
    private void dealInitialCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                Card card = deck.drawCard();
                player.addCardToHand(card);
            }
        }
        if (deck.isEmpty()) {
            deck.reshuffleFromDiscardPile(discardPile);
        }
        discardPile.add(deck.drawCard());
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
    
        while (!gameWon) {
            Player currentPlayer = players.get(currentPlayerIndex);
    
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");
            displayGameState();
    
            Card topDiscardCard = discardPile.get(discardPile.size() - 1);
            Card selectedCard = currentPlayer.chooseCardToPlay(topDiscardCard);
            if (deck.isEmpty()) {
                List<Player> potentialWinners = determineWinner();
                if (potentialWinners.size() == 1) {
                    System.out.println(potentialWinners.get(0).getName() + " has won!");
                } else {
                    System.out.println("It's a tie between:");
                    for (Player player : potentialWinners) {
                        System.out.println(player.getName());
                    }
                }
                gameWon = true;
                break;
            }
            if (selectedCard == null) {
                Card drawnCard = deck.drawCard();
                currentPlayer.addCardToHand(drawnCard);
                System.out.println(currentPlayer.getName() + " drew a card.");
            } else {
                if (currentPlayer.getHand().contains(selectedCard)) { // Check if the selected card is in the player's hand
                    discardPile.add(selectedCard);
                    currentPlayer.playCard(selectedCard); // Play the card from the player's hand
                    System.out.println(currentPlayer.getName() + " played " + selectedCard.toString());
    
                    if (selectedCard.isEight()) {
                        String newSuit = currentPlayer.chooseNewSuit();
                        selectedCard.applySpecialEffect(newSuit);
                        System.out.println(currentPlayer.getName() + " changed the suit to " + newSuit);
                    }
    
                    if (currentPlayer.getHandSize() == 0) {
                        System.out.println(currentPlayer.getName() + " has won!");
                        gameWon = true;
                        break;
                    }
                } else {
                    System.out.println("Invalid card selection. Cannot play the chosen card.");
                }
            }
    
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    
        scanner.close();
    }
    


    private void displayGameState() {
        // Implement code to display the current game state
        System.out.println("Top discard card: " + discardPile.get(discardPile.size() - 1).toString());

        for (Player player : players) {
            System.out.println(player.getName() + "'s hand:");
            for (Card card : player.getHand()) {
                System.out.println("  " + card.toString());
            }
            System.out.println();
        }
    
        System.out.println("Number of cards in the deck: " + deck.getNumberOfCards());
    }

    public static void main(String[] args) {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("Player 1");
        playerNames.add("Player 2");
        // Add more player names if needed

        Game game = new Game(playerNames);
        game.playGame();
    }
}
