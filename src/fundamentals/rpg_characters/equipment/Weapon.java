package fundamentals.rpg_characters.equipment;

import fundamentals.rpg_characters.exceptions.InvalidArmorException;
import fundamentals.rpg_characters.exceptions.InvalidWeaponException;

public class Weapon implements IEquipable {
    public final WeaponType weaponType;

    private final String name;

    private final int requiredLevel;

    private final int damage;
    private final float attacksPerSecond;

    public Weapon(String _name, WeaponType _weaponType, int _requiredLevel, int _damage, float _attacksPerSecond) throws InvalidWeaponException {
        name = _name;
        requiredLevel = _requiredLevel;

        damage = _damage;
        attacksPerSecond = _attacksPerSecond;

        if (damage < 0) {
            throw new InvalidWeaponException("Damage may not be less than 0!");
        }

        if (attacksPerSecond < 0) {
            throw new InvalidWeaponException("Attack speed may not be less than 0!");
        }

        weaponType = _weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public float getAttacksPerSecond() {
        return attacksPerSecond;
    }

    public float getDPS() {
        return damage * attacksPerSecond;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public EquipmentSlot getItemSlot() {
        return EquipmentSlot.Weapon;
    }

    @Override
    public int getRequiredLevel() {
        return requiredLevel;
    }
}
