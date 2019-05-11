package racinggame;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }
}
