package fundamentals.rpg_characters.equipment;

public class Weapon extends Equipment {
    public final WeaponType weaponType;

    public Weapon(String _name, WeaponType _weaponType) {
        super(_name, EquipmentSlot.Weapon);

        weaponType = _weaponType;
    }
}
