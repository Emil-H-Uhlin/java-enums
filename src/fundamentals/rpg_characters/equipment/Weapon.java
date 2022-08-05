package fundamentals.rpg_characters.equipment;

public class Weapon implements IEquippable {
    public final WeaponType weaponType;

    private final String name;

    private final int requiredLevel;

    private final int damage;
    private final float attacksPerSecond;

    public Weapon(String _name, WeaponType _weaponType, int _requiredLevel, int _damage, float _attacksPerSecond) {
        name = _name;
        requiredLevel = _requiredLevel;

        damage = _damage;
        attacksPerSecond = _attacksPerSecond;

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
