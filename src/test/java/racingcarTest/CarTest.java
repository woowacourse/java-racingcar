package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"4,1", "5,1", "3,0"}, delimiter = ',')
    @DisplayName("4이상_전진_4미만_정지")
    void num_Over4_carGoForward(int number, int expectedPosition) {
        Car testCar = new Car("test");

        testCar.goForward(number);
        assertThat(testCar.getPosition()).isEqualTo(expectedPosition);
    }
}
