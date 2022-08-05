package fundamentals.rpg_characters.equipment;

public class Weapon implements IEquippable {
    public final WeaponType weaponType;

    private int damage;
    private float attacksPerSecond;

    public int getDamage() { return damage; }
    public void setDamage(int _value) { damage = _value; }

    public float getAttacksPerSecond() { return attacksPerSecond; }
    public void setAttacksPerSecond(float _value) { attacksPerSecond = _value; }

    public float getDPS() {
        return damage * attacksPerSecond;
    }

    public Weapon(String _name, WeaponType _weaponType, int _requiredLevel, int _damage, float _attacksPerSecond) {
        damage = _damage;
        attacksPerSecond = _attacksPerSecond;

        weaponType = _weaponType;
    }

    @Override
    public String getItemName() {
        return null;
    }

    @Override
    public EquipmentSlot getItemSlot() {
        return null;
    }

    @Override
    public int getRequiredLevel() {
        return 0;
    }
}
