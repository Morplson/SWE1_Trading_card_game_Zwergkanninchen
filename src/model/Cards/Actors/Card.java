package model.Cards.Actors;

import model.Cards.Element;
import model.Cards.Monster;
import model.Cards.Rules;

import java.util.Random;

public class Card extends Actor {

    private float virtualHealth = 0;
    private boolean virtualCritical = false;

    public Card(String name, int damage, int health, Element element, Monster monster){
        super(name, damage, health, element, monster);
    }
    public Card(String name, int damage, int health, Element element, Monster monster, double criticalChance){
        super(name, damage, health, element, monster, criticalChance);
    }


    @Override
    public String attackString(Actor opponent) {
        StringBuilder sb = new StringBuilder();
        Actor oc = (Actor) opponent;

        if(virtualCritical) {
            sb.append("Critical hit on ");
        } else {
            sb.append("Attack on ");
        }

        sb.append( oc.getName() );

        short rulecode = new Rules(this, oc).checkRules();

        sb.append( " resulted in " );
        switch (rulecode) {
            case -2:
                sb.append( "total failure!" );
                break;
            case -1:
                sb.append( "INSANE DAMAGE!" );
                break;
            case 1:
                sb.append( "a slight advantage." );
                break;
            case 2:
                sb.append( "a slight disadvantage." );
            default:
                sb.append( "smooth moves :)" );
        }


        return sb.toString();
    }

    @Override
    public float calculateDamage(Actor opponent) {
        float outDamage = this.getDamage();
        Random rand = new Random();

        if(virtualCritical) {
            // Critical hit!
            outDamage *= 2;
        }

        short rulecode = new Rules(this, opponent).checkRules();

        switch (rulecode) {
            case -2:
                outDamage = 0;
                break;
            case -1:
                outDamage = Float.POSITIVE_INFINITY;
                break;
            case 1:
                outDamage *= 1.25;
                break;
            case 2:
                outDamage /= 1.25;
                break;
        }

        return outDamage;
    }

    @Override
    public void resetVirtualHealth() {
        this.setVirtualHealth(this.getHealth());
    }

    @Override
    public float calculateVirtualHealth(float damage) {

        float cVH = this.getVirtualHealth();
        cVH = cVH -= damage;

        return cVH;
    }

    @Override
    public void updateValues() {
        if(new Random().nextDouble(0,1) < this.getCriticalChance()) {
           this.virtualCritical = true;
        } else {
            this.virtualCritical = false;
        }

    }

    @Override
    public boolean isDead() {
        if (this.getVirtualHealth() <= 0 ){
            return true;
        }
        return false;
    }

    @Override
    public void setVirtualHealth(float health) {
        this.virtualHealth = health;
    }

    @Override
    public float getVirtualHealth() {
        return this.virtualHealth;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This is a ");

        if (this.getMonster() == Monster.SPELL){
            sb.append("Spell Card ");
        }else{
            sb.append("Monster Card ");
        }

        sb.append("with the type ");
        sb.append(this.getElement().toString());

        sb.append(" and the damage ");
        sb.append(this.getDamage());

        return sb.toString();
    }












}
