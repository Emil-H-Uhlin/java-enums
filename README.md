# RPG-Characters
###### Keywords
_Java, Polymorphism, Exceptions, Interfaces, Enums, Unit testing_

### Overview
This project is written in pure Java and is the basis for a small RPG
game. _Create, level up and equip your character with cool but text
represented weapons!_

The project includes some key functionality for creating a character, weapons and 
armor. Weapons have DPS calculated based on weapon damage and attack speed. Armor
provide the character with bonus attributes which assists in scaling the character
DPS.

##### Requirements
- Various _character classes_ having attributes which increase at different rates as the character gains levels.
- _Equipment_, such as armor and weapons, that characters can equip. The equipped items will alter the power of the character, causing it to deal more damage and be able to survive longer. Certain characters can equip certain item types.
- _Custom exceptions._ There are two custom exceptions you are required to write.
- _Full test coverage of the functionality._ Some testing data is provided, it can be used to complete the assignment in a test-driven development manner.

### Character classes
I first implemented character classes as their own classes inheriting from an 
abstract super-class `Hero.java`. I realised that creating new characters would 
be an annoyance since you'd have to create a new class that inherits from `Hero` 
every time you'd want to add a new character class to the project. You'd also have 
to override some methods, and flood the file hierarchy if your game has a lot 
of classes.

Instead, I figured I'd make use of _Java enums_ which I had previously learned can do
much more than something like C# enums. And so I created _HeroClass_, an enum that 
contains info relevant for any character class.  
This compacts the program and makes it easier to add new character classes. If you'd
want to add a new class, simply add another entry to the Enum as such: 

```` java
public enum HeroClass {
    Warrior(...), 
    Rogue(...), 
    Ranger(...), 
    Mage(...), 
    
    Druid(3, 1, 3,                              // level 1 stats
        2, 2, 2,                                // stats gained per level
        PrimaryAttribute.Intelligence,          // class primary attribute
        new WeaponType[] {
            WeaponType.Staff, WeaponType.Hammer // allowed weapon types
        },
        new ArmorType[] {
            ArmorType.Leather, ArmorType.Mail   // allowed armor types
        });   
    .
    .
    .
}
````
You can now instantiate your new class by calling: 
```` java
/* Create a character */
var hero = new Character("Emil", HeroClass.Druid);
````

### Install and run
The project is built in IntelliJ using <b>JDK 17</b> and <b>JUnit 5</b>.
- Install JDK 17
- With IntelliJ 
  - Either create a new project using the _Project from Version Control_ option 
  to clone project. 
  - Or create a new empty project and import _src/_ to root folder.
- There is no _run_ per se, but if you'd like to mess around you can add some 
logic to `public static void main(String[] args)` in `Main.java` and run 
the file/project.

#### Testing
If you'd like to check out or do some additional testing also import the 
_test/_-folder to your project root, after making sure __JUnit5__ is in the project 
dependencies.

To add a new test, add a new `static void`-method and mark it with
the `@Test`-annotation. In order to test a feature the method needs some sort 
of assertion-call. If multiple calls are required (as when testing attributes), use
`assertAll()` as such: 

```` java
var expected = hero.getBaseAttributes().add(new Attributes(6, 12, 5));
var actual = hero.getTotalAttributes();

assertAll(() -> {
        assertEquals(expected.getStrength(), actual.getStrength());
        assertEquals(expected.getDexterity(), actual.getDexterity());
        assertEquals(expected.getIntelligence(), actual.getIntelligence());
});
````
