package poker;



import java.util.ArrayList;



public class CardDeck {
        //
	//Creates array to store deck cards
        //
	private ArrayList<Card> deck = new ArrayList<>();
        //
	//Creates all possible cards in deck 
        //
	private CardDeck(String[] suits, String[] faces) {
		//for (int i = 0; i < suits.length; ++i) {
		//String suit = suits[i];
		for (String suit : suits) {
			for (String face : faces) {
				deck.add(new Card(suit, face));
			}
		}
        }
 
        //
	//checks if deck is empty or not
	//Called in Poker.java
        public Card deal() {
		if (!deck.isEmpty()) {
			return deck.remove(0);
		} else {
			return null;
		}
	}
        //
	//Returns a standard deck when called
	//
        public static CardDeck getStandardDeck() {
		String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
		String[] faces = {"2", "3", "4", "5", "6", "7", "8",
                                    "9", "10", "Jack", "Queen", "King", "Ace"};
		return new CardDeck(suits, faces);
	}
		
		
	//
	//shuffles cards in deck 
        //Called in Poker.java
	public void shuffle() {
		Shuffler<Card> s = new Shuffler<>();
		deck = s.shuffle(deck);
	}
        
	
}
