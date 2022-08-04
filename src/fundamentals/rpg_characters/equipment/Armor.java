package fundamentals.rpg_characters.equipment;

import fundamentals.rpg_characters.characters.Attributes;
import fundamentals.rpg_characters.exceptions.InvalidArmorException;

import java.util.Arrays;

public class Armor extends Equipment {
    public final ArmorType armorType;

    private Attributes bonusAttributes;

    public Attributes getBonusAttributes() { return bonusAttributes; }

    public Armor(String _name, EquipmentSlot _slot, int _requiredLevel, ArmorType _armorType,
                 int _bonusStr, int _bonusDex, int _bonusInt) throws InvalidArmorException {
        super(_name, _slot, _requiredLevel);

        if (_slot == EquipmentSlot.Weapon) {
            throw new InvalidArmorException("An armor may not be assigned to slot 'Weapon'!");
        }

        armorType = _armorType;

        bonusAttributes = new Attributes(
                _bonusStr,
                _bonusDex,
                _bonusInt
        );
    }
}
