package fundamentals.rpg_characters.characters;

public class Attributes {
    private int strength;
    private int dexterity;
    private int intelligence;

    public int getStrength() { return strength; }

    public int getDexterity() { return dexterity; }

    public int getIntelligence() { return intelligence; }

    public Attributes(int _str, int _dex, int _int) {
        strength = _str;
        dexterity = _dex;
        intelligence = _int;
    }

    public Attributes add(Attributes _other) {
        return new Attributes(
                strength + _other.strength,
                dexterity + _other.dexterity,
                intelligence + _other.intelligence
        );
    }

    @Override
    public String toString() {
        return String.format("""
                Strength: %s
                Dexterity: %s
                Intelligence: %s""",
                strength, dexterity, intelligence);
    }
}
