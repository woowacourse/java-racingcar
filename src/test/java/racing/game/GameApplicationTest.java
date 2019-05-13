package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racing.game.GameApplication.*;

public class GameApplicationTest {
    private static int DEFAULT_NAMES_SIZE = 0;
    private static int ROUND_MIN_LIMIT = 1;

    @Test
    void 기준값보다_적은수의_이름을_입력한_경우_에러확인() {
        String names = "pobi";
        assertThrows(Exception.class, () -> splitNamesWithComma(names));
    }

    @Test
    void 이름에대한_입력으로_빈칸을_입력한_경우() {
        String names = "";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 이름에대한_입력으로_중복된_이름을_입력한_경우() {
        String names = "aaaa,bbbb,cccc,dddd,aaaa";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 이름에대한_입력으로_제한값_이상의_길이의_이름을_입력한_경우() {
        String names = "aaaa,bbbb,cccc,dddddd";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 이름에대한_입력으로_빈칸을_포함한_이름을_입력한_경우() {
        String names = "aaaa,bbbb,,cccc";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 라운드에대한_입력으로_문자를_입력한_경우() {
        String round = "aaaa";
        assertThat(checkRoundNum(round)).isLessThan(ROUND_MIN_LIMIT);
    }

    @Test
    void 라운드에대한_입력으로_1미만의_정수를_입력한_경우() {
        String round = "0";
        assertThat(checkRoundNum(round)).isLessThan(ROUND_MIN_LIMIT);
    }
}
