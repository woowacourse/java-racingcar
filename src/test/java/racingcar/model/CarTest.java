package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"testException,0", "name,-1", "good,-20"})
    public void Car_생성자_예외_테스트(String carName, int carDistance) {
        assertThatThrownBy(() -> new Car(carName, carDistance))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void Car_move_작동_테스트_랜덤_숫자가_4이상일때(int number) {
        int priorPosition = 10;
        Car car = new Car("test", priorPosition);
        car.move(number);
        assertThat(car.getDistance() - priorPosition).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void Car_move_작동_테스트_랜덤_숫자가_4미만일때(int number) {
        int priorPosition = 10;
        Car car = new Car("test", priorPosition);
        car.move(number);
        assertThat(car.getDistance() - priorPosition).isEqualTo(0);
    }

    @Test
    public void Car_isWinner_테스트() {
        Car firstPlaceCar = new Car("1등", 10);
        Car secondPlaceCar = new Car("2등", 7);
        Car thirdPlaceCar = new Car("3등", 5);
        Distance maxDistance = new Distance(10);
        assertThat(firstPlaceCar.isWinner(maxDistance)).isTrue();
        assertThat(secondPlaceCar.isWinner(maxDistance)).isFalse();
        assertThat(thirdPlaceCar.isWinner(maxDistance)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"joel", "pobi", "crong"})
    public void Car_getName_테스트(String carName) {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @CsvSource(value = {"test1,0", "test2,3", "test3,10"})
    public void Car_getName_테스트(String carName, int carDistance) {
        Car car = new Car(carName, carDistance);
        assertThat(car.getDistance()).isEqualTo(carDistance);
    }
}