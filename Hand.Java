package poker;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Hand  {

//Variables
 private ArrayList<Card> heldCards;
        
 
 
 //Methods
    Hand(ArrayList<Card> theCards) {

                this.heldCards = new ArrayList<>(theCards);
        }
    
    

        // separates each card in a hand with spaces and a comma
        //NEEDED TO OUTPUT THE HANDS
        public String toString() {                      //Do NOT REMOVE THIS
                String s = "";
                for (Card c : heldCards) {
                        s += c.toString() + ", ";
                }
                return s;
        }
                
        
        //Sorts the cards in hand in a numerical order to check for possible winning hands. 
//      public void sortHand(Hand test){
//          Collections.sort(test.getFace());
//      }

        /**
         * a method to get cards that have the same value
         */

        //checks for pairs

        private boolean isPair(ArrayList<Card> sortedCards) {

                Card previousCard = null;
                for (Card c : sortedCards) {
                        /*                                                      //Not used 
                        if (previousCard == null) {
                                previousCard = c;
                        } else {
                                if (previousCard.isSameFace(c)) {
                                        return true;
                                } else {
                                        previousCard = c;
                                }
                        }
                        */
                        if (previousCard != null && previousCard.isSameFace(c)) {
                                return true;
                        } else {
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
//        private ArrayList<Integer> numberOfSameCards() {
//                ArrayList<Card> sortedCards = this.getHandInNumericalOrder();
//
//                ArrayList<Integer> cardCounts = new ArrayList<Integer>();
//                int numbSame = 1;
//                for (int i = 0; i < sortedCards.size() - 1; ++i ) {
//                        if (sortedCards.get(i).isSameFace(sortedCards.get(i+1))) {
//                                ++numbSame;
//                        } else {
//                                for (int j = 0; j < numbSame; ++j) {
//                                        cardCounts.add(numbSame);
//                                }
//                                numbSame = 1;
//                        }
//                }
//                for (int i = 0; i < numbSame; ++i) {
//                        cardCounts.add(numbSame);
//                }
//
//
//                return cardCounts;
//        }

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
        private int getSum(ArrayList<Integer> inputArray) {
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
//        private int getRank() {
//                ArrayList<Card> sorted = this.getHandInNumericalOrder();
//                int rawSum = getSum(numberOfSameCards());
//                switch (rawSum) {
//                        case 7:
//                                return 1;
//                        case 9:
//                                return 2;
//                        case 11:
//                                return 3;
//                        case 13:
//                                return 6;
//                        case 17:
//                                return 7;
//                        default:
//                                //TODO CHECK FOR ALL OTHER HAND TYPES
//                }
//                boolean isFlush = isFlush(sorted);
//                boolean isStraight = isStraight(sorted);
//                if (isFlush && isStraight) {
//                        return 8;
//                } else if (isFlush) {
//                        return 5;
//                } else if (isStraight) {
//                        return 4;
//                } else {
//                        return 0;
//                }
//        }

        private boolean isFlush(ArrayList<Card> theCards) {

                for (int i = 0; i < theCards.size() - 1; i++) {
                        if (!theCards.get(i).isSameSuit(theCards.get(i + 1))) {
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
//        private boolean isStraight(ArrayList<Card> sortedCards) {
//
//                for (int i = 0; i < theCards.size() - 1; i++) {
//                        int current = theCards.get(i).getNumericalValue();
//                        int next = theCards.get(i + 1).getNumericalValue();
//
//                        if (current + 1 == next || 
//                                        (current == 5 && next == 14)) {
//                                continue;
//                        } else {
//                                return false;
//                        }
//
//                }
//                return true;
//
//        }

        /**
         * 0 -> equal
         * 1 -> this > o
         * -1 -> this < o
         */

//        public int compareTo(Object o) {
//                if (!(o instanceof Hand)) {
//                        return 1;
//                }
//                Hand other = (Hand)o;
//
//                boolean isThisPair = this.isPair(this.getHandInNumericalOrder());
//
//                ArrayList<Card> otherNumerical = other.getHandInNumericalOrder();
//                ArrayList<Card> thisNumerical = this.getHandInNumericalOrder();
//
//
//                //call the card hierarchy class
//                // TODO Auto-generated method stub
//                return 1;
//        }

    private int getsize() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


    }


    // Sample code to use the comparator operater properly. Source: https://examples.javacodegeeks.com/java-basics/java-comparable-example/
    /*
    Company.java:


    public class Company {
    private int num_of_employess;
    private String name;
    public Company(String name, int num_of_employess) {
        this.name = name;
        this.num_of_employess = num_of_employess;
    }

    public int getNumOfEmployess() {
        return this.num_of_employess;
    }

    public String getName() {
        return this.name;
    }
    }
    SortCompanies.java:


    import java.util.Comparator;

    public class SortCompanies implements Comparator {

    @Override
    public int compare(Company comp1, Company comp2) {        
        if(comp1.getNumOfEmployess()== comp2.getNumOfEmployess())
            return 0;
        else
            return comp1.getNumOfEmployess() > comp2.getNumOfEmployess() ? 1 : -1;
    }

    public static void main(String[] args) {
        Company comp1 = new Company("Company1", 20);
        Company comp2 = new Company("Company2", 15);

        SortCompanies sortCmp = new SortCompanies();

        int retval = sortCmp.compare(comp1, comp2);
        switch(retval) {
            case -1: {
                System.out.println("The " + comp2.getName() + " is bigger!");
                break;
            }
            case 1: {
                System.out.println("The " + comp1.getName() + " is bigger!");
                break;
            }
            default:
                System.out.println("The two companies are of the same size!");
        }
    }
    }
    In this example we first created a class Company that consists of the company’s name, along with its number of employees. Then, we created the SortCompanies class, which implements the Comparator interface and aims to impose an order between instances of the Company class, based on their number of employees.

    A sample execution is shown below:

    The Company1 is bigger!
    Sort Collections
    When a Java class implements the Comparable interface, then a collection of that object can be sorted automatically by using the Collections.sort or the Arrays.sort method. The collection will be sorted based on the natural order defined by the compareTo method.

    A sample example that shows how to sort a collection of Comparable objects is shown below:

    PersonCollections.java:

    01
    02
    03
    04
    05
    06
    07
    08
    09
    10
    11
    12
    13
    14
    15
    16
    17
    18
    19
    20
    21
    22
    23
    24
    25
    26
    27
    28
    29
    30
    31
    32
    33
    34
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.Random;

    public class PersonCollections {

    private static final int SIZE = 20;

    public static void main(String[] args) {
        List persons = new ArrayList(SIZE);

        // Create a number of persons with random age.
        Random rand = new Random();

        for(int i = 1; i <= SIZE; ++i) {
            int randAge = rand.nextInt(50) + 1;
            persons.add(new Person("Person" + i, randAge));
        }

        // Print all persons before ordering them.
        for(int i = 0; i < SIZE; ++i)
            System.out.println(persons.get(i).toString());
        System.out.println();

        // Sort the collection based on the age of each person.
        Collections.sort(persons);

        // Print all persons after ordering them.
        for(int i = 0; i < SIZE; ++i)
            System.out.println(persons.get(i).toString());
        System.out.println();
    }
    }
    */

