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
