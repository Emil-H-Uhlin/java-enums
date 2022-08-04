package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.*;
import fundamentals.rpg_characters.exceptions.InvalidArmorException;
import fundamentals.rpg_characters.exceptions.InvalidWeaponException;

import java.util.Arrays;
import java.util.HashMap;

public class Character {
    public final String name;
    public final HeroClass _class;

    private int level = 1;

    private int strength, dexterity, intelligence;

    public int getBaseStrength() { return strength; }
    public int getBaseDexterity() { return dexterity; }
    public int getBaseIntelligence() { return intelligence; }

    public int getLevel() { return level; }

    public int getTotalStrength() {
        int additional = 0;

        for (var slot: equipment.keySet()) {
            if (equipment.get(slot) instanceof Armor armor) {
                additional += armor.getBonusStrength();
            }
        }

        return getBaseStrength() + additional;
    }

    public int getTotalDexterity() {
        int additional = 0;

        for (var slot: equipment.keySet()) {
            if (equipment.get(slot) instanceof Armor armor) {
                additional += armor.getBonusDexterity();
            }
        }

        return getBaseDexterity() + additional;
    }

    public int getTotalIntelligence() {
        int additional = 0;

        for (var slot: equipment.keySet()) {
            if (equipment.get(slot) instanceof Armor armor) {
                additional += armor.getBonusIntelligence();
            }
        }

        return getBaseIntelligence() + additional;
    }

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
            if (weapon.getRequiredLevel() > level) {
                throw new InvalidWeaponException("Character does not meet the level requirements of weapon!");
            }

            if (!Arrays.asList(_class.allowedWeapons).contains(weapon.weaponType)) {
                throw new InvalidWeaponException("Character is not allowed to use that weapon!");
            }
        } else if (_item instanceof Armor armor) {
            if (armor.getRequiredLevel() > level) {
                throw new InvalidArmorException("Character does not meet the level requirements of armor!");
            }

            if (!Arrays.asList(_class.allowedArmor).contains(armor.armorType)) {
                throw new InvalidArmorException("Character is not allowed to use that kind of armor!");
            }
        }

        equipment.put(_item.itemSlot, _item);
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                name: %s
                level: %s
                
                Base attriutes:
                Strength: %s
                Dexterity: %s
                Intelligence: %s
                
                Total attributes:
                Strength: %s
                Dexterity: %s
                Intelligence: %s
                """, _class.name(),
                name,
                getLevel(),
                getBaseStrength(),
                getBaseDexterity(),
                getBaseIntelligence(),
                getTotalStrength(),
                getTotalDexterity(),
                getTotalIntelligence());
    }
}
