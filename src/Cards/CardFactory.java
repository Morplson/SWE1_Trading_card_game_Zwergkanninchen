package Cards;

import Cards.Actors.Card;

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
        int health = this.random.nextInt(3,12);

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


        return null;
    }

    public Card randomCard() {
        if(this.random.nextDouble(0,1) > this.spellChance){
            return this.randomMonster();
        }

        return this.randomSpell();
    }
}
