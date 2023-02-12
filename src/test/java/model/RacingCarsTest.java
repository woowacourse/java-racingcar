package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.NumberGenerator;

class RacingCarsTest {

    static class TestMoveNumberGenerator implements NumberGenerator {

        @Override
        public int generateNumber(int maxNumber) {
            return 4;
        }
    }

    static class TestNotMoveNumberGenerator implements NumberGenerator {

        @Override
        public int generateNumber(int maxNumber) {
            return 3;
        }
    }

    @Test
    @DisplayName("차 이름이 중복되면 예외가 발생한다")
    void createDuplicateCars() {
        //given
        Car car1 = new Car("car");
        Car car2 = new Car("car");

        //when
        //then
        assertThatThrownBy(() -> new RacingCars(List.of(car1, car2)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.CAR_NAME_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("차 이름이 중복되지 않는 경우")
    void createNonDuplicateCars() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        //when
        new RacingCars(List.of(car1, car2));
        //then
    }

    @Test
    @DisplayName("차 개수가 100개 초과인 경우 예외가 발생한다")
    void validateCarCountOverLimit() {
        //given
        int carLimit = 100;
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i <= carLimit; i++) {
            cars.add(new Car(String.valueOf(i)));
        }

        //when
        //then
        assertThatThrownBy(() -> new RacingCars(cars))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(String.format(ErrorCode.TOO_MANY_CAR.getMessage(), carLimit));
    }

    @Test
    @DisplayName("모든 차를 이동시킨다")
    void moveCars() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        RacingCars racingCars = new RacingCars(List.of(car1, car2));

        //when
        racingCars.move(new TestMoveNumberGenerator(), 10);

        //then
        for (Integer raceResult : racingCars.getCurrentPositions().values()) {
            assertThat(raceResult).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("모든 차를 이동시키지 않는다.")
    void notMoveCars() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        RacingCars racingCars = new RacingCars(List.of(car1, car2));

        //when
        racingCars.move(new TestNotMoveNumberGenerator(), 10);

        //then
        for (Integer raceResult : racingCars.getCurrentPositions().values()) {
            assertThat(raceResult).isEqualTo(1);
        }
    }

}