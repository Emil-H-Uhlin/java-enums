package fundamentals.rpg_characters.equipment;

public abstract class Equipment {
    public final String name;
    public final EquipmentSlot itemSlot;

    public Equipment(String _name, EquipmentSlot _slot) {
        name = _name;
        itemSlot = _slot;
    }
}
