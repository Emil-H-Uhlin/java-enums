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
- Create a new project using either **_IntelliJ_** or **_Eclipse_**
- Import _src/_ to project root
- There is no _run_ per se, but if you'd like to mess around you can add some 
logic to `public static void main(String[] args)` in `Main.java` and run 
the file.

#### Testing
If you'd like to check out or do some additional testing also import the _test/_-
folder to your project root, after making sure to add JUnit 5 to project 
dependencies.