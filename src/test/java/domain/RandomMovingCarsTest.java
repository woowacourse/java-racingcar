package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomMovingCarsTest {

    @DisplayName("경주에 참가한 자동차들에 대한 예외 발생 테스트")
    @Nested
    class RandomMovingCarsExceptionTest {
        @DisplayName("참가 자동차가 2대 미만 이라면 예외를 발생시킨다.")
        @Test
        void carsMinSizeExceptionTest() {
            assertThatThrownBy(() -> new RandomMovingCars(createRandomMovingCars(List.of("pobi"))))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("참가 자동차가 20대를 초과한다면 예외를 발생시킨다.")
        @Test
        void carsMaxSizeExceptionTest() {
            List<String> carNames = new ArrayList<>();
            for (int i = 65; i < 86; i++) {
                carNames.add("car" + (char) i);
            }
            assertThatThrownBy(() -> new RandomMovingCars(createRandomMovingCars(carNames)))
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
    class RandomMovingCarsSuccessTest {

        @DisplayName("2대의 자동차가 참여하는 것은 예외가 발생하지않는다.")
        @Test
        void CarsMinSizeSuccessTest() {
            assertThatCode(() -> new RandomMovingCars(createRandomMovingCars(List.of("pobi", "jun"))))
                    .doesNotThrowAnyException();
        }

        @DisplayName("20대의 자동차까지는 참가를 허용한다.")
        @Test
        void CarsMaxSizeSuccessTest() {
            List<String> carNames = new ArrayList<>();
            for (int i = 65; i < 85; i++) {
                carNames.add("car" + (char) i);
            }
            assertThatCode(() -> new RandomMovingCars(createRandomMovingCars(carNames)))
                    .doesNotThrowAnyException();
        }
    }

    private static List<RandomMovingCar> createRandomMovingCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new RandomMovingCar(Car.createOnStart(carName), () -> 0))
                .toList();
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
