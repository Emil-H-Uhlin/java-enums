package fundamentals.rpg_characters.equipment;

public abstract class Equipment {
    public final String name;
    public final EquipmentSlot itemSlot;

    private int requiredLevel;

    public int getRequiredLevel() { return requiredLevel; }
    public void setRequiredLevel(int _value) { requiredLevel = _value; }

    public Equipment(String _name, EquipmentSlot _slot, int _requiredLevel) {
        name = _name;
        itemSlot = _slot;

        requiredLevel = _requiredLevel;
    }
}
