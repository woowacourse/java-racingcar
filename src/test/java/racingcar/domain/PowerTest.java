package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerTest {
    @ParameterizedTest
    @CsvSource({"0, false", "3, false", "4, true", "9, true"})
    @DisplayName("자동차가 주어진 값에 따라 움직이는지 확인")
    void canMoveTest(int goOrStopNumber, boolean status) {
        Power power = new Power();
        assertThat(power.canMove(goOrStopNumber)).isEqualTo(status);
    }
}
