package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.MovingStub;

class RacingGameTest {

    @DisplayName("이동 횟수가 1 미만 숫자인 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10000"})
    void exceptionInvalidCountInput(int given) {
        //given
        List<String> carNames = List.of("a", "b", "c");
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();

        //when
        Cars cars = new Cars(carList, new MovingStub(List.of(4, 4, 3)));

        //then
        assertThatThrownBy(() -> new RacingGame(given, cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 횟수 만큼 게임을 실행한다.")
    @Test
    void runGameByCount() {
        //given
        int count = 3;
        List<String> carNames = List.of("a", "b", "c");
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();

        //when
        Cars cars = new Cars(carList, new MovingStub(List.of(4, 4, 3)));
        RacingGame racingGame = new RacingGame(count, cars);
        List<RoundResult> roundResults = racingGame.gameStart();

        //then
        assertThat(roundResults).hasSize(3);
    }
}