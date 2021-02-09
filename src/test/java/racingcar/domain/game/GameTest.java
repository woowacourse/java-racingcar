package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private Game testingGame = new Game(0);

    @ParameterizedTest
    @CsvSource(value = {"1:1:false", "2:1:true"}, delimiter = ':')
    @DisplayName("최종 횟수에 count가 도달 했을때, 하지 못했을 때 테스트")
    void notFinished(final int round, final int count, final boolean result) {
        testingGame = new Game(round);
        for (int i = 0; i < count; i++) {
            testingGame.incrementCount();
        }
        assertEquals(testingGame.notFinished(), result);
    }

    @Test
    @DisplayName("형태에 맞게 우승자들의 이름이 나오는지 테스트")
    void joinWinnerNames() {
        List<Car> winners = new ArrayList<>();
        winners.add(new Car("java"));
        winners.add(new Car("html"));
        assertEquals(testingGame.joinWinnerNames(winners), "java, html");
    }
}