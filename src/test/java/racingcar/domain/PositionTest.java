package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Position;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    @DisplayName("차의 위치 저장 테스트")
    public void savePositionTest() {
        Position position = Position.valueOf(10);

        assertThat(position).isEqualTo(Position.valueOf(10));
    }

    @ParameterizedTest
    @CsvSource({"3, 0", "4, 1"})
    public void movePositionTest(int value, int result) {
        //given
        Position position = Position.valueOf(0);

        //when
        position.move(value);

        //then
        assertThat(position).isEqualTo(Position.valueOf(result));
    }

    @Test
    @DisplayName("매개변수와 value를 비교해서 더 큰값을 반환해준다.")
    public void getMaxNumberTest() {
        //given
        Position position1 = Position.valueOf(1);
        Position position2 = Position.valueOf(10);

        //when
        int result = position1.getMaxValue(position2);

        //then
        assertThat(result).isEqualTo(10);
    }
}
