package fundamentals.rpg_characters.characters;

public abstract class Character {
    private final String name;
    private int level = 1;

    private int strength, dexterity, intelligence;
    private int strPerLevel, dexPerLevel, intPerLevel;

    public int getLevel() { return level; }

    public Character(String _name,
                     int _strength, int _dexterity, int _intelligence,
                     int _strPerLevel, int _dexPerLevel, int _intPerLevel) {
        name = _name;

        strength = _strength;
        dexterity = _dexterity;
        intelligence = _intelligence;

        strPerLevel = _strPerLevel;
        dexPerLevel = _dexPerLevel;
        intPerLevel = _intPerLevel;
    }
}
