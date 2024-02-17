package racingcar.domain.movestrategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarMoveStrategyTest {

    @DisplayName("받은 숫자가 3 이하인 경우에는 이동하지 않고, 4 이상인 경우에는 이동한다")
    @ParameterizedTest
    @CsvSource({"3, false", "4, true"})
    void isMoveTest(final int digit, final boolean expected) {
        final CarMoveStrategy carMoveStrategy = new CarMoveStrategy(() -> digit);

        final boolean actual = carMoveStrategy.isMove();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
