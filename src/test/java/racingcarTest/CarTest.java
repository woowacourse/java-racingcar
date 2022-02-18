package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"}, delimiter = ',')
    @DisplayName("true에_전진_false에_정지")
    void num_Over4_carGoForward(boolean move, int expectedPosition) {
        Car testCar = new Car("test");

        testCar.goForward(move);
        assertThat(testCar.getPosition()).isEqualTo(expectedPosition);
    }
}
