package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"5,1", "4,1", "3,0"}, delimiter = ',')
    @DisplayName("4를_넘는_값에_전진_미만은_정지")
    void num_Over4_carGoForward(int random, int expectedPosition) {
        Car testCar = new Car("test");

        testCar.goForward(random);
        assertThat(testCar.getPosition()).isEqualTo(expectedPosition);
    }
}
