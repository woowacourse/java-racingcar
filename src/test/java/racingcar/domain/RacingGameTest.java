package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static constants.TestConstants.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private final Cars cars = new Cars();
    private RacingGame racingGame;

    private final int TOTAL_ROUNDS = 5;

    @BeforeEach
    void beforeEach() {
        cars.clear();
        racingGame = new RacingGame(new String[]{"pobi", "jeong", "roma"}, TOTAL_ROUNDS);
    }

    @DisplayName("getWinners 메서드는 가장 position 값이 큰 car 객체들을 반환한다")
    @Test
    void getWinners() {
        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            racingGame.playRound();
        }

        List<Car> winners = racingGame.getWinners();
        int maxPosition = winners.get(0).getPosition();

        for (Car car : racingGame.getCars()) {
            assertThat(car.getPosition()).isLessThanOrEqualTo(maxPosition);
        }
    }

    @DisplayName("isOver 메서드는 totalRounds와 currentRounds의 일치 여부를 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"4,false", "5,true"}, delimiter = ',')
    void isOver(String roundNumString, String resultString) {
        int roundNum = Integer.parseInt(roundNumString);
        boolean result = Boolean.parseBoolean(resultString);

        for (int i = 0; i < roundNum; i++) {
            racingGame.playRound();
        }

        assertThat(racingGame.isOver()).isEqualTo(result);
    }
}
