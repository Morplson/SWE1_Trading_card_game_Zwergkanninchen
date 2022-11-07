package model.Cards;

import model.Cards.Actors.Card;

import java.util.Random;

public class CardFactory {

    private Random random = new Random();

    private float spellChance = 0.3f;

    public Card getCard(String name, String type, String element, int damage, int health) {
        Monster m = null;
        Element e = null;

        switch (type.toLowerCase()) {
            case "spell":
                m = Monster.SPELL;
                break;
            case "goblin":
                m = Monster.GOBLIN;
                break;
            case "dragon":
                m = Monster.DRAGON;
                break;
            case "wizard":
                m = Monster.WIZARD;
                break;
            case "ork":
                m = Monster.ORK;
                break;
            case "knight":
                m = Monster.KNIGHT;
                break;
            case "kraken":
                m = Monster.KRAKEN;
                break;
            case "elve":
                m = Monster.ELVE;
                break;
            case "troll":
                m = Monster.TROLL;
                break;
            default:
                throw new IllegalArgumentException("Unknown type of Monster" + type);
        }

        switch (element.toLowerCase()) {
            case "normal":
                e = Element.NORMAL;
                break;
            case "water":
                e = Element.WATER;
                break;
            case "fire":
                e = Element.FIRE;
                break;
            default:
                throw new IllegalArgumentException("Unknown type of Element" + element);
        }

        return new Card(name, damage, health, e, m);
    }

    public Card randomSpell() {
        StringBuilder name = new StringBuilder();

        int damage = this.random.nextInt(2,6);
        int health = this.random.nextInt(1,12);

        if(damage > health && damage > 5) {
            name.append("glass cannon ");
        }

        name.append("Spell of ");

        Element e = null;
        switch (this.random.nextInt(1,5)) {
            case 1:
                e = Element.WATER;
                name.append("refreshment");
                break;
            case 2:
                e = Element.FIRE;
                name.append("burning");
                break;
            default:
                e = Element.NORMAL;
                name.append("hurting");
        }

        return new Card(name.toString(), damage, health, e, Monster.SPELL);
    }

    public Card randomMonster() {
        StringBuilder name = new StringBuilder();

        int damage = this.random.nextInt(4,10);
        int health = this.random.nextInt(6,26);

        if (damage < 9 && health < 20) {
            name.append("Worthy ");
        }

        Element e = null;
        switch (this.random.nextInt(1,5)) {
            case 1:
                e = Element.WATER;
                name.append("Water");
                break;
            case 2:
                e = Element.FIRE;
                name.append("Fire");
                break;
            default:
                e = Element.NORMAL;
        }


        Monster m = null;
        switch (new Random().nextInt(1,12)) {
            case 1: case 8:
                m = Monster.DRAGON;
                name.append("Dragon");
                break;
            case 2:
                m = Monster.WIZARD;
                name.append("Wizard");
                break;
            case 3:
                m = Monster.ORK;
                name.append("Ork");
                break;
            case 4: case 10:
                m = Monster.KNIGHT;
                name.append("Knight");
                break;
            case 5:
                m = Monster.KRAKEN;
                name.append("Kraken");
                break;
            case 6:
                m = Monster.ELVE;
                name.append("Elve");
                break;
            case 7: case 9:
                m = Monster.GOBLIN;
                name.append("Goblin");
                break;
            default:
                m = Monster.TROLL;
                name.append("Troll");
                break;
        }

        return new Card(name.toString(), damage, health, e, m);
    }

    public Card randomCard() {
        if(this.random.nextDouble(0,1) > this.spellChance){
            return this.randomMonster();
        }

        return this.randomSpell();
    }
}
