package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("WinnerJudge 는 ")
class WinnerJudgeTest {

    private final WinnerJudge winnerJudge = new WinnerJudge();

    @Nested
    @DisplayName("성공 테스트")
    class SuccessTest {

        @ParameterizedTest(name = "judge() 호출 시 우승한 자동차를 반환한다.")
        @MethodSource("racingcar.domain.CarsTest#carsAndWinnerCars")
        void test_judge_1(final Cars cars, final List<Car> actualWinnerCars) {
            // when
            List<Car> winners = winnerJudge.judge(cars);

            // then
            assertThat(winners).containsExactlyInAnyOrderElementsOf(actualWinnerCars);
        }
    }
}
