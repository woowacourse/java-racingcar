package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingCarController 는 ")
class RacingCarControllerTest {

    private RacingCarController controller = new RacingCarController(new MathNumberGenerator());

    @Nested
    @DisplayName("성공 테스트")
    class SuccessTest {

        @ParameterizedTest(name = "createCars() 시 자동차 이름들을 입력받아(ex: {arguments}) 자동차를 생성한다.")
        @MethodSource("racingcar.controller.RacingCarControllerTest#createCarSuccessParam")
        void success_test_1(final String carNames, final int size) {
            // when
            Cars cars = controller.createCars(carNames);

            // then
            assertThat(cars.getCars().size()).isEqualTo(size);
        }

        @ParameterizedTest(name = "confirmTotalLap() 시 숫자를 입력받아(ex: {arguments}) Lap을 생성한다.")
        @ValueSource(ints = {1, 2, 3, 4, 5})
        void success_test_2(final int totalLapInput) {
            // when
            Lap lap = controller.confirmTotalLap(totalLapInput);

            // then
            assertThat(lap.getTotalLap()).isEqualTo(totalLapInput);
        }

        @Test
        @DisplayName(
                "moveCars() 시 Cars와 Lap을 받으면 자동차를 랜덤값에 따라 움직이고 현재 바퀴수를 1만큼 증가시킨다."
        )
        void success_test_3_version_1() {
            // given
            int totalLapInput = 3;
            List<String> carNames = List.of("말랑", "채채");
            MoveMethodCalledCountStoreCars cars = new MoveMethodCalledCountStoreCars(carNames);
            Lap lap = new Lap(totalLapInput);
            int beforeCurrentLap = lap.getCurrentLap();

            // when
            controller.moveCars(cars, lap);

            // then
            assertThat(cars.getCallCount()).isEqualTo(1);
            assertThat(lap.getCurrentLap()).isEqualTo(beforeCurrentLap + 1);
        }

        /**
         * success_test_3_version_1 과
         * (cars.moveCars()의 호출 여부만을 검증,
         * cars.moveCars()는 Cars 테스트를 통해 정상동작함을 확인할 수 있기 때문에 이곳에서는 호출만을 검증한다.)
         * <p>
         * success_test_3_version_2(전체 동작이 잘 이루어지는지 검증)
         * <p>
         * 의 방법 중 어떤 것이 더 좋다고 생각하시나요?
         */
        @Test
        @DisplayName(
                "moveCars() 시 Cars와 Lap을 받으면 자동차를 랜덤값에 따라 움직이고 현재 바퀴수를 1만큼 증가시킨다."
        )
        void success_test_3_version_2() {
            // given
            int totalLapInput = 3;
            List<String> carNames = List.of("말랑", "채채");
            Cars cars = new Cars(carNames);
            Lap lap = new Lap(totalLapInput);
            RacingCarController controller = new RacingCarController(
                    new MockFixedNumberGenerator(4));
            List<Position> beforeMovePositions =
                    cars.getCars().stream().map(Car::getPosition).collect(Collectors.toList());
            int beforeCurrentLap = lap.getCurrentLap();

            // when
            controller.moveCars(cars, lap);

            // then
            List<Position> afterMovePositions =
                    cars.getCars().stream().map(Car::getPosition).collect(Collectors.toList());

            for (int i = 0; i < beforeMovePositions.size(); i++) {
                assertThat(afterMovePositions.get(i).getValue())
                        .isEqualTo(beforeMovePositions.get(i).getValue() + 1);
            }
            assertThat(lap.getCurrentLap()).isEqualTo(beforeCurrentLap + 1);
        }

        @Test
        @DisplayName("winners() 호출 시 우승한 자동차의 이름을 반환한다.")
        void success_test_4() {
            // given
            Car winner1 = new Car("말랑");
            Car winner2 = new Car("채채");
            Car nonWinner1 = new Car("시카");
            Car nonWinner2 = new Car("헤나");
            winner1.move(4);
            winner1.move(4);

            winner2.move(4);
            winner2.move(4);

            nonWinner1.move(4);

            List<Car> movedCars = List.of(winner1, winner2, nonWinner1, nonWinner2);
            Cars cars = WinnerCarsHelper.withWinnerCars(movedCars);

            // when
            List<String> winnerNames = controller.winners(cars);

            // then
            assertThat(winnerNames).containsExactlyInAnyOrder(winner1.getName().getName(), winner2.getName().getName());
        }
    }

    @Nested
    @DisplayName("실패 테스트")
    class FailTest {

        @ParameterizedTest(name = "createCars() 시 자동차 이름이 1개 이하이면(ex: {arguments}) 예외가 발생한다.")
        @MethodSource("racingcar.controller.RacingCarControllerTest#createCarFailParam")
        void fail_test_1(final String carNames) {
            // when & then
            Assertions.assertThatThrownBy(
                    () -> controller.createCars(carNames)
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> createCarSuccessParam() {
        return Stream.of(
                Arguments.of("말랑,채채,시카", 3),
                Arguments.of("말랑,채채,", 2)
        );
    }

    static Stream<Arguments> createCarFailParam() {
        return Stream.of(
                Arguments.of("말랑"),
                Arguments.of("채채,"),
                Arguments.of(""),
                Arguments.of(" ")
        );
    }

    static class MoveMethodCalledCountStoreCars extends Cars {

        private int count = 0;

        public MoveMethodCalledCountStoreCars(List<String> cars) {
            super(cars);
        }

        @Override
        public void move(NumberGenerator generator) {
            super.move(generator);
            count++;
        }

        public int getCallCount() {
            return count;
        }
    }
}