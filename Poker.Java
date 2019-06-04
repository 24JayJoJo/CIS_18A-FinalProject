/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Leodan
 */
public class Poker {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        char ans;
        double cash = 500;
        int win = 0,lose = 0;
        int x;
        Card c = new Card("Diamond", "2");
        Scanner keyboard = new Scanner(System.in);
        
        do
        {
            menu();

            try {
                x = Integer.parseInt(keyboard.nextLine());
                while(x < 1 || x > 5)
            {
                System.out.println("invalid choice. Choose from 1 through 5:");
                x = Integer.parseInt(keyboard.nextLine());
                
            }
            } catch (NumberFormatException numberFormatException) {
                
                System.out.println("Wrong Input try Again");
                x = Integer.parseInt(keyboard.nextLine());
                
            }
            
                
            switch(x)
            {
                case 1:
                {
                    playGame(cash, win, lose, x);
                    
                    break;
                }
                case 2:
                {
                    playGame(cash, win, lose, x);
                    break;
                }
                case 3:
                {
                    playGame(cash, win, lose, x);
                    break;
                }
                case 4:
                {
                    playGame(cash, win, lose, x);
                    break;
                }
                case 5:
                {
                    System.exit(0);
                }

                
            }
            

            System.out.println("Would you like to go back to the main menu?(Y/N)");
            ans = keyboard.nextLine().charAt(0);
        }while(ans == 'Y' || ans == 'y');
        
