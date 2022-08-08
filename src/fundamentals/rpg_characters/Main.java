package fundamentals.rpg_characters;

import fundamentals.rpg_characters.characters.Character;
import fundamentals.rpg_characters.characters.HeroClass;
import fundamentals.rpg_characters.equipment.*;

public class Main {
    public static void main(String[] args) {
        var hero = new Character("Emil, the Destroyer", HeroClass.Warrior);

        hero.equip(new Weapon("Fire sword", WeaponType.Sword, 1, 10, 1.2f));
        hero.equip(new Armor("Bladed cuirass", EquipmentSlot.Torso, 1, ArmorType.Plate, 2, 1, 1));

        System.out.println(hero.display());
    }
}
