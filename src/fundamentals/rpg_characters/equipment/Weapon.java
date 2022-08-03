package fundamentals.rpg_characters.equipment;

public class Weapon extends Equipment {
    public final WeaponType weaponType;

    public Weapon(String _name, EquipmentSlot _slot, WeaponType _weaponType) {
        super(_name, _slot);

        weaponType = _weaponType;
    }
}
