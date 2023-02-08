package cardgame;

/*
 *
 * @author Emily
 */

enum Suit { HEARTS,DIAMONDS,SPADES,CLUBS };
enum Value { ACE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8)
    ,NINE(9),TEN(10),JACK(10),QUEEN(10),KING(10);
    
    public int rank;

    public int getRank() {
        return rank;
    }
 
    Value(int rank){
        this.rank=rank;           
    }
}

public class Card { //Created enum for suits and Value
    private Suit suit;
    private Value value;
    
    // Created Constructor
    public Card(Suit suit, Value value) {
        this.suit=suit;
        this.value=value;
    }
    
    public Suit getSuit(){
       return suit;
    }

    public void setSuit(Suit suit){
         this.suit=suit;
    }
    
     public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[ " + getValue() + " of " + getSuit() + " ]";
    }
}