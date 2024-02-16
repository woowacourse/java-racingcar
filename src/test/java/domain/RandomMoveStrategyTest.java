package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomMoveStrategyTest {

    @DisplayName("임의의 숫자가 3 이하인 경우에는 이동하지 않고, 4 이상인 경우에는 이동한다")
    @ParameterizedTest
    @CsvSource({"3, false", "4, true"})
    void moveRandomlyTest(int randomInt, boolean expected) {
        // given
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy(() -> randomInt);

        // when
        boolean actual = randomMoveStrategy.isMove();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}