package fundamentals.rpg_characters.equipment;

public abstract class Equipment {
    public final String name;
    public final EquipmentSlot itemSlot;

    public final int requiredLevel;

    private int bonusStrength;
    private int bonusDexterity;
    private int bonusIntelligence;

    public Equipment(String _name, EquipmentSlot _slot, int _requiredLevel) {
        name = _name;
        itemSlot = _slot;

        requiredLevel = _requiredLevel;
    }
}
