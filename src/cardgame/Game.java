package cardgame;

import java.util.Scanner;

/* This class serves as the main game function of the program. This is where
 *  the gameloop is defined, and includes methods to add and remove bets placed
 *  by the player. This class also contains the check win and lose conditions 
 *  which determines the outcome of the game.
 *
 * @author David Freitas
 */

public class Game {
    
    public static void playRound(Deck deck, Dealer dealer, Player player) {
        
        Scanner input = new Scanner(System.in);
        Scanner wagerInput = new Scanner(System.in);
        int bet = 0;
        
        System.out.println(">>Shuffling deck...\n");
        deck.generateDeck();
        deck.shuffle();
        deck.cutTheDeck();
        
        System.out.println(">>Dealing cards...\n");
        Player[] players = {dealer, player};
        dealer.dealHands(deck, players);
        
        System.out.println("What is your wager: ");
        while(bet <= 0 || bet > player.getScore()) {
            bet = wagerInput.nextInt();
            if(bet > player.getScore()) {
                System.out.println("Your wager cannot be more than your current score.");
            } else if(bet <= 0) {
                System.out.println("Your wager needs to be more than 0");
            }
        }
        player.wager(bet);
        
        System.out.println("Dealer's Hand:\n"
                + dealer.getHand().get(0).toString() + " [?]\n");
        System.out.println("Your Hand: \n" + player.handToString());
        
        String hitOrStand = "";
        
        while(!hitOrStand.equals("stand")) {
            
            System.out.println("Would you like to 'hit' or 'stand'?");
            hitOrStand = input.nextLine();
            
            if(hitOrStand.equals("hit")) {
                dealer.dealCard(deck, player);
                System.out.println("Your Hand: \n" + player.handToString());
                if(checkBust(player) == true) {
                    System.out.println("Player Bust!");
                    hasLost(player, bet);
                    return;
                }
                hitOrStand = "";
            } else if(hitOrStand.equals("stand")) {
                System.out.println("Dealer's Hand:\n" + dealer.handToString());
                
                while(dealer.getHandValue() < 16) {
                    dealer.dealCard(deck, dealer);
                    System.out.println(dealer.handToString());
                }
                
                if(checkBust(dealer) == true) {
                    System.out.println("Dealer Bust!");
                    hasWon(player, bet);
                } else {
                    if(player.getHandValue() > dealer.getHandValue()) {
                        hasWon(player, bet);
                    } else {
                        hasLost(player, bet);
                    }
                }
                return;
            }
        }
    }
    
    public static boolean checkBust(Player player) {
        return player.getHandValue() > 21;
    }
    
    public static boolean checkWin(Player player, Dealer dealer) {
        return player.getHandValue() > dealer.getHandValue();
    }
    
    public static void hasWon(Player player, int wager) {
        System.out.println(player.getName() + " Wins!");
        player.addScore(wager*2);
        System.out.println("You won: " + wager*2);
        System.out.println("Your score is now: " + player.getScore() + "\n");
    }
    public static void hasLost(Player player, int wager) {
        System.out.println(player.getName() + " Lost :(");
        try {
            if(player.getScore() <= 0)
                throw new Exception();
            System.out.println("You lost: " + wager);
            System.out.println("Your score is now " + player.getScore() + "\n");
            
        } catch (Exception ex) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }
}