package fundamentals.rpg_characters.characters;

public enum HeroClass {
    Warrior(5, 2, 1,
            3, 2, 1),
    Rogue(2, 6, 1,
            1, 4, 1),
    Ranger(1, 7, 1,
            1, 5, 1),
    Mage(1, 1, 8,
            1, 1, 5);

    public final int lvl1Str, lvl1Dex, lvl1Int;
    public final int strPerLevel, dexPerLevel, intPerLevel;

    HeroClass(int _baseStr, int _baseDex, int _baseInt,
              int _strPerLevel, int _dexPerLevel, int _intPerLevel) {
        lvl1Str = _baseStr;
        lvl1Dex = _baseDex;
        lvl1Int = _baseInt;

        strPerLevel = _strPerLevel;
        dexPerLevel = _dexPerLevel;
        intPerLevel = _intPerLevel;
    }
}
