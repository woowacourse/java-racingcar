package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.CarStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("Cars 도메인에 대한 테스트")
class RacingCarsTest {
    private static Stream<Arguments> provideListOfCars() {
        return Stream.of(
                Arguments.of(List.of(new Car("pobi", 0))),
                Arguments.of(Collections.EMPTY_LIST)
        );
    }

    private static Stream<Arguments> provideAllSamePositionedCars_And_Winners() {
        return Stream.of(
                Arguments.of(List.of(new Car("pobi", 0), new Car("crong", 0),
                                new Car("honux", 0)),
                        List.of("pobi", "crong", "honux")),
                Arguments.of(List.of(new Car("pobi", 5), new Car("crong", 5),
                                new Car("honux", 5)),
                        List.of("pobi", "crong", "honux"))
        );
    }

    private static Stream<Arguments> provideFewMaxPositionedCars_And_Winners() {
        return Stream.of(
                Arguments.of(List.of(new Car("pobi", 0), new Car("crong", 5),
                                new Car("honux", 5)),
                        List.of("crong", "honux")),
                Arguments.of(List.of(new Car("pobi", 5), new Car("crong", 3),
                                new Car("honux", 5)),
                        List.of("pobi", "honux"))
        );
    }

    private static Stream<Arguments> provideOneMaxPositionedCars_And_Winners() {
        return Stream.of(
                Arguments.of(List.of(new Car("pobi", 15), new Car("crong", 5),
                                new Car("honux", 1)),
                        List.of("pobi")),
                Arguments.of(List.of(new Car("pobi", 3), new Car("crong", 3),
                                new Car("honux", 7)),
                        List.of("honux"))
        );
    }

    @Nested
    @DisplayName("Cars 생성에 대한 테스트")
    class CarsInitializerTest {

        @DisplayName("자동차 개수가 2대 미만인 경우 예외가 발생한다.")
        @ParameterizedTest
        @MethodSource("racingcar.domain.RacingCarsTest#provideListOfCars")
        void carCountTest(List<Car> cars) {
            assertThatThrownBy(() -> new RacingCars(cars))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 수는 2대 이상이어야 합니다.");
        }

    }

    @Nested
    @DisplayName("Cars 이동에 대한 테스트")
    class CarsRaceTest {
        private final List<Car> createdCars = List.of(new Car("pobi", 0),
                new Car("crong", 0), new Car("honux", 0));
        private final RacingCars cars = new RacingCars(createdCars);

        @BeforeEach
        void setup() {
            cars.moveCars(new TestNumberGenerator(5));
        }

        @DisplayName("모든 자동차가 이동하는지 확인한다.")
        @Test
        void moveCars() {
            for (Car car : createdCars) {
                assertThat(car.checkCurrentStatus().getCurrentPosition())
                        .isEqualTo(1);
            }
        }

        @DisplayName("Cars 이동 결과에 대한 테스트")
        @Test
        void showRaceResult() {
            List<String> carNames = List.of("pobi", "crong", "honux");
            List<CarStatus> raceResult = cars.showRaceResult();

            assertThat(raceResult.stream()
                    .map(CarStatus::getName)
                    .collect(Collectors.toUnmodifiableList())).isEqualTo(carNames);

            assertThat(raceResult.stream()
                    .allMatch(carStatus -> carStatus.getCurrentPosition() == 1))
                    .isTrue();

        }

    }

    @Nested
    @DisplayName("Cars 우승자 판별에 대한 테스트")
    class pickWinnersTest {

        @DisplayName("모두의 위치가 같은 경우 모두가 우승자가 된다")
        @ParameterizedTest
        @MethodSource("racingcar.domain.RacingCarsTest#provideAllSamePositionedCars_And_Winners")
        void allCarsAreWinners(List<Car> allSamePositionedCars, List<String> winners) {
            RacingCars cars = new RacingCars(allSamePositionedCars);

            assertThat(cars.pickWinnerCarsName())
                    .isEqualTo(winners);
        }

        @DisplayName("가장 멀리간 자동차가 두 대 이상일 경우 가장 멀리 간 모두가 우승자가 된다")
        @ParameterizedTest
        @MethodSource("racingcar.domain.RacingCarsTest#provideFewMaxPositionedCars_And_Winners")
        void aFewCarsAreWinners(List<Car> fewMaxPositionedCars, List<String> winners) {
            RacingCars cars = new RacingCars(fewMaxPositionedCars);

            assertThat(cars.pickWinnerCarsName().equals(winners))
                    .isTrue();
        }

        @DisplayName("가장 멀리간 자동차가 한 대인 경우 가장 멀리 간 한 대의 자동차가 우승자가 된다")
        @ParameterizedTest
        @MethodSource("racingcar.domain.RacingCarsTest#provideOneMaxPositionedCars_And_Winners")
        void oneCarIsWinner(List<Car> oneMaxPositionedCars, List<String> winners) {
            RacingCars cars = new RacingCars(oneMaxPositionedCars);

            assertThat(cars.pickWinnerCarsName().equals(winners))
                    .isTrue();
        }
    }

}
