package fundamentals.rpg_characters.characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttributesTest {
    @Test
    void Attributes_Create_ShouldNotAllowNegativeValues() {
        assertThrows(Exception.class, () -> new Attributes(-1, -1, -1));
    }
}