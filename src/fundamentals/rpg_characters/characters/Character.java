package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.*;

import java.util.Arrays;
import java.util.HashMap;

public abstract class Character {
    public final String name;
    public final HeroClass _class;

    private int level = 1;

    private int strength, dexterity, intelligence;

    public int getStrength() { return strength; }
    public int getDexterity() { return dexterity; }
    public int getIntelligence() { return intelligence; }

    public int getLevel() { return level; }

    private final HashMap<EquipmentSlot, Equipment> equipment = new HashMap<>();

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

    public void equip(Equipment _item) {
        if (_item instanceof Weapon weapon) {
            if (!Arrays.asList(_class.allowedWeapons).contains(weapon.weaponType)) {
                // throw exception
            }
        } else if (_item instanceof Armor armor) {
            if (!Arrays.asList(_class.allowedArmor).contains(armor.armorType)) {
                // throw exception
            }
        }

        equipment.put(_item.itemSlot, _item);
    }
}
