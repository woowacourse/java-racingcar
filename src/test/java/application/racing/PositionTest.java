package application.racing;

import application.racing.domain.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionTest {
    @DisplayName("입력값에 따라서 위치가 변하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "3,0", "4,1", "9,1"}, delimiter = ',')
    public void positionMoveValidNumberTest(String input, String expected) {
        Position position = new Position();

        position.move(Integer.parseInt(input));
        Assertions.assertThat(position.getPosition()).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("equals 메소드 오버라이드 테스트")
    @Test
    public void positionEqualsTest() {
        Position input = new Position();

        Position expected = new Position();

        Assertions.assertThat(input).isEqualTo(expected);
    }
}
