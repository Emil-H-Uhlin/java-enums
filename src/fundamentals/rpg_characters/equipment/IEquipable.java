package fundamentals.rpg_characters.equipment;

public interface IEquipable {
    String getItemName();
    EquipmentSlot getItemSlot();
    int getRequiredLevel();
}
