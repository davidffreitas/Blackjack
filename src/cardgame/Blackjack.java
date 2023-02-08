package cardgame;

import java.util.Scanner;

/* This class is the main class for the game.
 *
 * @author David Freitas
 */

public class Blackjack {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();
        
        //Creating player and dealer objects
        Dealer dealer = new Dealer("Dealer");
        System.out.println("=================================");
        System.out.println(" Hello and Welcome to BlackJack!");
        System.out.println("=================================\n");
        System.out.println("Please enter your name: ");
        Player player = new Player(input.nextLine());
        
        System.out.println("Welcome " + player.getName() + "!\n");
        
        String playerChoice = "";
        
        OUTER:
        while (!playerChoice.equals("start") || !playerChoice.equals("quit")) {
            System.out.println("Enter 'start' to begin or 'quit' to exit: ");
            playerChoice = input.nextLine();
            switch (playerChoice) {
                case "start" -> {
                    Game.playRound(deck, dealer, player);
                    System.out.println("Would you like to go again?");
                    playerChoice = "";
                    player.returnHand(deck);
                    dealer.returnHand(deck);
                }
                case "quit" -> {
                    break OUTER;
                }
                default -> System.out.println("=== That is not a valid choice ===");
            }
        }
        System.out.println("Thank-you for playing have a nice day :)");
    }
}