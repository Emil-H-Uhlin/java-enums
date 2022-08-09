package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.*;
import fundamentals.rpg_characters.exceptions.InvalidArmorException;
import fundamentals.rpg_characters.exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    //region Mage attributes
    @Test
    void Mage_Create_ShouldBeLevel1() {
        var hero = new Character("Tester", HeroClass.Mage);
        int expectedLevel = 1;

        // Assert
        assertEquals(expectedLevel, hero.getLevel());
    }

    @Test
    void Mage_Create_ShouldHaveCorrespondingStarterAttributes() {
        var hero = new Character("Tester", HeroClass.Mage);

        Attributes expected = HeroClass.Mage.level1Attributes;
        Attributes actual = hero.getBaseAttributes();

        assertAll(() -> {
            assertEquals(expected.getStrength(), actual.getStrength());
            assertEquals(expected.getDexterity(), actual.getDexterity());
            assertEquals(expected.getIntelligence(), actual.getIntelligence());
        });
    }

    @Test
    void Mage_LevelUp_ShouldReturn2() {
        var hero = new Character("Tester", HeroClass.Mage);
        int expectedLevel = 2;

        hero.levelUp();

        assertEquals(expectedLevel, hero.getLevel());
    }

    @Test
    void Mage_LevelUp_ShouldHaveIncreasedAttributes() {
        var hero = new Character("Tester", HeroClass.Mage);
        Attributes expected = HeroClass.Mage.level1Attributes.add(HeroClass.Mage.gainedAttributesPerLevel);

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
    void MageLvl1_EquipStaffReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Staff of Death", WeaponType.Staff, 1, 1, 1);

        assertDoesNotThrow(() -> hero.equip(weapon));
    }

    @Test
    void MageLvl1_EquipWandReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Wooden stick", WeaponType.Wand, 1, 1, 1);

        assertDoesNotThrow(() -> hero.equip(weapon));
    }

    @Test
    void MageLvl1_EquipStaffReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Staff of Destiny", WeaponType.Staff, 2, 1, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void MageLvl1_EquipWandReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Nail hammer", WeaponType.Wand, 2, 1, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void MageLvl1_EquipStaffReqLvl1_TestEquipped() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Staff of Death", WeaponType.Staff, 1, 1, 1);

        hero.equip(weapon);

        assertEquals(hero.getEquipment().get(EquipmentSlot.Weapon), weapon);
    }

    //endregion
    //region Disallowed weapons

    @Test
    void Mage_EquipDagger_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Small knife", WeaponType.Dagger, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void Mage_EquipSword_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Long sword", WeaponType.Sword, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void Mage_EquipHammer_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Basher", WeaponType.Hammer, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void Mage_EquipBow_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Shortbow", WeaponType.Bow, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    @Test
    void Mage_EquipAxe_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var weapon = new Weapon("Hand axe", WeaponType.Axe, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));
    }

    //endregion
    //region Allowed armor

    @Test
    void MageLvl1_EquipClothArmorReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var armor = new Armor("Chainmail", EquipmentSlot.Torso, 1, ArmorType.Cloth, 0, 0, 0);

        assertDoesNotThrow(() -> hero.equip(armor));
    }

    @Test
    void MageLvl1_EquipClothArmorReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var armor = new Armor("Chainmail", EquipmentSlot.Torso, 2, ArmorType.Cloth, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }

    //endregion
    //region Disallowed armor

    @Test
    void Mage_EquipLeatherArmor_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var armor = new Armor("Loin cloth", EquipmentSlot.Legs, 1, ArmorType.Leather, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }

    @Test
    void Mage_EquipMailArmor_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var armor = new Armor("Head band", EquipmentSlot.Head, 1, ArmorType.Mail, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }

    @Test
    void Mage_EquipPlateArmor_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Mage);
        var armor = new Armor("Head band", EquipmentSlot.Head, 1, ArmorType.Plate, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
    }

    //endregion
    //region Equip weapon affects dps

    @Test
    void Mage_EquipStaff_ShouldIncreaseDPS() {
       var hero = new Character("Tester", HeroClass.Mage);
       float dpsNoWeapon = hero.getDPS();

       var weapon = new Weapon("Staff", WeaponType.Staff, 1, 10, 1);
       hero.equip(weapon);

       assertTrue(hero.getDPS() > dpsNoWeapon);
    }

    @Test
    void Mage_EquipWand_ShouldIncreaseDPS() {
        var hero = new Character("Tester", HeroClass.Mage);
        float dpsNoWeapon = hero.getDPS();

        var weapon = new Weapon("Wand", WeaponType.Wand, 1, 10, 1.3f);
        hero.equip(weapon);

        assertTrue(hero.getDPS() > dpsNoWeapon);
    }

    //endregion
    //region Equip armor affects stats

    @Test
    void Mage_EquipClothArmor_ShouldAffectAttributes() {
        var hero = new Character("Tester", HeroClass.Mage);
        var armor = new Armor("Chainmail", EquipmentSlot.Torso, 1, ArmorType.Cloth, 4, 2, 2);

        var expected = hero.getBaseAttributes().add(armor.getBonusAttributes());
        hero.equip(armor);

        var actual = hero.getTotalAttributes();

        assertAll(() -> {
            assertEquals(expected.getStrength(), actual.getStrength());
            assertEquals(expected.getDexterity(), actual.getDexterity());
            assertEquals(expected.getIntelligence(), actual.getIntelligence());
        });
    }

    @Test
    void Mage_EquipMultipleArmor_ShouldAffectAttributes() {
        var hero = new Character("Tester", HeroClass.Mage);

        var armors = new Armor[] {
                new Armor("Simple dress", EquipmentSlot.Torso, 1, ArmorType.Cloth, 0, 2, 10),
                new Armor("Hood", EquipmentSlot.Head, 1, ArmorType.Cloth, 1, 1, 4),
        };

        var expected = hero.getBaseAttributes().add(new Attributes(1, 2+1, 10+4));

        for (var armor: armors) {
            hero.equip(armor);
        }

        var actual = hero.getTotalAttributes();

        assertAll(() -> {
            assertEquals(expected.getStrength(), actual.getStrength());
            assertEquals(expected.getDexterity(), actual.getDexterity());
            assertEquals(expected.getIntelligence(), actual.getIntelligence());
        });
    }

    @Test
    void Mage_EquipClothArmor_ShouldAffectDPS() {
        var hero = new Character("Tester", HeroClass.Mage);
        var armor = new Armor("Pretty dress", EquipmentSlot.Torso, 1, ArmorType.Cloth, 1, 2, 5);

        float initialDPS = hero.getDPS();
        hero.equip(armor);

        float dpsAfterEquip = hero.getDPS();

        assertTrue(dpsAfterEquip > initialDPS);
    }

    //endregion

    @Test
    void Mage_EquipArmorAndWeapon_ShouldAffectDPS() {
        var hero = new Character("Tester", HeroClass.Mage);
        var baseDps = hero.getDPS();

        var armors = new Armor[] {
                new Armor("Bathrobe", EquipmentSlot.Torso, 1, ArmorType.Cloth, 5, 2, 2),
                new Armor("Spandex", EquipmentSlot.Legs, 1, ArmorType.Cloth, 2, 1, 0),
                new Armor("Ski mask", EquipmentSlot.Head, 1, ArmorType.Cloth, 1, 1, 0),
        };

        var weapon = new Weapon("Iron stick", WeaponType.Wand, 1, 10, 1.2f);


        for (var armor: armors) {
            hero.equip(armor);
        }

        var dpsWithArmor = hero.getDPS();

        hero.equip(weapon);

        var dpsWithArmorAndWeapon = hero.getDPS();

        assertTrue(dpsWithArmorAndWeapon > dpsWithArmor && dpsWithArmor > baseDps);
    }
}