import Cards.*;
import Cards.Actors.Actor;
import Cards.Actors.Card;
import Cards.Actors.Effects.Burning;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.Collections;

public class Battle {
    User p1;
    User p2;

    ArrayList<Actor> vdP1;
    ArrayList<Actor> vdP2;

    int pointsP1 = 0;
    int pointsP2 = 0;

    //chances
    float burnchance = 0.2f;


    public Battle(User player1, ArrayList<Card> p1Deck, User player2, ArrayList<Card> p2Deck) {
        this.p1 = player1;
        this.p2 = player2;
        
        this.vdP1 = new ArrayList<Actor>(p1Deck);
        this.vdP2 = new ArrayList<Actor>(p2Deck);
        
        this.setupBattle();
        
    }
    
    public void setupBattle() {
        for (int i = 0; i < this.vdP1.size(); i++) {
            this.vdP1.get(i).resetVirtualHealth();
        }
        for (int i = 0; i < this.vdP1.size(); i++) {
            this.vdP1.get(i).resetVirtualHealth();
        }
    }

    public void play() {
        boolean win = false;



        do{

            attackRound();




        } while (vdP1.size() > 0 || vdP2.size() > 0);

    }
    

    public void attackRound() {
        Collections.shuffle(this.vdP1);
        Collections.shuffle(this.vdP2);
        Actor stagedCard1 = this.vdP1.remove(0);
        Actor stagedCard2 = this.vdP2.remove(0);

        //attack a1 -> a2
        float d1 = stagedCard1.calculateDamage(stagedCard2);

        //attack a2 -> a1
        float d2 = stagedCard2.calculateDamage(stagedCard1);

        // TODO apply effects
        /*
        if (Rules(stagedCard1, stagedCard2).burningRule()){
            stagedCard2 = new Burning(stagedCard2, 2);
        }
        if (Rules(stagedCard1, stagedCard2).burningRule()){
            stagedCard1 = new Burning(stagedCard1, 2);
        }
        */


        stagedCard1.calculateVirtualHealth(d2);
        stagedCard2.calculateVirtualHealth(d1);

        if (!stagedCard1.isDead()){
            this.vdP1.add(stagedCard1);
            this.pointsP1 += 10;
        }
        if (!stagedCard2.isDead()){
            this.vdP2.add(stagedCard2);
            this.pointsP2 += 10;
        }

        //TODO: Wincondition


    }
}
