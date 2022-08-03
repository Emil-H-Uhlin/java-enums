package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.ArmorType;
import fundamentals.rpg_characters.equipment.WeaponType;

public enum HeroClass {
    Warrior(5, 2, 1,
            3, 2, 1,
            Attributes.Strength,
            new WeaponType[] {
                    WeaponType.Axe, WeaponType.Hammer, WeaponType.Sword
            },
            new ArmorType[] {
                    ArmorType.Mail, ArmorType.Plate
            }),
    Rogue(2, 6, 1,
            1, 4, 1,
            Attributes.Dexterity,
            new WeaponType[] {
                    WeaponType.Dagger, WeaponType.Sword
            },
            new ArmorType[] {
                    ArmorType.Leather, ArmorType.Mail
            }),
    Ranger(1, 7, 1,
            1, 5, 1,
            Attributes.Dexterity,
            new WeaponType[] {
                    WeaponType.Bow
            },
            new ArmorType[] {
                    ArmorType.Leather, ArmorType.Mail
            }),
    Mage(1, 1, 8,
            1, 1, 5,
            Attributes.Intelligence,
            new WeaponType[] {
                    WeaponType.Staff, WeaponType.Wand
            },
            new ArmorType[] {
                    ArmorType.Cloth
            });

    public final int lvl1Str, lvl1Dex, lvl1Int;
    public final int strPerLevel, dexPerLevel, intPerLevel;
    public final Attributes primaryAttribute;

    public final WeaponType[] allowedWeapons;
    public final ArmorType[] allowedArmor;

    HeroClass(int _baseStr, int _baseDex, int _baseInt,
              int _strPerLevel, int _dexPerLevel, int _intPerLevel,
              Attributes _primaryAttribute,
              WeaponType[] _allowedWeapons, ArmorType[] _allowedArmor) {

        lvl1Str = _baseStr;
        lvl1Dex = _baseDex;
        lvl1Int = _baseInt;

        strPerLevel = _strPerLevel;
        dexPerLevel = _dexPerLevel;
        intPerLevel = _intPerLevel;

        primaryAttribute = _primaryAttribute;

        allowedWeapons = _allowedWeapons;
        allowedArmor = _allowedArmor;
    }
}
