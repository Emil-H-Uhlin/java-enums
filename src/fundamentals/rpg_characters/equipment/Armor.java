package fundamentals.rpg_characters.equipment;

import fundamentals.rpg_characters.exceptions.InvalidArmorException;

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
                 int _bonusStr, int _bonusDex, int _bonusInt) throws InvalidArmorException {
        super(_name, _slot, _requiredLevel);

        if (_slot == EquipmentSlot.Weapon) {
            throw new InvalidArmorException("An armor may not be assigned to slot 'Weapon'!");
        }

        armorType = _armorType;

        bonusStrength = _bonusStr;
        bonusDexterity = _bonusDex;
        bonusIntelligence = _bonusInt;
    }
}
