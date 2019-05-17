/*
Source files export
https://drive.google.com/open?id=16_3SyCj9N-2BmG1nCpaGj8nBwmlXcMoX
 
 */
package poker;

import java.util.ArrayList;


/**
 *
 * @author Leodan
 */
public class Poker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
	Card c = new Card("Diamond", "2");
		CardDeck d = CardDeck.getStandardDeck();
		d.shuffle();
		ArrayList<Card> cards1 = new ArrayList<>();
		ArrayList<Card> cards2 = new ArrayList<>();

		for (int i = 0; i < 5; ++i) {
			cards1.add(d.deal());	
			cards2.add(d.deal());
		}
		Hand hand1 = new Hand(cards1);
		Hand hand2 = new Hand(cards2);
		
		
		
		
		System.out.println(hand1);
		System.out.println(hand2);
		
    }
    
}
