package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.ArmorType;
import fundamentals.rpg_characters.equipment.WeaponType;

/**
 * An enum representing the available hero classes
 * To add another selectable class, simply add another
 * entry to the enum with desired values.
 */
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

    /**
     * Private constructor for constructing
     * new enum entries (ei. selectable characters)
     *
     * @param _baseStr The starting strength of the class
     * @param _baseDex The starting dexterity of the class
     * @param _baseInt The starting intelligence of the class
     * @param _strPerLevel Amount of strength gained when leveling up
     * @param _dexPerLevel Amount of dexterity gained when leveling up
     * @param _intPerLevel Amount of intelligence gained when leveling up
     * @param _primaryAttribute The primary attribute (Strength, Dexterity or Intelligence)
     * @param _allowedWeapons An array of the allowed weapon types for the class
     * @param _allowedArmor An array of allowed armor types for the class
     */
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
