package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;
import racingcar.domain.Lap;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingCarController 는 ")
class RacingCarControllerTest {

    private RacingCarController controller = new RacingCarController();

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
}