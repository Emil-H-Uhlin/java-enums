package fundamentals.rpg_characters.equipment;

import fundamentals.rpg_characters.equipment.*;
import fundamentals.rpg_characters.exceptions.InvalidArmorException;
import fundamentals.rpg_characters.exceptions.InvalidWeaponException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArmorTest {
    @Test
    void Armor_CreateCloth_ShouldNotThrow() {
        assertDoesNotThrow(()-> new Armor("Test", EquipmentSlot.Torso, 1, ArmorType.Cloth, 1, 1, 1));
    }

    @Test
    void Armor_CreateLeather_ShouldNotThrow() {
        assertDoesNotThrow(()-> new Armor("Test", EquipmentSlot.Torso, 1, ArmorType.Leather, 1, 1, 1));
    }

    @Test
    void Armor_CreateMail_ShouldNotThrow() {
        assertDoesNotThrow(()-> new Armor("Test", EquipmentSlot.Torso, 1, ArmorType.Mail, 1, 1, 1));
    }

    @Test
    void Armor_CreatePlate_ShouldNotThrow() {
        assertDoesNotThrow(()-> new Armor("Test", EquipmentSlot.Torso, 1, ArmorType.Plate, 1, 1, 1));
    }

    @Test
    void Armor_CreateTorso_ShouldNotThrow() {
        assertDoesNotThrow(()-> new Armor("Test", EquipmentSlot.Torso, 1, ArmorType.Cloth, 1, 1, 1));
    }

    @Test
    void Armor_CreateHead_ShouldNotThrow() {
        assertDoesNotThrow(()-> new Armor("Test", EquipmentSlot.Head, 1, ArmorType.Cloth, 1, 1, 1));
    }

    @Test
    void Armor_CreateLegs_ShouldNotThrow() {
        assertDoesNotThrow(()-> new Armor("Test", EquipmentSlot.Legs, 1, ArmorType.Cloth, 1, 1, 1));
    }

    @Test
    void Armor_CreateWithWeaponSlot_ShouldThrow() {
        assertThrows(InvalidArmorException.class, ()-> new Armor("Test", EquipmentSlot.Weapon, 1, ArmorType.Cloth, 1, 1, 1));
    }
}
