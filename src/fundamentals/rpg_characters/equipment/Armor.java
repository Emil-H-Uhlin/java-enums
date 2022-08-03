package fundamentals.rpg_characters.equipment;

import java.util.Arrays;

public class Armor extends Equipment {
    private static final EquipmentSlot[] allowedEquipmentSlots = {
            EquipmentSlot.Head,
            EquipmentSlot.Torso,
            EquipmentSlot.Legs,
    };

    public final ArmorType armorType;

    public Armor(String _name, EquipmentSlot _slot, ArmorType _armorType) {
        super(_name, _slot);

        if (_slot == EquipmentSlot.Weapon) {
            // throw exception
        }

        armorType = _armorType;
    }

}
