
package poker;



public class Card  {

	// Heart, Spade, Club, Diamond
	private String suit;
        
        //"2", "3", "4", "5", "6", "7", "8","9", "10", "J", "Q", "K", "A"
	private String face;
        
	/**
	 * @param suit
	 * @param face
	 */
        //Creates all possible card combinations (max of 52 combinations
	public Card(String suit, String face) {
            
		this.suit = suit;
		this.face = face;
	}
	public String getSuit() {
		return suit;
	}
	public String getFace() {
		return face;
	}
	//checks hand to see if you have same suits (for a possible flush)
	public boolean isSameSuit(Card c) {
		return this.suit.equals(c.getSuit());
	}
	//Checks hand for similar face cards( For pairs, 3 & 4 of kind)
	public boolean isSameFace(Card c) {
		return this.face.equals(c.getFace());
	}
	//applies numerical value to face cards with letters
	public int getNumericalValue() {
		if (face.equals("Ace")) {
			return 14;
		} else if (face.equals("King")) {
			return 13;
		} else if (face.equals("Queen")) {
			return 12;
		} else if (face.equals("Jack")) {
			return 11;
		} else {
                    //returns value of face if not a letter
			return Integer.parseInt(face);
		}
	}
	//Creates the output of a single card. 
	public String toString() {
		return face + " of " + suit;
	}


	
	
	
	
	
	
}
