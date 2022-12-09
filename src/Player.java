import java.util.ArrayList;

public class Player
{
    private String name;
    private ArrayList<Card> hand;
    private int points;

    public Player(String nm)
    {
        name = nm;
        hand = new ArrayList<Card>();
        points = 0;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public int getPoints()
    {
        return points;
    }

    public void addTwoPoints()
    {
        points++;
        points++;
    }

    public void addCards(Card x)
    {
        hand.add(x);
    }

    public Card getCard()
    {
        if (hand.isEmpty())
        {
            return null;
        }
        return hand.get(hand.size() - 1);
    }

    //removes card so the top of a persons hand is always a new card
    public void removeCard()
    {
        if (hand.size() > 0)
        {
            hand.remove(hand.size() - 1);
        }
    }

    public String toString()
    {
        //not showing the cards because players aren't supposed to look at hand
        return name + " has " + points + " points\n"/* + name + "'s cards: " + hand*/;
    }
}
