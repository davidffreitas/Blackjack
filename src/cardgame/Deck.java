package cardgame;

import cardgame.Card.*;
import java.util.ArrayList;
import java.util.Random;

/* This class structures the deck of the game and will create an ArrayList of 
 *  unique cards upon the calling of its constructor class. Further the deck
 *  can be shuffled and cards may be taken from it.
 *
 * @author David Freitas
 */

public class Deck {
    private ArrayList<Card> cards;
    
    //Creates an empty ArrayList of cards to be filled in with the below methods
    public Deck(){
        cards = new ArrayList<>();
    }
    
    //Clears the deck and populates it
    public void generateDeck() {
        for(int r = cards.size(); r != 0; r--) {
            cards.remove(0);
        }
        
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Value.values().length; j++) {
                Suit suit = Suit.values()[i];
                Value value = Value.values()[j];
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }
    
    //Shuffles the deck
    public void shuffle() {
        //Creates temporary deck for cards to be added to and then used to add
        // back into the cards property
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        
        //For the duration of the size of the deck, a random card is taken and
        // put on top of the temporary deck
        while(cards.isEmpty() != true) {
            shuffledDeck.add(cards.remove((int)(Math.random()*(cards.size()))));
        }
        //After, the cards property is equal to a shuffled deck
        cards = shuffledDeck;
    }
    
    //Method cut the Deck
    public  void cutTheDeck() {
        Random r = new Random();
        int index = r.nextInt(52);
        for (int i = 0; i<= index; i++) {
            Card temp = cards.get(0);
            cards.remove(0);
            cards.add(temp);

        }
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    //Removes card from top of the deck
    public Card drawCard() {
        return cards.remove(0);
    }
    
    //Returns the cards currently in the deck
    @Override
    public String toString() {
        String deckString = "";
        for(Card c : cards) {
            deckString += c.toString() + "\n";
        }
        return deckString;
    }
}