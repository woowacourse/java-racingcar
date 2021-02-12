package racingcar.domain.car.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomMoveStrategyTest {

    @DisplayName("이동 불가능 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void unableToMovable(int value) {
        Assertions.assertThat(new RandomMoveStrategy().isMovable(value)).isFalse();
    }

    @DisplayName("이동 가능 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void movable(int value) {
        Assertions.assertThat(new RandomMoveStrategy().isMovable(value)).isTrue();
    }
}