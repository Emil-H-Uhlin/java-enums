package fundamentals.rpg_characters.equipment;

import java.util.Arrays;

public class Armor extends Equipment {
    public final ArmorType armorType;

    private int bonusStrength;
    private int bonusDexterity;
    private int bonusIntelligence;

    public int getBonusStrength() { return bonusStrength; }
    public void setBonusStrength(int _value) { bonusStrength = _value; }

    public int getBonusDexterity() { return bonusDexterity; }
    public void setBonusDexterity(int _value) { bonusDexterity = _value; }

    public int getBonusIntelligence() { return bonusIntelligence; }
    public void setBonusIntelligence(int _value) { bonusIntelligence = _value; }

    public Armor(String _name, EquipmentSlot _slot, int _requiredLevel, ArmorType _armorType,
                 int _bonusStr, int _bonusDex, int _bonusInt) {
        super(_name, _slot, _requiredLevel);

        if (_slot == EquipmentSlot.Weapon) {
            // throw exception
        }

        armorType = _armorType;

        bonusStrength = _bonusStr;
        bonusDexterity = _bonusDex;
        bonusIntelligence = _bonusInt;
    }
}
