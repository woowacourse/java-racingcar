package racingcar.domain.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarNamesInput;
import racingcar.exception.CarNameDuplicateException;
import racingcar.exception.MoveConditionOutOfBoundException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MoveConditionTest {

    @ParameterizedTest
    @ValueSource(ints = {10,11,12})
    @DisplayName("전진조건이 0-9사이 값이 아닌 경우 예외")
    public void 전진조건이_0_9_사이의_값이_아닌_경우_예외(int condition) {
        assertThatExceptionOfType(MoveConditionOutOfBoundException.class)
                .isThrownBy(() -> MoveCondition.isMovable())
                .withMessageContaining(new CarNameDuplicateException().getMessage());

    }

}
