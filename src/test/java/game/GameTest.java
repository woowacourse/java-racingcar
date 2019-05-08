package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void 공백제거() {
        String result = game.removeBlank("  crong  ");
        assertThat(result).isEqualTo("crong");
    }
}
