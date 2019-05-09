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
    void 문자열_공백제거() {
        String result = game.removeBlank("  crong  ");
        assertThat(result).isEqualTo("crong");
    }

    @Test
    void 문자열_콤마_기준으로_분할() {
        String[] result = game.splitWithComma("pobi,crong,honux");
        String[] answer = {"pobi", "crong", "honux"};
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 자동차_이름_길이_5이하_확인() {
        boolean result = game.checkCarNameLength(true, "pobi");
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 자동차_이름_길이_5초과_확인() {
        boolean result = game.checkCarNameLength(true,"pobilove");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 랜덤_값_범위_확인() {
        int random = game.randomValueGenerator();
        boolean result = random >= 0 && random <= 9;
        assertThat(result).isEqualTo(true);
    }
}
