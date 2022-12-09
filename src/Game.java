import java.util.ArrayList;
import java.util.Scanner;
//Kayan Sunderam 12/8/22

public class Game
{
    private Deck set;
    private Player one;
    private Player two;
    private int random;
    private int roundsPlayed;
    private ArrayList<String> ranks;
    private ArrayList<String> suits;
    private ArrayList<Integer> points;



    public Game(String nm1, String nm2)
    {
        //array list being filled out to initialize cards
        ranks = new ArrayList<>();
        suits = new ArrayList<>();
        points = new ArrayList<>();
        for (int i = 2; i < 11; i++)
        {
            //convert i to a string
            String cardRank = "" + i;
            ranks.add(cardRank);
            points.add(i);
        }
        for (int i = 1; i < 5; i++)
        {
            points.add(10 + i);
        }
        ranks.add("Jack");
        ranks.add("Queen");
        ranks.add("King");
        ranks.add("Ace");

        suits.add("Clubs");
        suits.add("Spades");
        suits.add("Hearts");
        suits.add("Diamonds");

        set = new Deck(ranks, suits, points);
        //declares new players
        one = new Player(nm1);
        two = new Player(nm2);
        //random number between 10 and 14--will determine number of rounds
        random = (int)((Math.random() * 5) + 10);
//        System.out.println(ranks);
//        System.out.println(suits);
//        System.out.println(points);
    }

    public void giveCards()
    {
        //shuffle cards again
        set.shuffle();
        //dea; the cards out
        for (int i = 0; i < 52; i++)
        {
            if (i % 2 == 0)
            {
                one.addCards(set.deal());
                //System.out.println(one.getHand());
            }
            if (i % 2 == 1)
            {
                two.addCards(set.deal());
                //System.out.println(two.getHand());
            }
        }
    }

    public static void printInstructions()
    {
        System.out.println("This is War!!!\nIt is a two-player game. Each player will have 1/2 deck of shuffled cards "
        + "to start.\nThen both of you will place down the top card from your hand (without knowing what it will be)."
        + "\nWhoever has the higher ranked card of the two takes two points (your card and their card).\nIf the cards "
        + "have equal rank (eg: Jack of Clubs, Jack of Hearts), then you will place down three more cards. Whoever has "
        + "thd highest ranking card out of all these 8 cards gets to collect 8 points!\n Whoever has the most points at "
        + "the end wins.\nYou won't get to the end of your deck though, to make the games quicker!\n"
        + "Good luck players!");
    }

    public void playRound()
    {
        //if (one.getHand().size() > 0 && two.getHand().size() > 0)
        /*if (one.getCard() == null || two.getCard() == null)
        {

        }*/
        //I have the null if statements to ensure that we are not trying to play when all the cards are finished
        if ((one.getCard() != null || two.getCard() != null) && one.getCard().getPoint() > two.getCard().getPoint())
        {
            System.out.println(one.getName() + " got: " + one.getCard().getRank() + " of " + one.getCard().getSuit());
            System.out.println(two.getName() + " got: " + two.getCard().getRank() + " of " + two.getCard().getSuit());
            System.out.println(one.getName() + " gets two points!\n");
            one.addTwoPoints();

            one.removeCard();
            two.removeCard();
        }
        //this is just tallying the points--seing who has a higher card value
        else if ((one.getCard() != null || two.getCard() != null) && one.getCard().getPoint() < two.getCard().getPoint()) {
            System.out.println(one.getName() + " got: " + one.getCard().getRank() + " of " + one.getCard().getSuit());
            System.out.println(two.getName() + " got: " + two.getCard().getRank() + " of " + two.getCard().getSuit());
            System.out.println(two.getName() + " gets two points!\n");
            two.addTwoPoints();

            one.removeCard();
            two.removeCard();
        }
        //this is the "war" rule of war. However, I didn't want the game to end on war in case there weren't three cards
        //left, so if it is one of the last rounds or the last round we don't go into war
        else if((one.getCard() != null || two.getCard() != null) && one.getCard().getPoint() == two.getCard().getPoint() && roundsPlayed != random - 2) {
            System.out.println(one.getName() + " got: " + one.getCard().getRank() + " of " + one.getCard().getSuit());
            System.out.println(two.getName() + " got: " + two.getCard().getRank() + " of " + two.getCard().getSuit());
            while (one.getCard().getPoint() == two.getCard().getPoint() && one.getCard() != null && two.getCard() != null) {
                one.removeCard();
                two.removeCard();
                System.out.println("The values of these cards are equal.\nTHIS MEANS WAR!\nNow you'll play 3 more cards");

                //compares highest values of each three cards drawn and put down
                int max1 = 0;
                for (int i = 0; i < 3; i++) {
                    int cardVal = one.getCard().getPoint();
                    System.out.println(one.getName() + " got: " + one.getCard().getRank() + " of " + one.getCard().getSuit());
                    if (cardVal > max1) {
                        max1 = cardVal;
                    }
                    one.removeCard();
                    two.removeCard();
                }
                int max2 = 0;
                for (int i = 0; i < 3; i++) {
                    int cardVal = two.getCard().getPoint();
                    System.out.println(two.getName() + " got: " + two.getCard().getRank() + " of " + two.getCard().getSuit());
                    if (cardVal > max2) {
                        max2 = cardVal;
                    }
                    one.removeCard();
                    two.removeCard();
                }

                if (max1 > max2) {
                    System.out.println(one.getName() + " won the War!\n");
                    one.addTwoPoints();
                    one.addTwoPoints();
                    one.addTwoPoints();
                    one.addTwoPoints();
                }
                else if (max1 < max2) {
                    System.out.println(two.getName() + " won the War!\n");
                    two.addTwoPoints();
                    two.addTwoPoints();
                    two.addTwoPoints();
                    two.addTwoPoints();
                }
                else if (max1 == max2) {
                    System.out.println("You both goth the same max value card. Really?! No points for either of you.\n");
                }

            }
        }
        if (one.getCard() != null && two.getCard() != null) {
            System.out.println(one.toString());
            System.out.println(two.toString());
        }
        roundsPlayed++;
    }

    public void playMatch()
    {

        System.out.println(one.getHand().size() + "Now the cards will be shuffled and dealt.\n");
        this.giveCards();
        this.playRound();
        //while (one.getHand().size() > 0 || two.getHand().size() > 0)
        int i = 0;
        //random number between 10 and 14
        //int random = (int)((Math.random() * 5) + 10);
        //number of rounds we'll play
        while (i < random)
        {
            System.out.println("Press 'x' to move on");
            Scanner s = new Scanner(System.in);
            String moveOn = s.nextLine();

            if (moveOn.equals("x"))
            {
                this.playRound();
                i++;
            }
        }

        int oneTotal = one.getPoints();
        int twoTotal = two.getPoints();
        //print winner
        if (oneTotal > twoTotal)
        {
            System.out.println("\n" + one.getName() + " Wins the game! Congratulations!");
        }
        else if (oneTotal < twoTotal)
        {
            System.out.println("\n" + two.getName() + " Wins the game! Congratulations!");
        }
        if (oneTotal == twoTotal)
        {
            System.out.println("\nThe game has ended in a draw.");
        }
    }

    public static void main(String[] args)
    {
        printInstructions();
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name, player 1?");
        String name1 = input.nextLine();
        System.out.println("How about your name, player 2?");
        String name2 = input.nextLine();

        Game match = new Game(name1, name2);
        match.playMatch();
    }
}
