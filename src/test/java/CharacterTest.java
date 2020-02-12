import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterTest {

    @Test
    void 캐릭터타입_equals_학습 () {
        Character character = ':';
        assertTrue(character.equals(':'));
    }
}
