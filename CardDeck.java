package poker;



import java.util.ArrayList;



public class CardDeck {
	//Creates array to store deck cards
	private ArrayList<Card> deck = new ArrayList<>();
	//Creates all possible cards in deck 
	private CardDeck(String[] suits, String[] ranks) {
		//for (int i = 0; i < suits.length; ++i) {
		//String suit = suits[i];
		for (String suit : suits) {
			for (String rank : ranks) {
				deck.add(new Card(suit, rank));
			}
		}
	}
	//checks if deck is empty or not
	public Card deal() {
		if (!deck.isEmpty()) {
			return deck.remove(0);
		} else {
			return null;
		}
	}
	//Returns a standard deck when called
	public static CardDeck getStandardDeck() {
		String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
							"9", "10", "J", "Q", "K", "A"};
		return new CardDeck(suits, ranks);
	}
	
		
		
	
	//shuffles cards in deck 
	public void shuffle() {
		Shuffler<Card> s = new Shuffler<>();
		deck = s.shuffle(deck);
	}
	
	
}
