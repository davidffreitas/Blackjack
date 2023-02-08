package cardgame;

import java.util.ArrayList;

/* This class structures the super class of the player that may be subclassed 
 *  for more functions as the game requires. It holds the Player's name, hand, 
 *  value of their hand, and overall score.
 *
 * @author David Freitas
 */

public class Player {
    private String name;
    private final ArrayList<Card> hand;
    private int handValue;
    private int score;
    
    //The constructor creates a player based off of the name, and creates an
    // empty hand
    Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        score = 100;
    }
    
    //Getter and setter for the player name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    //Returns the player's hand
    public ArrayList getHand() {
        return hand;
    }
    
    //Clears player hand after a round
    public void returnHand(Deck deck) {
        for(int r = hand.size(); r != 0; r--) {
            deck.addCard(hand.remove(0));
        }
    }
    
    //Returns the value of the player's hand
    public int getHandValue() {
        
        //Value is set to zero for calculating the value each time
        handValue = 0;
        
        //Aces can be worth either 1 or 11 based on the value of the rest of the
        // hand, so when the value exceeds 21, the ace is then converted back to
        // a value of 1
        int aces = 0;
        
        //This loop checks if there are any aces in the hand
        for(Card card : hand) {
            handValue += card.getValue().getRank();
            if(card.getValue().getRank() == 11){
                aces += 1;
            }
            
        //This loop removes the ace's extra value and rolls back the number of 
        // aces to be found for this iteration
        } if(handValue > 21 && aces > 0) {
            while(handValue > 21 && aces > 0) {
                handValue -=10;
                aces -=1;
            }
        }
        
        //Gives the calculated value of the hand
        return handValue;
    }
    
    //Getter and function to add score value on top of the player's score, as
    // well as a function to clear the score if the player quits the game
    public int getScore() { return score; }
    public void wager(int bet) { this.score -= bet; }
    public void addScore(int score) { this.score += score; }
    public void clearScore() { score = 0; }
    
    //Takes a card and adds it to the player's hand
    public void getCard(Card card) {
        hand.add(card);
    }
    
    public String handToString() {
        String handString = "";
        for(Card card : hand) {
            handString += card.toString() + " ";
        }
        return handString + "\n -> " + getHandValue();
    }
}