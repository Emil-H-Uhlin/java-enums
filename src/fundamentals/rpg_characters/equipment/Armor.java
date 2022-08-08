package fundamentals.rpg_characters.equipment;

import fundamentals.rpg_characters.characters.Attributes;
import fundamentals.rpg_characters.exceptions.InvalidArmorException;

public class Armor implements IEquipable {
    public final ArmorType armorType;

    private final String name;
    private final EquipmentSlot equipmentSlot;

    private final int levelRequired;

    private final Attributes bonusAttributes;

    public Attributes getBonusAttributes() { return bonusAttributes; }

    /**
     * Constructs a new piece of Armor
     * @param _name Name of armor
     * @param _slot Equipment slot (Head, Torso or Legs)
     * @param _requiredLevel Level required to equip item
     * @param _armorType Which type of armor it is
     * @param _bonusStr Strength gained when equipped
     * @param _bonusDex Dexterity gained when equipped
     * @param _bonusInt Intelligence gained when equipped
     * @throws InvalidArmorException The equipment slot is not allowed to be .Weapon
     */
    public Armor(String _name, EquipmentSlot _slot, int _requiredLevel, ArmorType _armorType,
                 int _bonusStr, int _bonusDex, int _bonusInt) throws InvalidArmorException {
        if (_slot == EquipmentSlot.Weapon) {
            throw new InvalidArmorException("An armor may not be assigned to slot 'Weapon'!");
        }

        name = _name;
        equipmentSlot = _slot;

        levelRequired = _requiredLevel;

        armorType = _armorType;

        bonusAttributes = new Attributes(
                _bonusStr,
                _bonusDex,
                _bonusInt
        );
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public EquipmentSlot getItemSlot() {
        return equipmentSlot;
    }

    @Override
    public int getRequiredLevel() {
        return levelRequired;
    }
}
