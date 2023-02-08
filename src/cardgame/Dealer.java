package cardgame;

/* This class inherits from the player class to add dealing funtions, such as
 *  the initial dealing of the cards as well as dealing more cards as the player
 *  desires.
 *
 * @author David Freitas
 */

///Dealer gains all properties from the player class
public class Dealer extends Player{
    
    public Dealer(String name) {
        super(name);
    }
    
    //The dealer is able to deal a hand by drawing from a deck of cards and
    // giving it to a player object twice (the size of a blackjack hand is 2)
    public void dealHands(Deck deck, Player[] players) {
        for(int h = 0; h < 2; h++)
            for(Player p : players) {
                p.getCard(deck.drawCard());
            }
    }
    
    //The dealer is able to deal individual cards as well
    public void dealCard(Deck deck, Player player) {
        player.getCard(deck.drawCard());
    }
}