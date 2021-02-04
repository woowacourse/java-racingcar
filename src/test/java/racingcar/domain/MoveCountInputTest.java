package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarMoveCountNonNumericException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class MoveCountInputTest {
    @ParameterizedTest
    @DisplayName("이동횟수가_숫자가_아닐_경우_예외")
    @ValueSource(strings = {"a","b", "|", "★"})
    public void 이동횟수가_숫자가_아닐_경우_예외(String input) {
        assertThatExceptionOfType(CarMoveCountNonNumericException.class)
                .isThrownBy(() -> new MoveCountInput(input))
                .withMessageContaining(new CarMoveCountNonNumericException().getMessage());
    }
}
