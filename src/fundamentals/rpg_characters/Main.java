package fundamentals.rpg_characters;

import fundamentals.rpg_characters.characters.Character;
import fundamentals.rpg_characters.characters.HeroClass;
import fundamentals.rpg_characters.equipment.Armor;
import fundamentals.rpg_characters.equipment.ArmorType;
import fundamentals.rpg_characters.equipment.EquipmentSlot;

public class Main {
    public static void main(String[] args) {
        var character = new Character("Emil, the destroyer", HeroClass.Warrior);

        System.out.println(character);

        character.equip(new Armor("Iron cuirass",
                EquipmentSlot.Torso,
                1,
                ArmorType.Plate,
                2,
                1,
                1));

        System.out.println(character);

        for (int i = 0; i < 3; i++)
            character.levelUp();

        System.out.println(character);
    }
}
