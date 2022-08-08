package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.EquipmentSlot;
import fundamentals.rpg_characters.equipment.IEquipable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterTest {
    @Test
    void Character_EquipInvalidWeapon_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);

        hero.equip(new IEquipable() {
            @Override
            public String getItemName() {
                return "item?";
            }

            @Override
            public EquipmentSlot getItemSlot() {
                return EquipmentSlot.Weapon;
            }

            @Override
            public int getRequiredLevel() {
                return 0;
            }
        });

        assertThrows(Exception.class, () -> hero.getDPS());
    }
}
