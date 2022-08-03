package fundamentals.rpg_characters.equipment;

public class Armor extends Equipment {
    public final ArmorType armorType;

    public Armor(String _name, EquipmentSlot _slot, ArmorType _armorType) {
        super(_name, _slot);

        armorType = _armorType;
    }

}
