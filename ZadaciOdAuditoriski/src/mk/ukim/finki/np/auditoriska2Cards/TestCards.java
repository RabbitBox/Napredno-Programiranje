package mk.ukim.finki.np.auditoriska2Cards;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class PlayingCard{

   public enum TYPE {
        HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS
    }


    private TYPE type;
    private int rank;

    public PlayingCard(TYPE type, int rank) {
        this.type = type;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("%d %s", rank, type.toString());
    }
}

class Deck{

    private PlayingCard [] cards;
    private int total;
    private boolean [] picked;

    public Deck(){
        cards = new PlayingCard[52];
        picked = new boolean[52];
        total = 0;

        for(int i = 0; i < PlayingCard.TYPE.values().length; ++i){
            for(int j = 0; j < 13; ++j){
                cards[j + (13 * i)] = new PlayingCard(PlayingCard.TYPE.values()[i],  j+1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(PlayingCard card : cards){
            sb.append(card);
            sb.append("\n");
        }
        return sb.toString();
    }

    public PlayingCard dealingCard(){
        if (total == 52)
            return null;
        int card = (int) (52 * Math.random());
        if(!picked[card]){
            picked[card] = true;
            ++total;
            return cards[card];
        }
        return dealingCard();
    }
}

class MultipleDecks {
    private Deck [] decks;

    public MultipleDecks(int n){
        decks = new Deck[n];
        for(int i = 0; i < n; i++){
            decks[i] = new Deck();
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(decks).map(i -> i.toString()).collect(Collectors.joining("\n"));
    }
}


public class TestCards {

    public static void main(String[] args) {
        Deck deck = new Deck();
        PlayingCard card;
        int i = 0;
        while ((card = deck.dealingCard()) != null){
            System.out.println(card +" "+ ++i);
        }
    }

}
