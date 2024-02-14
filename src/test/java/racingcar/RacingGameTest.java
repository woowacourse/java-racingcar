package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    @DisplayName("이동 횟수가 1 미만 또는 숫자가 아닌 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "asd", ""})
    void exceptionInvalidCountInput(String given) {
        //given
        String carNames = "a,b,c";

        //when
        Cars cars = new Cars(carNames);

        //then
        Assertions.assertThatThrownBy(() -> new RacingGame(given, cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

}