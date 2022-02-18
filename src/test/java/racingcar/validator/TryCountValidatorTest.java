package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.model.RacingGame;

@SuppressWarnings("NonAsciiCharacters")
public class TryCountValidatorTest {

    String[] cars = {"짱구"};

    @ParameterizedTest
    @CsvSource(value = {
        "a,[ERROR] 숫자를 입력해 주세요.",
        ",[ERROR] 숫자를 입력해 주세요.",
        "-1,[ERROR] 시도 횟수는 양수만 가능합니다."
    })
    void 시도횟수_검증(String value, String message) {
        assertThatThrownBy(() -> new RacingGame(cars, value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
    }
}
