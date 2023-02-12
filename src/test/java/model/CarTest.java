package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.model.CarMovement;

import java.util.List;

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

    @Test
    @DisplayName("자동차 비교 테스트")
    void carCompareTest() {
        Car 에코 = new Car("에코");
        Car 푸우 = new Car("푸우");

        List<Car> cars = List.of(에코, 푸우);
        에코.move(new CarMovement(4));

        assertThat(에코.compareTo(푸우)).isEqualTo(1);
    }
}
