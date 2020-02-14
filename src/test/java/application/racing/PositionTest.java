package application.racing;

import application.racing.domain.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {
    @DisplayName("입력값에 따라서 위치가 변하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "3,0", "4,1", "9,1"}, delimiter = ',')
    public void positionMoveValidNumberTest(String input, String expected) {
        Position position = new Position();

        position.move(Integer.parseInt(input));
        Assertions.assertThat(position.getPosition()).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("위치를 변경하는 경계값에 대한 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    public void positionMoveInvalidNumberTest(int number) {
        Position position = new Position();

        Assertions.assertThatThrownBy(() -> {
            position.move(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
