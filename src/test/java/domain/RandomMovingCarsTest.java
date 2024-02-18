package domain;

import domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomMovingCarsTest {
    private static final List<String> carNames = List.of(
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    @DisplayName("경주에 참가한 자동차들에 대한 예외 발생 테스트")
    @Nested
    class CarsExceptionTest {
        @DisplayName("참가 자동차가 2대 미만 이라면 예외를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 1})
        void carsMinCountExceptionTest(int carsCount) {
            assertThatThrownBy(() -> new RandomMovingCars(createRandomMovingCars(getCarNamesByCount(carsCount))))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("참가 자동차가 20대를 초과한다면 예외를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(ints = {21, 22, 23, 24, 25})
        void carsMaxCountExceptionTest(int carsCount) {
            assertThatThrownBy(() -> new RandomMovingCars(createRandomMovingCars(getCarNamesByCount(carsCount))))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("중복된 자동차 이름이 있으면 예외가 발생한다.")
        @Test
        void carNamesDuplicationExceptionTest() {
            assertThatThrownBy(() -> new RandomMovingCars(createRandomMovingCars(List.of("pobi", "pobi", "jun"))))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("경주에 참가한 자동차들에 대한 성공 테스트")
    @Nested
    class CarsSuccessTest {

        @DisplayName("2에서 20대의 자동차가 참여하면 예외가 발생하지않는다.")
        @ParameterizedTest
        @ValueSource(ints = {2, 3, 19, 20})
        void validCarsCountSuccessTest(int carsCount) {
            assertThatCode(() -> new RandomMovingCars(createRandomMovingCars(getCarNamesByCount(carsCount))))
                    .doesNotThrowAnyException();
        }
    }

    private static List<RandomMovingCar> createRandomMovingCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new RandomMovingCar(Car.createOnStart(carName), () -> 0))
                .toList();
    }

    private List<String> getCarNamesByCount(int count) {
        return carNames.subList(0, count);
    }

    @DisplayName("랜덤 값에 따른 자동차들의 움직임 테스트")
    @Nested
    class RandomMovingCarsMoveTest {
        @DisplayName("랜덤한 숫자가 0에서 3 사이의 숫자라면 자동차들은 움직이지 않는다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3})
        void carsStopTest(int number) {
            // given
            Car pobi = Car.createOnStart("pobi");
            Car jun = Car.createOnStart("jun");

            RandomMovingCars randomMovingCars = new RandomMovingCars(List.of(
                    new RandomMovingCar(pobi, () -> number),
                    new RandomMovingCar(jun, () -> number)
            ));

            // when
            randomMovingCars.moveAll();

            // then
            List<Integer> carPositions = randomMovingCars.getCars().stream()
                    .map(RandomMovingCar::getPosition)
                    .toList();
            assertThat(carPositions).containsExactly(0, 0);
        }

        @DisplayName("랜덤한 숫자가 4에서 9 사이의 숫자라면 자동차들은 1만큼 전진한다.")
        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        void carsMoveTest(int number) {
            // given
            Car pobi = Car.createOnStart("pobi");
            Car jun = Car.createOnStart("jun");

            RandomMovingCars randomMovingCars = new RandomMovingCars(List.of(
                    new RandomMovingCar(pobi, () -> number),
                    new RandomMovingCar(jun, () -> number)
            ));

            // when
            randomMovingCars.moveAll();

            // then
            List<Integer> carPositions = randomMovingCars.getCars().stream()
                    .map(RandomMovingCar::getPosition)
                    .toList();
            assertThat(carPositions).containsExactly(1, 1);
        }
    }
}
