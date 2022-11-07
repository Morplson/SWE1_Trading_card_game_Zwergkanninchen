package legacy;

import model.Cards.Actors.Card;

import java.util.ArrayList;

/**
 * Hier sind die karten des spielers, die er spielen will
 *
 * Ich stelle mir vor diese Klasse speichert nur die id der Karten im legacy.Stack und
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>(5);

    /**
     * empty deck
     */
    public Deck() {
    }

    /**
     * pack with cards as list
     * @param deck
     */
    public Deck(ArrayList<Card> cards) {
        this.deck = new ArrayList<Card>(cards);
    }

    /**
     * pack with individual cards
     * @param card1
     * @param card2
     * @param card3
     * @param card4
     * @param card5
     */
    public Deck(Card card1, Card card2, Card card3, Card card4, Card card5) {
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
    }

    /**
     * Pa
     * @return
     */
    public ArrayList<Card> getCards(){
        return new ArrayList<Card>(this.deck);
    }



}
