package racingcar.domain;

import static constants.TestConstants.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingGameTest {

    @DisplayName("isOver 메서드는 totalRounds와 currentRounds의 일치 여부를 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"4,false", "5,true"}, delimiter = ',')
    void isOver(String roundNumString, String resultString) {
        int totalRounds = 5;
        RacingGame racingGame = new RacingGame(new String[]{"pobi", "jeong", "roma"}, totalRounds,
                new RandomMoveStrategy());
        int roundNum = Integer.parseInt(roundNumString);
        boolean result = Boolean.parseBoolean(resultString);

        for (int i = 0; i < roundNum; i++) {
            racingGame.playRound();
        }

        assertThat(racingGame.isOver()).isEqualTo(result);
    }
}
