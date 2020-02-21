package racingcargame.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @ParameterizedTest
    @DisplayName("위치값이 4,5,6,7,8,9일 때 오르는지")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carGo(int num) {
        Position position = new Position();
        int originalPosition = position.getNumber();
        position.decideGoOrStop(num);
        assertThat(position.getNumber()).isEqualTo(originalPosition + 1);
    }

    @ParameterizedTest
    @DisplayName("위치값이 0,1,2,3일 때 가만히 있는지")
    @ValueSource(ints = {0, 1, 2, 3})
    void carStop(int num) {
        Position position = new Position();
        int originalPosition = position.getNumber();
        position.decideGoOrStop(num);
        assertThat(position.getNumber()).isEqualTo(originalPosition);
    }
}
