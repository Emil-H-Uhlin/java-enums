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

    private Attributes attributes;

    public int getLevel() { return level; }

    public Attributes getBaseAttributes() {
        return attributes;
    }

    public Attributes getTotalAttributes() {
        Attributes baseAttributes = attributes;

        for (var slot: equipment.keySet()) {
            System.out.println(slot);
            if (equipment.get(slot) instanceof Armor armor) {
                baseAttributes = baseAttributes.add(armor.getBonusAttributes());
            }
        }

        return baseAttributes;
    }

    private final HashMap<EquipmentSlot, Equipment> equipment = new HashMap<>();

    public Character(String _name, HeroClass _heroClass) {
        name = _name;
        _class = _heroClass;

        attributes = _class.level1Attributes;
    }

    public void levelUp() {
        level++;

        attributes = attributes.add(_class.gainedAttributesPerLevel);
    }

    public void equip(Equipment _item) {
        if (_item instanceof Weapon weapon) {
            if (weapon.getRequiredLevel() > level) {
                throw new InvalidWeaponException(String.format("Character '%s' does not meet the level requirements of weapon!", name));
            }

            if (!Arrays.asList(_class.allowedWeapons).contains(weapon.weaponType)) {
                throw new InvalidWeaponException(String.format("The class '%s' is not allowed to use '%ss'!", _class.name(), weapon.weaponType.name()));
            }
        } else if (_item instanceof Armor armor) {
            if (armor.getRequiredLevel() > level) {
                throw new InvalidArmorException(String.format("Character '%s' does not meet the level requirements of armor!", name));
            }

            if (!Arrays.asList(_class.allowedArmor).contains(armor.armorType)) {
                throw new InvalidArmorException(String.format("Character '%s' is not allowed to use armor of type '%s'", name, armor.armorType.name()));
            }
        }

        equipment.put(_item.itemSlot, _item);
    }

    @Override
    public String toString() {
        var totalAttr = getTotalAttributes();

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
                attributes.getStrength(),
                attributes.getDexterity(),
                attributes.getIntelligence(),
                totalAttr.getStrength(),
                totalAttr.getDexterity(),
                totalAttr.getIntelligence());
    }
}
