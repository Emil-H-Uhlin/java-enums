package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.*;
import fundamentals.rpg_characters.exceptions.InvalidArmorException;
import fundamentals.rpg_characters.exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {
    //region Rogue attributes
    @Test
    void Rogue_Create_ShouldBeLevel1() {
        var hero = new Character("Tester", HeroClass.Rogue);
        int expectedLevel = 1;

        // Assert
        assertEquals(expectedLevel, hero.getLevel());
    }

    @Test
    void Rogue_Create_ShouldHaveCorrespondingStarterAttributes() {
        var hero = new Character("Tester", HeroClass.Rogue);

        Attributes expected = HeroClass.Rogue.level1Attributes;
        Attributes actual = hero.getBaseAttributes();

        assertAll(() -> {
            assertEquals(expected.getStrength(), actual.getStrength());
            assertEquals(expected.getDexterity(), actual.getDexterity());
            assertEquals(expected.getIntelligence(), actual.getIntelligence());
        });
    }

    @Test
    void Rogue_LevelUp_ShouldReturn2() {
        var hero = new Character("Tester", HeroClass.Rogue);
        int expectedLevel = 2;

        hero.levelUp();

        assertEquals(expectedLevel, hero.getLevel());
    }

    @Test
    void Rogue_LevelUp_ShouldHaveIncreasedAttributes() {
        var hero = new Character("Tester", HeroClass.Rogue);
        Attributes expected = HeroClass.Rogue.level1Attributes.add(HeroClass.Rogue.gainedAttributesPerLevel);

        hero.levelUp();

        Attributes actual = hero.getBaseAttributes();

        assertAll(() -> {
            assertEquals(expected.getStrength(), actual.getStrength());
            assertEquals(expected.getDexterity(), actual.getDexterity());
            assertEquals(expected.getIntelligence(), actual.getIntelligence());
        });
    }

    //endregion
    //region Allowed weapons

    @Test
    void RogueLvl1_EquipDaggerReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Small knife", WeaponType.Dagger, 1, 1, 1);

        assertDoesNotThrow(() -> hero.equip(weapon));
    }

    @Test
    void RogueLvl1_EquipSwordReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Pointy rapier", WeaponType.Sword, 1, 1, 1);

        assertDoesNotThrow(() -> hero.equip(weapon));
    }

    @Test
    void RogueLvl1_EquipDaggerReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Dagger", WeaponType.Dagger, 2, 1, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void RogueLvl1_EquipSwordReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Sword", WeaponType.Sword, 2, 1, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void RogueLvl1_EquipDaggerReqLvl1_TestEquipped() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Small knife", WeaponType.Dagger, 1, 1, 1);

        hero.equip(weapon);

        assertEquals(hero.getEquipment().get(EquipmentSlot.Weapon), weapon);
    }

    //endregion
    //region Disallowed weapons

    @Test
    void Rogue_EquipAxe_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Small axe", WeaponType.Axe, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void Rogue_EquipBow_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Long bow", WeaponType.Bow, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void Rogue_EquipHammer_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Basher", WeaponType.Hammer, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void Rogue_EquipStaff_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Magic staff", WeaponType.Staff, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void Rogue_EquipWand_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var weapon = new Weapon("Pointy wooden stick", WeaponType.Wand, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    //endregion
    //region Allowed armor

    @Test
    void RogueLvl1_EquipLeatherArmorReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var armor = new Armor("Patches' armor", EquipmentSlot.Torso, 1, ArmorType.Leather, 0, 0, 0);

        assertDoesNotThrow(() -> hero.equip(armor));
    }

    @Test
    void RogueLvl1_EquipMailArmorReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var armor = new Armor("Chainmail", EquipmentSlot.Torso, 1, ArmorType.Mail, 0, 0, 0);

        assertDoesNotThrow(() -> hero.equip(armor));
    }

    @Test
    void RogueLvl1_EquipLeatherArmorReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var armor = new Armor("Leather armor", EquipmentSlot.Torso, 2, ArmorType.Leather, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }

    @Test
    void RogueLvl1_EquipMailArmorReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var armor = new Armor("Chainmail", EquipmentSlot.Torso, 2, ArmorType.Mail, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }

    //endregion
    //region Disallowed armor

    @Test
    void Rogue_EquipClothArmor_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var armor = new Armor("Loin cloth", EquipmentSlot.Legs, 1, ArmorType.Cloth, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }

    @Test
    void Rogue_EquipPlateArmor_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var armor = new Armor("Hollow iron ball", EquipmentSlot.Head, 1, ArmorType.Plate, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }

    //endregion
    //region Equip weapon affects dps

    @Test
    void Rogue_EquipDagger_ShouldIncreaseDPS() {
       var hero = new Character("Tester", HeroClass.Rogue);
       float dpsNoWeapon = hero.getDPS();

       var weapon = new Weapon("Hidden blade", WeaponType.Dagger, 1, 10, 1);
       hero.equip(weapon);

       assertTrue(hero.getDPS() > dpsNoWeapon);
    }

    @Test
    void Rogue_EquipSword_ShouldIncreaseDPS() {
        var hero = new Character("Tester", HeroClass.Rogue);
        float dpsNoWeapon = hero.getDPS();

        var weapon = new Weapon("Daedric sword", WeaponType.Sword, 1, 10, 1.3f);
        hero.equip(weapon);

        assertTrue(hero.getDPS() > dpsNoWeapon);
    }

    //endregion
    //region Equip armor affects stats

    @Test
    void Rogue_EquipLeatherArmor_ShouldAffectAttributes() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var armor = new Armor("Chainmail", EquipmentSlot.Torso, 1, ArmorType.Leather, 4, 6, 2);

        var expectedTotal = hero.getBaseAttributes().add(armor.getBonusAttributes());
        hero.equip(armor);

        var total = hero.getTotalAttributes();

        assertEquals(expectedTotal.getStrength(), total.getStrength());
        assertEquals(expectedTotal.getDexterity(), total.getDexterity());
        assertEquals(expectedTotal.getIntelligence(), total.getIntelligence());
    }

    @Test
    void Rogue_EquipMailArmor_ShouldAffectAttributes() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var armor = new Armor("Chainmail", EquipmentSlot.Torso, 1, ArmorType.Mail, 4, 6, 2);

        var expectedTotal = hero.getBaseAttributes().add(armor.getBonusAttributes());
        hero.equip(armor);

        var total = hero.getTotalAttributes();

        assertEquals(expectedTotal.getStrength(), total.getStrength());
        assertEquals(expectedTotal.getDexterity(), total.getDexterity());
        assertEquals(expectedTotal.getIntelligence(), total.getIntelligence());
    }

    @Test
    void Rogue_EquipMultipleArmor_ShouldAffectAttributes() {
        var hero = new Character("Tester", HeroClass.Rogue);

        var armors = new Armor[] {
                new Armor("Leather cuirass", EquipmentSlot.Torso, 1, ArmorType.Leather, 4, 5, 2),
                new Armor("Chain mail trousers", EquipmentSlot.Legs, 1, ArmorType.Mail, 1, 5, 2),
                new Armor("Leather helmet", EquipmentSlot.Head, 1, ArmorType.Leather, 1, 2, 1),
        };

        var expectedTotal = hero.getBaseAttributes().add(new Attributes(4+1+1, 5+5+2, 2+2+1));

        for (var armor: armors) {
            hero.equip(armor);
        }

        var total = hero.getTotalAttributes();

        assertEquals(expectedTotal.getStrength(), total.getStrength());
        assertEquals(expectedTotal.getDexterity(), total.getDexterity());
        assertEquals(expectedTotal.getIntelligence(), total.getIntelligence());
    }

    //endregion

    @Test
    void Rogue_EquipArmorAndWeapon_ShouldAffectDPS() {
        var hero = new Character("Tester", HeroClass.Rogue);
        var baseDps = hero.getDPS();

        var armors = new Armor[] {
                new Armor("Hardened leather cuirass", EquipmentSlot.Torso, 1, ArmorType.Leather, 10, 20, 2),
                new Armor("Spandex", EquipmentSlot.Legs, 1, ArmorType.Leather, 2, 2, 0),
        };

        var weapon = new Weapon("Prison shank", WeaponType.Dagger, 1, 6, 2f);

        for (var armor: armors) {
            hero.equip(armor);
        }

        var dpsWithArmor = hero.getDPS();

        hero.equip(weapon);

        var dpsWithArmorAndWeapon = hero.getDPS();

        assertTrue(dpsWithArmorAndWeapon > dpsWithArmor && dpsWithArmor > baseDps);
    }
}