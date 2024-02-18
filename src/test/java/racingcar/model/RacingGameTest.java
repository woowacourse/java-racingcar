package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private TryCount tryCount;
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = getCars();
        tryCount = new TryCount(3);
    }

    private static Cars getCars() {
        List<String> carNames = List.of("a", "b", "c");
        return carNames.stream()
                .map(CarName::new)
                .map(Car::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));
    }

    @DisplayName("게임 횟수 만큼 게임을 실행한다.")
    @Test
    void runGameByCount() {
        //given
        RacingGame racingGame = new RacingGame(tryCount, cars, new RandomNumberGenerator());

        //when
        TotalResult totalResult = racingGame.run();

        //then
        assertThat(totalResult.getTotalResult()).hasSize(tryCount.getCount());
    }
}