        System.exit(0);
    }
    
    public static void menu()
    {
        System.out.println("Welcome to Digital Poker!");
        System.out.println("1. Start Game.");
        System.out.println("2. Load saved File.");
        System.out.println("3. Check Cash, Wins and Loses.");
        System.out.println("4. Game Rules.");
        System.out.println("5. Exit Game.");
        System.out.print("Enter in the number of your choice: ");

    }
    
    public static void playGame(double ca, int w, int lo, int x) throws FileNotFoundException
    {
        String ans = "Y";
        String fname;
        Scanner keyboard = new Scanner(System.in);
        PrintWriter printer = null;
        FileWriter fwrite = null;
        
        if(x == 1)
        {
                while (ans.equalsIgnoreCase("Y"))
                {
                    if(ca > 0)
                    {
                        enterPokerTable(ca, w, lo);
                    }
                    else
                    {
                        System.out.println("You have 0 dollars now. YOUR BROKE. YOU LOSE!!!");
                        System.exit(0);
                    }
                    System.out.println("would you like to try again?");
                    try {
                        ans = keyboard.nextLine().substring(0, 1);
                        while(! (ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("N")))
                        {
                            System.out.print("Invalid Input 1. Try Again: ");
                            ans = keyboard.nextLine().substring(0, 1);
                        }
                    } catch (Exception e) {
                        System.out.print("Invalid Input 2. Try Again: ");
                        ans = keyboard.nextLine().substring(0, 1);
                    }
                }

                System.out.println("would you like to save the game?(Y/N)");
                try {
                        ans = keyboard.nextLine().substring(0, 1);
                        while(! (ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("N")))
                        {
                            System.out.print("Invalid Input 1. Try Again: ");
                            ans = keyboard.nextLine().substring(0, 1);
                        }
                    } catch (Exception e) {
                        System.out.print("Invalid Input 2. Try Again: ");
                        ans = keyboard.nextLine().substring(0, 1);
                    }

                while(ans.equalsIgnoreCase("Y"))
                {
                    System.out.println("Please enter in a file name: ");
                    fname = keyboard.nextLine();
                    try 
                    {
                        fwrite = new FileWriter(fname, true);
                        printer = new PrintWriter(fwrite);
                    } 
                    catch (IOException ex)
                    {
                       System.out.println("Blah - Some other io exception");
                    }

                    printer.println(ca + " " + w + " " + lo);

                    printer.close();
                }
            }
                
        else if (x == 2)
        {
            System.out.print("Please enter in your file name: ");
                    fname = keyboard.nextLine();
                    File myFile = new File(fname);
                    Scanner input = null;
                     input = new Scanner(myFile);
                    String lastLine = "";
        //            * Output ONLY the last line you read back from the file.
                    while (input.hasNextLine())
                    {
                        lastLine = input.nextLine();
                    }String[] arrOfStr = lastLine.split(" ", 3);
                    
                    
                    
                    ca = Float.parseFloat(arrOfStr[0]);
                    w = Integer.parseInt(arrOfStr[1]);
                    lo = Integer.parseInt(arrOfStr[2]);
                            
                while (ans.equalsIgnoreCase("Y"))
                {
                    if(ca > 0)
                    {
                        enterPokerTable(ca, w, lo);
                    }
                    else
                    {
                        System.out.println("You have 0 dollars now. YOUR BROKE. YOU LOSE!!!");
                        System.exit(0);
                    }
                    System.out.println("would you like to try again?");
                    try {
                        ans = keyboard.nextLine().substring(0, 1);
                        while(! (ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("N")))
                        {
                            System.out.print("Invalid Input 1. Try Again: ");
                            ans = keyboard.nextLine().substring(0, 1);
                        }
                    } catch (Exception e) {
                        System.out.print("Invalid Input 2. Try Again: ");
                        ans = keyboard.nextLine().substring(0, 1);
                    }
                }
                    try 
                    {
                        fwrite = new FileWriter(fname, true);
                        printer = new PrintWriter(fwrite);
                    } 
                    catch (IOException ex)
                    {
                       System.out.println("Blah - Some other io exception");
                    }

                    printer.println(ca + " " + w + " " + lo);

                    printer.close();
                
        }
        else if(x == 3)
        {
            System.out.println("Enter in file name to check how many your cash, wins and loses:");
             fname = keyboard.nextLine();
                    File myFile = new File(fname);
                    Scanner input = null;
                    try {
                         input = new Scanner(myFile);
                        } catch (FileNotFoundException ex) {
                            System.out.println("File not found!");
                        }
                    String lastLine = "";
        //            * Output ONLY the last line you read back from the file.
                    while (input.hasNextLine())
                    {
                        lastLine = input.nextLine();
                    }
                    
                    String[] arrOfStr = lastLine.split(" ", 3);
                    
                    System.out.println("Cash: $" + arrOfStr[0] + " Wins: " + arrOfStr[1] + " Loses: " + arrOfStr[2]);        
        }
      else
        {
            System.out.println("Digital Poker Rules.");
            System.out.println("It's your hand against the opponent's hand, Highest hand wins.");
            System.out.println("You start with $500 and can bet any amount within your wallet limit.");
            System.out.println("If you reach $0 then it's game over!....Loser");
            System.out.println("If your hand wins, payout is 2:1.");
            System.out.println("If you lose, you will lose your bet.");
            System.out.println("If you tie with your opponent, you will neither win nor lose money.");
        }

    }
    public static void enterPokerTable(double ca, int w, int lo)
    {
        double bet = 0;
        Scanner keyboard = new Scanner(System.in);
        
        CardDeck d = CardDeck.getStandardDeck();
                        d.shuffle();
                        ArrayList<Card> cards1 = new ArrayList<>();
                        ArrayList<Card> cards2 = new ArrayList<>();

                        for (int i = 0; i < 5; ++i)
                        {
                            cards1.add(d.deal());	
                            cards2.add(d.deal());
                        }
                        Hand hand1 = new Hand(cards1);
                        Hand hand2 = new Hand(cards2);


                        System.out.println("How much money would you like to gamble?");
                        System.out.println("Your cash: $" + ca);
                        System.out.print("Gamble ammount: $");
                        try {
                            bet = Double.parseDouble(keyboard.nextLine());
                            while(bet > ca)
                            {
                                System.out.println("You do not have that much money. Please enter a different value:");
                                bet = Double.parseDouble(keyboard.nextLine());
                                  keyboard.close();
                            }
                        } catch (NumberFormatException numberFormatException) {
                            System.out.print("Invalid Input. Try Again: $");
                            bet = Double.parseDouble(keyboard.nextLine());
                            keyboard.close();
                        }

                        if(hand1.getRank() > hand2.getRank())
                        {
                            System.out.println("Your hand: " + hand1);
                            System.out.print("You have a ");
                            hand1.displayRank(hand1.getRank());
                            System.out.println("Opponents hand: " + hand2);
                            System.out.print("Opponent has a ");
                            hand2.displayRank(hand2.getRank());
                            System.out.println("You win!!!");
                            ca += bet ;
                            w++;
                        }
                        else if (hand1.getRank() < hand2.getRank())
                        {
                            System.out.println("Your hand: " + hand1);
                            System.out.print("You have a ");
                            hand1.displayRank(hand1.getRank());
                            System.out.println("Opponents hand: " + hand2);
                            System.out.print("Opponent has a ");
                            hand2.displayRank(hand2.getRank());
                            System.out.println("You lose to hand 2");
                            ca -= bet;
                            lo++;
                        }
                       else
                        {
                            System.out.println("No one wins what.");
                            if(hand1.getRank() == hand2.getRank())
                            {
                                int u,m;
                                u = Integer.parseInt(hand1.getIntValue());
                                m = Integer.parseInt(hand2.getIntValue());
                                
                                if(u > m)
                                {
                                        System.out.println("Your hand: " + hand1);
                                        System.out.print("You have a ");
                                        hand1.displayRank(hand1.getRank());
                                        System.out.println("Opponents hand: " + hand2);
                                        System.out.print("Opponent has a ");
                                        hand2.displayRank(hand2.getRank());
                                        System.out.println("You win!!!");
                                        ca += bet;
                                        w++;
                                }
                                else if (u < m)
                                {
                                    System.out.println("Your hand: " + hand1);
                                    System.out.print("You have a ");
                                    hand1.displayRank(hand1.getRank());
                                    System.out.println("Opponents hand: " + hand2);
                                    System.out.print("Opponent has a ");
                                    hand2.displayRank(hand2.getRank());
                                    System.out.println("You lose to hand 2");
                                    ca -= bet;
                                    lo++;
                                }
                                else
                                {
                                   //program crashes here, need to keep it going again. 
                                    System.out.println("Tie As fuck");
                                }
                            
                                }
                        }
    }
}

