package fundamentals.rpg_characters.equipment;

public abstract class Equipment {
    public final String name;
    public final EquipmentSlot itemSlot;

    private int requiredLevel;

    private int bonusStrength;
    private int bonusDexterity;
    private int bonusIntelligence;

    public int getRequiredLevel() { return requiredLevel; }
    public void setRequiredLevel(int _value) { requiredLevel = _value; }

    public int getBonusStrength() { return bonusStrength; }
    public void setBonusStrength(int _value) { bonusStrength = _value; }

    public int getBonusDexterity() { return bonusDexterity; }
    public void setBonusDexterity(int _value) { bonusDexterity = _value; }

    public int getBonusIntelligence() { return bonusIntelligence; }
    public void setBonusIntelligence(int _value) { bonusIntelligence = _value; }

    public Equipment(String _name, EquipmentSlot _slot, int _requiredLevel) {
        name = _name;
        itemSlot = _slot;

        requiredLevel = _requiredLevel;
    }
}
