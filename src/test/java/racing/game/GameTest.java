package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racing.game.Game.*;

public class GameTest {
    private static int DEFAULT_NAMES_SIZE = 0;
    private static int ROUND_MIN_LIMIT = 1;

    @Test
    void 기준값보다적은이름을입력했을때에러확인() {
        String names = "pobi";
        assertThrows(Exception.class, () -> splitNamesWithComma(names));
    }

    @Test
    void 이름에대한입력으로빈칸을입력했을때확인() {
        String names = "";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 이름에대한입력으로중복된이름을입력했을때확인() {
        String names = "aaaa,bbbb,cccc,dddd,aaaa";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 이름에대한입력으로제한값이상의길이의이름을입력했을때확인() {
        String names = "aaaa,bbbb,cccc,dddddd";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 이름에대한입력으로빈칸을포함한입력했을때확인() {
        String names = "aaaa,bbbb,,cccc";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 라운드에대한입력으로문자를입력했을때확인() {
        String round = "aaaa";
        assertThat(checkRoundNum(round)).isLessThan(ROUND_MIN_LIMIT);
    }

    @Test
    void 라운드에대한입력으로1미만의정수를입력했을때확인() {
        String round = "0";
        assertThat(checkRoundNum(round)).isLessThan(ROUND_MIN_LIMIT);
    }
}
