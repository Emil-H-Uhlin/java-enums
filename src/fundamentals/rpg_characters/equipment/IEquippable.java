package fundamentals.rpg_characters.equipment;

public interface IEquippable {
    String getItemName();
    EquipmentSlot getItemSlot();
    int getRequiredLevel();
}
