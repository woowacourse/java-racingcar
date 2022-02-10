package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    public void 자동차_전진(int randomNumber) {
        Car car = Car.from("pobi");
        int prevPosition = car.getPosition();
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(prevPosition + 1);
    }
}
