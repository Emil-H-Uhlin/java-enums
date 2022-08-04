package fundamentals.rpg_characters;

import fundamentals.rpg_characters.characters.Character;
import fundamentals.rpg_characters.characters.HeroClass;
import fundamentals.rpg_characters.equipment.*;

public class Main {
    public static void main(String[] args) {
        var character = new Character("Emil, the destroyer", HeroClass.Warrior);

        var item = new Armor("Iron Curiass", EquipmentSlot.Torso, 1, ArmorType.Plate, 2, 1, 1);

        character.equip(item);

        for (int i = 0; i < 2; i++) {
            character.levelUp();
        }
        
        System.out.println(character);
    }
}
