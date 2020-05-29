public class Card{
    private int suit;
    public int rank;
    public int value;

    public Card(){
        suit=0;
        rank=0;
        value=0;
    }

    public Card(int s, int r, int v){
        suit=s;
        rank=r;
        value=v;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

}