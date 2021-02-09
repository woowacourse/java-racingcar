package racingcar.domain.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundTest {

    @Test
    @DisplayName("Round 유효성 검사")
    void validateRound() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    new Round(0);
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    new Round("abc");
                })
        );
    }

    @Test
    @DisplayName("라운드 진행 테스트")
    void playRoundTest() {
        Round round = new Round("1");
        round.playRound();
        assertThat(round.getPlayed()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("라운드 진행 테스트")
    @CsvSource(value = {"1:True", "2:False"}, delimiter = ':')
    void allRoundPlayed(int roundValue, boolean expected) {
        Round round = new Round(roundValue);
        round.playRound();
        assertEquals(round.allRoundPlayed(), expected);
    }
}