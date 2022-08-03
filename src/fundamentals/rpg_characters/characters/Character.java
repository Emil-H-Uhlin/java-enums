package fundamentals.rpg_characters.characters;

public abstract class Character {
    public final String name;
    public final HeroClass _class;

    private int level = 1;

    private int strength, dexterity, intelligence;

    public int getStrength() { return strength; }
    public int getDexterity() { return dexterity; }
    public int getIntelligence() { return intelligence; }

    public int getLevel() { return level; }

    public Character(String _name, HeroClass _heroClass) {
        name = _name;
        _class = _heroClass;

        strength = _class.lvl1Str;
        dexterity = _class.lvl1Dex;
        intelligence = _class.lvl1Int;
    }

    public void levelUp() {
        level++;

        strength += _class.strPerLevel;
        dexterity += _class.dexPerLevel;
        intelligence += _class.intPerLevel;
    }
}
