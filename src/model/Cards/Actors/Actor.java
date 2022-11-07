package model.Cards.Actors;

import model.Cards.Element;
import model.Cards.Monster;

import java.util.UUID;

/**
 * Alles was Karten sind Aktöre :)
 * @author Bingus
 * @version 0.0
 */
public abstract class Actor {
    public abstract String attackString(Actor opponent);
    public abstract float calculateDamage(Actor opponent);
    public abstract void resetVirtualHealth();
    public abstract float calculateVirtualHealth(float damage);
    public abstract void updateValues();

    public abstract boolean isDead();

    public abstract void setVirtualHealth(float health);
    public abstract float getVirtualHealth();

    public abstract String toString();
    private UUID id = UUID.randomUUID();
    private String name; //{ get; set; }

    private float damage = 0;
    private float health = 0;



    private Element element;
    private Monster monster;
    private double criticalChance;

    public Actor(){
        //TODO: don't do this!
    }


    public Actor(String name, int damage, int health, Element element, Monster monster){
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.element = element;
        this.monster = monster;
    }
    public Actor(String name, int damage, int health, Element element, Monster monster, double criticalChance){
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.element = element;
        this.monster = monster;
        this.criticalChance = criticalChance;
    }


    public boolean isSpell() {
        if (monster == Monster.SPELL){
            return true;
        }
        return false;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDamage() {
        return damage;
    }

    public float getHealth() {
        return health;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }
}
