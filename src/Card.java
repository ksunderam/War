public class Card
{
    private String rank;
    private String suit;
    private int point;

    public Card(String rk, String type, int val)
    {
        rank = rk;
        suit = type;
        point = val;
    }

    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public String getSuit()
    {
        return suit;
    }

    public void setSuit(String suit)
    {
        this.suit = suit;
    }

    public int getPoint()
    {
        return point;
    }

    public void setPoint(int point)
    {
        this.point = point;
    }

}
