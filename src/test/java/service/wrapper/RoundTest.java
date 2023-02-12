package service.wrapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("1 이상이면 true를 반환한다.")
    void continueRace(int input) {
        Round round = new Round(input);

        boolean result = round.isRacing();

        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("0 이라면 false를 반환한다.")
    void exitRace() {
        Round round = new Round(0);

        boolean result = round.isRacing();

        Assertions.assertThat(result).isFalse();
    }
}