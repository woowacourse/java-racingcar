package racing.domain;

import static racing.domain.Cars.CAR_MOVE_THRESHOLD;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RacingTest {

    static Stream<Arguments> nextTurnParameters() {
        return Stream.of(
                Arguments.of(CAR_MOVE_THRESHOLD - 1, 0),
                Arguments.of(CAR_MOVE_THRESHOLD, 1)
        );
    }

    static Stream<Arguments> getWinnerNamesParameters() {
        return Stream.of(
                Arguments.of(new Cars(List.of(new Car(1, "a"))), List.of("a")),
                Arguments.of(new Cars(List.of(new Car(1, "a"), new Car(1, "b"))), List.of("a", "b"))
        );
    }

    @ParameterizedTest
    @DisplayName("다음 턴 동작 테스트")
    @MethodSource("nextTurnParameters")
    void nextTurn(int racingCondition, int expectedDistance) {
        Racing racing = new Racing(1, new Cars(List.of(new Car(0, "a"))));
        Map<String, Integer> carsStatus = racing.nextTurn(List.of(racingCondition));
        Assertions.assertThat(carsStatus.get("a"))
                .isEqualTo(expectedDistance);
    }

    @ParameterizedTest
    @DisplayName("우승자 테스트")
    @MethodSource("getWinnerNamesParameters")
    void getWinnerNames(Cars cars, List<String> expectedWinnerNames) {
        Racing racing = new Racing(1, cars);
        List<String> winnerNames = racing.getWinnerNames();
        Assertions.assertThat(winnerNames)
                .containsExactlyElementsOf(expectedWinnerNames);
    }

    @Test
    @DisplayName("최대 턴까지 실행한 이후 다음 턴을 호출한 경우 아무 변화가 없는지 확인")
    void nextTurnAfterMaxTurn() {
        Racing racing = new Racing(1, new Cars(List.of(new Car(0, "a"))));
        racing.nextTurn(List.of(CAR_MOVE_THRESHOLD));
        racing.nextTurn(List.of(CAR_MOVE_THRESHOLD));
        Map<String, Integer> carsStatus = racing.nextTurn(List.of(CAR_MOVE_THRESHOLD));
        Assertions.assertThat(carsStatus.get("a"))
                .isEqualTo(1);
    }
}