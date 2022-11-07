package legacy;

import model.Cards.Actors.Card;
import model.Cards.Element;

import java.util.ArrayList;

public class CardCollection {


    ArrayList<Card> cards;

    public CardCollection(ArrayList<Card> cards)
    {
        this.cards = cards;
    }

    public Card getCard(int index)
    {
        return cards.get(index);
    }

    public CardCollection getCardsByName(String name)
    {
        ArrayList<Card> outcards = new ArrayList<Card>();
        for (Card card: this.cards){
            if (card.getName().equals(name)){
                outcards.add(card);
            }
        }

        return new CardCollection(outcards);
    }

    public CardCollection getCardsByElement(Element element)
    {
        ArrayList<Card> outcards = new ArrayList<Card>();
        for (Card card: this.cards){
            if (card.getElement().equals(element)){
                outcards.add(card);
            }
        }

        return new CardCollection(outcards);
    }

    public CardCollection getCardsByMonsterType()
    {
        //TODO
        return this;
    }







    }
