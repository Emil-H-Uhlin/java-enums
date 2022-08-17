package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.*;
import fundamentals.rpg_characters.exceptions.InvalidArmorException;
import fundamentals.rpg_characters.exceptions.InvalidWeaponException;

import java.util.Arrays;
import java.util.HashMap;

public class Character {
    public final String name;
    public final HeroClass heroClass;   // base model of character

    private int level = 1;              // character starts at level 1

    private Attributes attributes;      // base attributes of character

    private final HashMap<EquipmentSlot, IEquipable> equipment = new HashMap<>();

    public int getLevel() { return level; }

    public Attributes getBaseAttributes() {
        return attributes;
    }

    /**
     * @return The total attributes of the character (base + equipment bonuses)
     */
    public Attributes getTotalAttributes() {
        Attributes baseAttributes = attributes;

        for (var slot: equipment.keySet()) {
            if (equipment.get(slot) instanceof Armor armor) {
                baseAttributes = baseAttributes.add(armor.getBonusAttributes());
            }
        }

        return baseAttributes;
    }

    public HashMap<EquipmentSlot, IEquipable> getEquipment() {
        return equipment;
    }

    public Character(String _name, HeroClass _heroClass) {
        name = _name;
        heroClass = _heroClass;

        attributes = heroClass.level1Attributes;
    }

    /**
     * Increment level and add attributes based on character class
     */
    public void levelUp() {
        level++;

        attributes = attributes.add(heroClass.gainedAttributesPerLevel);
    }

    /**
     * Equip a weapon or throw if invalid or not allowed
     * @param weapon The weapon to equip
     */
    public void equip(Weapon weapon) {
        /* Does character meet level requirements? */
        if (weapon.getRequiredLevel() > level) {
            throw new InvalidWeaponException(String.format("Character '%s' does not meet the level requirements of weapon!", name));
        }
    
        /* Is weapon allowed? */
        if (!Arrays.asList(heroClass.allowedWeapons).contains(weapon.weaponType)) {
            throw new InvalidWeaponException(String.format("The class '%s' is not allowed to use '%ss'!", heroClass.name(), weapon.weaponType.name()));
        }
        
        equipment.put(weapon.getItemSlot(), weapon);
    }
    
    /**
     * Equip a piece of armor or throw if invalid or not allowed
     * @param armor The armor to equip
     */
    public void equip(Armor armor) {
        /* Does character meet level requirements? */
        if (armor.getRequiredLevel() > level) {
            throw new InvalidArmorException(String.format("Character '%s' does not meet the level requirements of armor!", name));
        }
    
        /* Is weapon allowed? */
        if (!Arrays.asList(heroClass.allowedArmor).contains(armor.armorType)) {
            throw new InvalidArmorException(String.format("Character '%s' is not allowed to use armor of type '%s'", name, armor.armorType.name()));
        }
        
        equipment.put(armor.getItemSlot(), armor);
    }

    /**
     * @return The total of the characters 'primary' attribute
     */
    private int getTotalPrimaryAttribute() {
        var total = getTotalAttributes();

        switch (heroClass.primaryAttribute) {
            case Strength -> {
                return total.getStrength();
            }
            case Dexterity -> {
                return total.getDexterity();
            }
            case Intelligence -> {
                return total.getIntelligence();
            }
            default -> throw new RuntimeException("Character: getTotalPrimaryAttribute: Unknown attribute - not implemented?");
        }
    }

    /**
     * Calculates the characters damage per second (DPS) based
     * on total attributes and equipped weapon.
     *
     * @return The character DPS
     */
    public float getDPS() {
        var item = equipment.get(EquipmentSlot.Weapon);

        var primaryAttribute = getTotalPrimaryAttribute();

        /* No weapon equipped */
        if (item == null) {
            return 1f + (primaryAttribute / 100f);
        }

        /* Check calculate dps based on equipped weapon (or throw exception if equipped 'weapon' is not a weapon) */
        if (item instanceof Weapon weapon) {
            return weapon.getDPS() * (1 + (primaryAttribute / 100f));
        }
        else throw new InvalidWeaponException("Item equipped in 'Weapon' slot is not a weapon!");
    }

    /**
     * @return A text representation of the character including
     * class, name, level, dps, attributes and equipment
     */
    public String display() {
        var builder = new StringBuilder();

        builder.append(String.format("""
                        
                        Character class: %s
                        Name: %s
                        Level: %s
                        
                        DPS: %s
                        
                        Total attributes: 
                        %s
                        
                        """,
                heroClass.name(),
                name,
                level,
                getDPS(),
                getTotalAttributes()));

        /* Return as is if there is no equipment present */
        if (equipment.values().size() < 1)
            return builder.toString();

        for (var slot: equipment.keySet()) {
            var item = equipment.get(slot);

            if (item instanceof Weapon weapon) {
                builder.append(String.format("""
                                Weapon: {
                                Item name: %s
                                Item slot: Weapon
                                                    
                                Weapon damage: %s
                                Weapon attack speed: %s
                                Weapon DPS: %s
                                }
                                                    
                                """,
                        weapon.getItemName(),
                        weapon.getDamage(),
                        weapon.getAttacksPerSecond(),
                        weapon.getDPS()));
            } else if (item instanceof Armor armor) {
                builder.append(String.format("""
                                Armor: {
                                Item name: %s
                                Item slot: %s
                                                    
                                Bonus attributes: 
                                %s
                                }
                                                    
                                """,
                        armor.getItemName(),
                        armor.getItemSlot(),
                        armor.getBonusAttributes()));
            }
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", _class=" + heroClass.name() +
                ", level=" + level +
                '}';
    }
}
