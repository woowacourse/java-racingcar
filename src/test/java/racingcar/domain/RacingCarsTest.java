package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름을 받아 자동차를 생성한다.")
    void createRacingCars() {
        RacingCars racingCars = new RacingCars("pobi,crong,honux", new RacingCarCommander());
        assertThat(racingCars.getCarNames()).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차 이름의 공백을 제거한다.")
    void trimBlank() {
        RacingCars racingCars = new RacingCars("pobi , cr ong , honux", new RacingCarCommander());
        assertThat(racingCars.getCarNames()).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차 우승자 이름을 계산한다.")
    void calculateWinnerNames() {
        RacingCars racingCars = new RacingCars("pobi,crong,honux", new RacingCarCommander());
        List<String> winnerNames = racingCars.searchWinnerNames();
        assertThat(winnerNames).containsExactly("pobi", "crong", "honux");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("자동차 입력 값이 존재하지 않으면 예외를 발생한다.")
    void checkCarNamesNullOrEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCars(input, new RacingCarCommander()))
            .withMessageMatching("자동차 입력 값이 존재해야한다.");
    }
}