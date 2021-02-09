package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.Round.INVALID_NUMBER_OF_ROUNDS_MESSAGE;

class RacingGameTest {
    private final List<String> carNamesForTest = Arrays.asList("포비", "데이브", "삭정");

    @DisplayName("올바른 이름이 주어졌을 때 이를 토대로 racingGame 과 그 안에 자동차를 생성하는 지 테스트")
    @Test
    void racingGameConstructor_givenCarNames_createCarsByGivenCarNames() {
        RacingGame racingGame = createRacingGame();

        assertThat(racingGame).isEqualTo(createRacingGame());
        assertThat(racingGame.getCars()).isEqualTo(new Cars(carNamesForTest));
    }

    @DisplayName("음수인 라운드 횟수가 입력됐을 떄 에러 반환 하는지")
    @Test
    void racingGameConstructor_NonPositiveIntegerNumberOfRounds_ThrowException() {
        assertThatThrownBy(() -> createRacingGame("-1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_OF_ROUNDS_MESSAGE);
    }

    @DisplayName("라운드가 진행되는지 확인")
    @Test
    void playAnotherRound_playRoundOnce_currentRoundShouldIncreaseByOne() {
        RacingGame racingGame = createRacingGame();

        int beforeRound = racingGame.getCurrentRoundAsInt();
        racingGame.playAnotherRound();
        int afterRound = racingGame.getCurrentRoundAsInt();

        assertThat(beforeRound + 1).isEqualTo(afterRound);
    }

    @DisplayName("라운드 횟수에 맞게 총 경기가 수행되는지")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3"})
    void isFinished_numberOfRounds_true(String numberOfRounds) {
        RacingGame racingGame = createRacingGame(numberOfRounds);

        for (int currentRound = 0; currentRound < racingGame.getNumberOfRoundsAsInt(); currentRound++) {
            racingGame.playAnotherRound();
        }

        assertThat(racingGame.isFinished()).isTrue();
    }

    private RacingGame createRacingGame() {
        Cars cars = new Cars(carNamesForTest);
        String numberOfRoundsForTest = "5";
        return new RacingGame(cars, new Round(numberOfRoundsForTest));
    }

    private RacingGame createRacingGame(String numberOfRounds) {
        Cars cars = new Cars(carNamesForTest);
        return new RacingGame(cars, new Round(numberOfRounds));
    }
}