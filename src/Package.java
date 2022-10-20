import Cards.Actors.Card;
import Cards.CardFactory;
import User;

import java.util.ArrayList;

public class Package {
    int price = 5;

    ArrayList<Card> cards = new ArrayList<Card>(5);


    public Package(User user) {
        // TODO check for requirements
        int price = this.getPrice();

        if (user.coins >= price){
            user.coins -= price;
        }else{
            throw new IllegalArgumentException("Invalid cash: " + user.coins);
        }
    }

    public Package() {
        CardFactory cf = new CardFactory();
        this.price = 5;

        for (int i = 0; i < cards.size(); i++) {
            cards.add(cf.randomCard()); // TODO Card Factory
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }






}
