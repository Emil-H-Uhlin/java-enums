package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.ArmorType;
import fundamentals.rpg_characters.equipment.WeaponType;

public enum HeroClass {
    Warrior(5, 2, 1,
            3, 2, 1,
            PrimaryAttributes.Strength,
            new WeaponType[] {
                    WeaponType.Axe, WeaponType.Hammer, WeaponType.Sword
            },
            new ArmorType[] {
                    ArmorType.Mail, ArmorType.Plate
            }),
    Rogue(2, 6, 1,
            1, 4, 1,
            PrimaryAttributes.Dexterity,
            new WeaponType[] {
                    WeaponType.Dagger, WeaponType.Sword
            },
            new ArmorType[] {
                    ArmorType.Leather, ArmorType.Mail
            }),
    Ranger(1, 7, 1,
            1, 5, 1,
            PrimaryAttributes.Dexterity,
            new WeaponType[] {
                    WeaponType.Bow
            },
            new ArmorType[] {
                    ArmorType.Leather, ArmorType.Mail
            }),
    Mage(1, 1, 8,
            1, 1, 5,
            PrimaryAttributes.Intelligence,
            new WeaponType[] {
                    WeaponType.Staff, WeaponType.Wand
            },
            new ArmorType[] {
                    ArmorType.Cloth
            });

    public final Attributes level1Attributes;
    public final Attributes gainedAttributesPerLevel;

    public final PrimaryAttributes primaryAttribute;

    public final WeaponType[] allowedWeapons;
    public final ArmorType[] allowedArmor;

    HeroClass(int _baseStr, int _baseDex, int _baseInt,
              int _strPerLevel, int _dexPerLevel, int _intPerLevel,
              PrimaryAttributes _primaryAttribute,
              WeaponType[] _allowedWeapons, ArmorType[] _allowedArmor) {

        level1Attributes = new Attributes(
                _baseStr,
                _baseDex,
                _baseInt
        );

        gainedAttributesPerLevel = new Attributes(
                _strPerLevel,
                _dexPerLevel,
                _intPerLevel
        );

        primaryAttribute = _primaryAttribute;

        allowedWeapons = _allowedWeapons;
        allowedArmor = _allowedArmor;
    }
}
