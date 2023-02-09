package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.CarMovement;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    @DisplayName("자동차 이동 테스트")
    public void carMoveTest(int moveValue, int position) {
        CarMovement carMovement = new CarMovement(moveValue);
        Car car = new Car("푸우");
        car.move(carMovement);
        assertThat(car).extracting("pos").extracting("value").isEqualTo(position);
    }
}
