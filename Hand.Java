package poker;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class Hand implements Comparable<Object> 
{
	
	
    public int intValue ;
    public int maxValue ;
    public float checkR;
	
    private ArrayList<Card> theCards = new ArrayList<>();
	
	public int getIntValue()
        {
            return this.intValue;
        }
        public void setIntValue(int n)
        {
            this.intValue = n;
        }


	public Hand(ArrayList<Card> theCards) 
        {
		this.theCards = theCards;
	}
	// separates each card in a hand with spaces and a comma
	public String toString() 
        {
		String s = "";
		for (Card c : theCards) 
                {
			s += c.toString() + ", ";
		}
		return s;
	}
        
	//Sorts the cards in hand in a numerical order to check for possible winning hands. 
	private ArrayList<Card> getHandInNumericalOrder() 
        {
		ArrayList<Card> sorted = new ArrayList<Card>();
		sorted.addAll(this.theCards);
                
                //uses comparator import
		Collections.sort(sorted, new Comparator<Card>() 
                {

			@Override
			public int compare(Card o1, Card o2) 
                        {
				Integer o1Value = o1.getNumericalValue();
				Integer o2Value = o2.getNumericalValue();
				return o1Value.compareTo(o2Value);
				
			}
			
		});
		return sorted;
	}

	/**
	 * a method to get cards that have the same value
	 */
        
        //checks for pairs
        
	private boolean isPair(ArrayList<Card> sortedCards) 
        {
		
		Card previousCard = null;
		for (Card c : sortedCards) 
                {	
			if (previousCard != null && previousCard.isSameFace(c)) 
                        {
				return true;
                        }
                        else 
                        {
				previousCard = c;
			}
			
			
		}
		return false;
	}
	
	
	/**
	 * if the sum of the integer array is equal to the following:
	 * 1 - 
	 * @return
	 */
        
        //should be used to check for pairs, three of kind, and 4 of kind          //could probably use this one by itself instead of previous method
	private ArrayList<Integer> numberOfSameCards() 
        {
		ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
		
		ArrayList<Integer> cardCounts = new ArrayList<Integer>();
		int numbSame = 1;
                intValue =sortedCards.get(4).getNumericalValue();
                setIntValue(intValue);
              

		for (int i = 0; i < sortedCards.size() - 1; ++i ) 
                {
			if (sortedCards.get(i).isSameFace(sortedCards.get(i+1))) 
                        {
                            
                            //used to compare secondary values
                            intValue = sortedCards.get(i).getNumericalValue();
                            setIntValue(intValue);
	
                            ++numbSame;
			} 
                        else 
                        {
				for (int j = 0; j < numbSame; ++j) 
                                {
					cardCounts.add(numbSame);
				}
				numbSame = 1;
			}
		}
		for (int i = 0; i < numbSame; ++i) 
                {
			cardCounts.add(numbSame);
		}
		
		
		return cardCounts;
	}
	
	/**
	 * 5 - high card || straight || straight flush || flush
	 * 7 - pair
	 * 9 - 2 pair
	 * 11 - 3 of a kind
	 * 13 - full house
	 * 17 - four of a kind
	 * @param inputArray
	 * @return
	 */
	public int getSum(ArrayList<Integer> inputArray) {
		int sum = 0;
		for (int i : inputArray) {
			sum += i;
		}
		return sum;
	}
	
	/**
	 * 0 - high card
	 * 1 - pair
	 * 2 - 2 pair
	 * 3 - three of a kind
	 * 4 - straight
	 * 5 - flush
	 * 6 - full house
	 * 7 - four of a kind
	 * 8 - straight flush
	 * @return
	 */
	public int getRank() 
        {
		ArrayList<Card> sorted = this.getHandInNumericalOrder();
		int rawSum = getSum(numberOfSameCards());
                int x1;
		switch (rawSum) 
                {
			case 7:
                            x1 = 1;
				return x1;
			case 9:
                            x1 = 2;
				return x1;
			case 11:
                            x1 = 3;
				return x1;
			case 13:
                            x1 = 6;
				return x1;
			case 17:
                            x1 = 7;
				return x1;
			default:
				//TODO CHECK FOR ALL OTHER HAND TYPES
		}
		boolean isFlush = isFlush(sorted);
		boolean isStraight = isStraight(sorted);
		if (isFlush && isStraight) 
                {
                    x1 = 8;
			return x1;
		}
                else if (isFlush) 
                {
                    x1 = 5;
			return x1;
		} 
                else if (isStraight) 
                {
                    x1 = 4;
			return x1;
		} 
                else 
                {
                    x1 = 0;
			return x1;
                        
		}
	}
        
        public void displayRank(int x)
        {
            if(x == 0)
            {
                ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
                System.out.println("High Card, "+ sortedCards.get(4).getFace());
                System.out.println("");
            }
            else if(x == 1)
            {
                ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
                ArrayList<Card> sameFaceCards = this.getHandInNumericalOrder();
                
                for (int i = 0; i < sortedCards.size() - 1; ++i ) 
                {
			if (sortedCards.get(i).isSameFace(sortedCards.get(i+1))) 
                        {
                              sameFaceCards.add(sortedCards.get(i));
                        }     
                } 
                System.out.println("Pair of "+sameFaceCards.get(0).getFace() + "'s\n");
            }
            else if(x == 2)
            {
                 ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
                 ArrayList<Card> sameFaceCards = this.getHandInNumericalOrder();
                for (int i = 0; i < sortedCards.size() - 1; ++i ) 
                {
			if (sortedCards.get(i).isSameFace(sortedCards.get(i+1))) 
                        {
                            sameFaceCards.add(sortedCards.get(i));
                        }
                }        
                 System.out.println("Pair of "+sortedCards.get(0).getFace() + "'s "
                                     + "and " + sameFaceCards.get(1).getFace() + "'s\n");
            }
            else if(x == 3)
            {
                 ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
                for (int i = 0; i < sortedCards.size() - 1; ++i ) 
                {
			
                }
                System.out.println("Three of a kind,  "+sortedCards.get(2).getFace() + "'s\n");
                
            }
            else if(x == 4)
            {
                ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
                System.out.println("Straight, Highest Card: " + sortedCards.get(4).getFace());
                System.out.println("");
            }
            else if(x == 5)
            {
                ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
                System.out.println("Flush, Highest Card: " + sortedCards.get(4).getFace());
                System.out.println("");
               
            }
            else if(x == 6)
            {
                ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
                System.out.println("Full House of" + sortedCards.get(0).getFace() + "'s and " + sortedCards.get(4).getFace() + "'s\n");
            }
            else if(x == 7)
            {
                
                 ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
                for (int i = 0; i < sortedCards.size() - 1; ++i ) 
                {
			
                    System.out.println("four of a kind,  "+sortedCards.get(2).getFace() + "'s\n");
                            
                }
            }
            else
            {
                ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
                System.out.println("Straight Flush, Highest Card: " + sortedCards.get(4).getFace());
                System.out.println("");
            }
        }
	
	private boolean isFlush(ArrayList<Card> theCards) 
        {
		
		for (int i = 0; i < theCards.size() - 1; i++) 
                {
			if (!theCards.get(i).isSameSuit(theCards.get(i + 1))) 
                        {
				return false;
			}
		}
		return true;
		
	}
	
	/**
	 * 
	 * @param sortedCards - all have unique faces
	 * @return
	 */
	private boolean isStraight(ArrayList<Card> sortedCards) 
        {
		
		for (int i = 0; i < theCards.size() - 1; i++) 
                {
			int current = theCards.get(i).getNumericalValue();
			int next = theCards.get(i + 1).getNumericalValue();
			
			if (current + 1 == next || 
					(current == 5 && next == 14)) 
                        {
				continue;
			} else 
                        {
				return false;
			}
			
		}
		return true;
		
	}

	/**
	 * 0 -> equal
	 * 1 -> this > o
	 * -1 -> this < o
	 */
	@Override
	public int compareTo(Object o) 
        {
		if (!(o instanceof Hand)) {
			return 1;
		}
		Hand other = (Hand)o;
		
		boolean isThisPair = this.isPair(this.getHandInNumericalOrder());
		
		ArrayList<Card> otherNumerical = other.getHandInNumericalOrder();
		ArrayList<Card> thisNumerical = this.getHandInNumericalOrder();
		
		
		//call the card hierarchy class
	
		return 1;
	}

}
