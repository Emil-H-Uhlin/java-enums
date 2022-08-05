package fundamentals.rpg_characters.characters;

import fundamentals.rpg_characters.equipment.*;
import fundamentals.rpg_characters.exceptions.InvalidArmorException;
import fundamentals.rpg_characters.exceptions.InvalidWeaponException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    //region Warrior attributes
    @Test
    void Warrior_Create_ShouldBeLevel1() {
        var hero = new Character("Tester", HeroClass.Warrior);
        int expectedLevel = 1;

        // Assert
        assertEquals(expectedLevel, hero.getLevel());
    }

    @Test
    void Warrior_Create_ShouldHaveCorrespondingStarterAttributes() {
        var hero = new Character("Tester", HeroClass.Warrior);

        Attributes expected = HeroClass.Warrior.level1Attributes;
        Attributes actual = hero.getBaseAttributes();

        assertEquals(expected.getStrength(), actual.getStrength());
        assertEquals(expected.getDexterity(), actual.getDexterity());
        assertEquals(expected.getIntelligence(), actual.getIntelligence());
    }

    @Test
    void Warrior_LevelUp_ShouldReturn2() {
        var hero = new Character("Tester", HeroClass.Warrior);
        int expectedLevel = 2;

        hero.levelUp();

        assertEquals(expectedLevel, hero.getLevel());
    }

    @Test
    void Warrior_LevelUp_ShouldHaveIncreasedAttributes() {
        var hero = new Character("Tester", HeroClass.Warrior);
        Attributes expected = HeroClass.Warrior.level1Attributes.add(HeroClass.Warrior.gainedAttributesPerLevel);

        hero.levelUp();

        Attributes actual = hero.getBaseAttributes();

        assertEquals(expected.getStrength(), actual.getStrength());
        assertEquals(expected.getDexterity(), actual.getDexterity());
        assertEquals(expected.getIntelligence(), actual.getIntelligence());
    }

    //endregion
    //region Allowed weapons

    @Test
    void WarriorLvl1_EquipAxeReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var axe = new Weapon("Basic axe", WeaponType.Axe, 1, 1, 1);

        assertDoesNotThrow(() -> hero.equip(axe));
    }

    @Test
    void WarriorLvl1_EquipHammerReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var axe = new Weapon("Nail hammer", WeaponType.Hammer, 1, 1, 1);

        assertDoesNotThrow(() -> hero.equip(axe));
    }

    @Test
    void WarriorLvl1_EquipSwordReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var axe = new Weapon("Straight sword", WeaponType.Sword, 1, 1, 1);

        assertDoesNotThrow(() -> hero.equip(axe));
    }

    @Test
    void WarriorLvl1_EquipAxeReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var axe = new Weapon("Basic axe", WeaponType.Axe, 2, 1, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(axe));
    }

    @Test
    void WarriorLvl1_EquipHammerReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var axe = new Weapon("Nail hammer", WeaponType.Hammer, 2, 1, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(axe));
    }

    @Test
    void WarriorLvl1_EquipSwordReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var axe = new Weapon("Straight sword", WeaponType.Sword, 2, 1, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(axe));
    }

    //endregion
    //region Disallowed weapons

    @Test
    void Warrior_EquipDagger_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var staff = new Weapon("Small knife", WeaponType.Dagger, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(staff));
    }

    @Test
    void Warrior_EquipStaff_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var staff = new Weapon("Long stick", WeaponType.Staff, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(staff));
    }

    @Test
    void Warrior_EquipWand_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var staff = new Weapon("Small magic stick", WeaponType.Wand, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(staff));
    }

    @Test
    void Warrior_EquipBow_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var staff = new Weapon("Shortbow", WeaponType.Bow, 1, 10, 1);

        assertThrows(InvalidWeaponException.class, () -> hero.equip(staff));
    }

    //endregion
    //region Allowed armor

    @Test
    void WarriorLvl1_EquipMailArmorReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var mail = new Armor("Chainmail", EquipmentSlot.Torso, 1, ArmorType.Mail, 0, 0, 0);

        assertDoesNotThrow(() -> hero.equip(mail));
    }

    @Test
    void WarriorLvl1_EquipPlateArmorReqLvl1_ShouldNotThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var cuirass = new Armor("Steel cuirass", EquipmentSlot.Torso, 1, ArmorType.Plate, 0, 0, 0);

        assertDoesNotThrow(() -> hero.equip(cuirass));
    }

    @Test
    void WarriorLvl1_EquipMailArmorReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var mail = new Armor("Chainmail", EquipmentSlot.Torso, 2, ArmorType.Mail, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(mail));
    }

    @Test
    void WarriorLvl1_EquipPlateArmorReqLvl2_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var cuirass = new Armor("Steel cuirass", EquipmentSlot.Torso,2, ArmorType.Plate, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(cuirass));
    }

    //endregion
    //region Disallowed armor

    @Test
    void Warrior_EquipClothArmor_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var cloth = new Armor("Loin cloth", EquipmentSlot.Legs, 1, ArmorType.Cloth, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(cloth));
    }

    @Test
    void Warrior_EquipLeatherArmor_ShouldThrow() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var leatherArmor = new Armor("Head band", EquipmentSlot.Head, 1, ArmorType.Leather, 0, 0, 0);

        assertThrows(InvalidArmorException.class, () -> hero.equip(leatherArmor));
    }

    //endregion
    //region Equip weapon affects dps

    @Test
    void Warrior_EquipAxe_ShouldIncreaseDPS() {
       var hero = new Character("Tester", HeroClass.Warrior);
       float dpsNoWeapon = hero.getDPS();

       var weapon = new Weapon("Hatchet", WeaponType.Axe, 1, 10, 1);
       hero.equip(weapon);

       assertTrue(hero.getDPS() > dpsNoWeapon);
    }

    @Test
    void Warrior_EquipSword_ShouldIncreaseDPS() {
        var hero = new Character("Tester", HeroClass.Warrior);
        float dpsNoWeapon = hero.getDPS();

        var weapon = new Weapon("Short sword", WeaponType.Sword, 1, 10, 1.3f);
        hero.equip(weapon);

        assertTrue(hero.getDPS() > dpsNoWeapon);
    }

    @Test
    void Warrior_EquipHammer_ShouldIncreaseDPS() {
        var hero = new Character("Tester", HeroClass.Warrior);
        float dpsNoWeapon = hero.getDPS();

        var weapon = new Weapon("Short sword", WeaponType.Hammer, 1, 20, .7f);
        hero.equip(weapon);

        assertTrue(hero.getDPS() > dpsNoWeapon);
    }

    //endregion
    //region Equip armor affects stats

    @Test
    void Warrior_EquipMailArmor_ShouldAffectAttributes() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var armor = new Armor("Chainmail", EquipmentSlot.Torso, 1, ArmorType.Mail, 4, 2, 2);

        var expectedTotal = hero.getBaseAttributes().add(armor.getBonusAttributes());
        hero.equip(armor);

        var total = hero.getTotalAttributes();

        assertEquals(expectedTotal.getStrength(), total.getStrength());
        assertEquals(expectedTotal.getDexterity(), total.getDexterity());
        assertEquals(expectedTotal.getIntelligence(), total.getIntelligence());
    }

    @Test
    void Warrior_EquipPlateArmor_ShouldAffectAttributes() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var armor = new Armor("Iron cuirass", EquipmentSlot.Torso, 1, ArmorType.Plate, 8, 1, 0);

        var expectedTotal = hero.getBaseAttributes().add(armor.getBonusAttributes());

        hero.equip(armor);

        var total = hero.getTotalAttributes();

        assertEquals(expectedTotal.getStrength(), total.getStrength());
        assertEquals(expectedTotal.getDexterity(), total.getDexterity());
        assertEquals(expectedTotal.getIntelligence(), total.getIntelligence());
    }

    @Test
    void Warrior_EquipMultipleArmor_ShouldAffectAttributes() {
        var hero = new Character("Tester", HeroClass.Warrior);

        var armors = new Armor[] {
                new Armor("Iron cuirass", EquipmentSlot.Torso, 1, ArmorType.Plate, 5, 2, 2),
                new Armor("Iron leggings", EquipmentSlot.Legs, 1, ArmorType.Plate, 2, 1, 0),
                new Armor("Iron bucket", EquipmentSlot.Head, 1, ArmorType.Plate, 1, 1, 0),
        };

        var expectedTotal = hero.getBaseAttributes().add(new Attributes(5+2+1, 2+1+1, 2+0+0));

        for (var armor: armors) {
            hero.equip(armor);
        }

        var total = hero.getTotalAttributes();

        assertEquals(expectedTotal.getStrength(), total.getStrength());
        assertEquals(expectedTotal.getDexterity(), total.getDexterity());
        assertEquals(expectedTotal.getIntelligence(), total.getIntelligence());
    }

    @Test
    void Warrior_EquipMailArmor_ShouldAffectDPS() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var armor = new Armor("Chainmail", EquipmentSlot.Torso, 1, ArmorType.Mail, 8, 1, 0);

        float initialDPS = hero.getDPS();
        hero.equip(armor);

        float dpsAfterEquip = hero.getDPS();

        assertTrue(dpsAfterEquip > initialDPS);
    }

    @Test
    void Warrior_EquipPlateArmor_ShouldAffectDPS() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var armor = new Armor("Cuirass", EquipmentSlot.Torso, 1, ArmorType.Plate, 15, 1, 0);

        float initialDPS = hero.getDPS();
        hero.equip(armor);

        float dpsAfterEquip = hero.getDPS();

        assertTrue(dpsAfterEquip > initialDPS);
    }

    //endregion

    @Test
    void Warrior_EquipArmorAndWeapon_ShouldAffectDPS() {
        var hero = new Character("Tester", HeroClass.Warrior);
        var baseDps = hero.getDPS();

        var armors = new Armor[] {
                new Armor("Iron cuirass", EquipmentSlot.Torso, 1, ArmorType.Plate, 5, 2, 2),
                new Armor("Iron leggings", EquipmentSlot.Legs, 1, ArmorType.Plate, 2, 1, 0),
                new Armor("Iron bucket", EquipmentSlot.Head, 1, ArmorType.Plate, 1, 1, 0),
        };

        var weapon = new Weapon("Iron stick", WeaponType.Hammer, 1, 10, 1.2f);


        for (var armor: armors) {
            hero.equip(armor);
        }

        var dpsWithArmor = hero.getDPS();

        hero.equip(weapon);

        var dpsWithArmorAndWeapon = hero.getDPS();

        assertTrue(dpsWithArmorAndWeapon > dpsWithArmor && dpsWithArmor > baseDps);
    }
}