package fundamentals.rpg_characters.equipment;

public class Weapon extends Equipment {
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
        super(_name, EquipmentSlot.Weapon, _requiredLevel);

        damage = _damage;
        attacksPerSecond = _attacksPerSecond;

        weaponType = _weaponType;
    }
}
