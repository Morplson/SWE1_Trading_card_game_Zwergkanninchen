import Cards.Actors.Card;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Alles Über den User.User ;)
 * @author Bingus
 * @version 0.0
 */
public class User {


    String username;
    String password;
    String email;

    UUID id = UUID.randomUUID();


    int coins;

    ArrayList<Card> stack = new ArrayList<Card>();
    ArrayList<ArrayList<Card>> decks = new ArrayList<ArrayList<Card>>();



    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.coins = 20;
    }
    
    public String getToken() {
        return funnytoken;
    }

    public void buyPackage(){
        Package p = Package.generate(this);


    }



}
