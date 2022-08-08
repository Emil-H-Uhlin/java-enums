package fundamentals.rpg_characters.equipment;

import fundamentals.rpg_characters.exceptions.InvalidArmorException;
import fundamentals.rpg_characters.exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeaponTest {
    @Test
    void Weapon_Create_ShouldNotThrow() {
        assertDoesNotThrow(()-> new Weapon("Test", WeaponType.Axe, 1, 1, 1));
    }

    @Test
    void Weapon_CreateNegativeDamage_ShouldThrow() {
        assertThrows(InvalidWeaponException.class, () -> new Weapon("Test", WeaponType.Axe, 1, -1, 1));
    }

    @Test
    void Weapon_CreateNegativeAttackSpeed_ShouldThrow() {
        assertThrows(InvalidWeaponException.class, ()-> new Weapon("Test", WeaponType.Axe, 1, 1, -1));
    }
}
