package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.round.Round;
import racingcar.exception.WrongArgumentException;

class RoundTest {

    @DisplayName("실행횟수는 양수여야 한다")
    @ParameterizedTest()
    @ValueSource(ints = {-3, -2, -1, 0})
    void roundNotPositiveExceptionTest(int number) {
        assertThrows(WrongArgumentException.class, () -> new Round(number));
    }

    @DisplayName("생성자 기능 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 10, 20})
    void constructorTest(int number) {
        assertDoesNotThrow(() -> new Round(number));
    }

}
