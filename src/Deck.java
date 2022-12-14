import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private int cardsLeft;
    private ArrayList<Card> pack;

    //makes a deck of cards, initializing each card with ArrayLists for each component of the card
    public Deck(ArrayList<String> rk, ArrayList<String> st, ArrayList<Integer> pt)
    {
        pack = new ArrayList<>();

        for (int i = 0; i < 13; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Card x = new Card(rk.get(i), st.get(j), pt.get(i));
                pack.add(x);
            }
        }
        shuffle();
        //System.out.println("\n|||\n" + rk);
        //System.out.println(st);
        //System.out.println(pt + "\n");
        cardsLeft = pack.size();
    }

    /*public Deck()
    {
        pack = new ArrayList<>();

        for (int i = 2; i < 11; i++)
        {
            //convert i to a string
            String cardRank = "" + i;
            Card w = new Card(cardRank, "Clubs", i);
            pack.add(w);
            Card x = new Card(cardRank, "Spades", i);
            pack.add(x);
            Card y = new Card(cardRank, "Hearts", i);
            pack.add(y);
            Card z = new Card(cardRank, "Diamonds", i);
            pack.add(z);
        }
        String ace = "Ace";
        String king = "King";
        String queen = "Queen";
        String jack = "Jack";

        String x = "";

        for (int i = 0; i < 4; i++)
        {
            if (i == 0)
            {
                x = "Clubs";
            }
            if (i == 1)
            {
                x = "Spades";
            }
            if (i == 2)
            {
                x = "Hearts";
            }
            if (i == 3)
            {
                x = "Diamonds";
            }

            Card aces = new Card(ace, x, 14);
            pack.add(aces);
            Card kings = new Card(king, x, 13);
            pack.add(kings);
            Card queens = new Card(queen, x, 12);
            pack.add(queens);
            Card jacks = new Card(jack, x, 11);
            pack.add(jacks);

            cardsLeft = pack.size();
        }

    }*/

    public boolean isEmpty()
    {
        return cardsLeft == 0;
    }

    public int getCardsLeft()
    {
        return cardsLeft;
    }

    public void shuffle()
    {
        //picks a random card do to a card wap, to shuffle
        int j = 0;
        for (int i = 0; i < pack.size(); i++)
        {
            j = (int)(Math.random() * (pack.size() - 1));
            Collections.swap(pack, i, j);
        }
        //cardsLeft = pack.size();
    }

    public Card deal()
    {
        if (cardsLeft <= 0)
        {
            return null;
        }
        --cardsLeft;
        return pack.get(cardsLeft);
    }

}