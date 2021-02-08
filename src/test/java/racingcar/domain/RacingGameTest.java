package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.Car.INIT_POSITION;
import static racingcar.domain.RacingGame.UNAVAILABLE_NUMBER_OF_ROUNDS_MESSAGE;

class RacingGameTest {
    private static final int NUMBER_OF_ROUNDS_FOR_TEST = 5;

    private final List<String> carNamesForTest = Arrays.asList("포비", "데이브", "삭정");

    @DisplayName("올바른 이름이 주어졌을 때 이를 토대로 racingGame 과 자동차를 생성하는 지 테스트")
    @Test
    void racingGameConstructor_givenCarNames_createCarsByGivenCarNames() {
        RacingGame racingGame = createRacingGame();

        assertThat(racingGame).isInstanceOf(RacingGame.class);

        List<CarDto> carsDto = new CarsDto(racingGame.getCars()).getCarsDto();

        for (int i = 0; i < carNamesForTest.size(); i++) {
            assertThat(carsDto.get(i).getName()).isEqualTo(carNamesForTest.get(i));
            assertThat(carsDto.get(i).getPosition()).isEqualTo(INIT_POSITION);
        }
    }

    @DisplayName("음수나 0 인 라운드 횟수가 입력됐을 떄 에러 반환 하는지")
    @ParameterizedTest
    @ValueSource(ints = {0,-3})
    void racingGameConstructor_NonPositiveIntegerNumberOfRounds_ThrowException(int numberOfRounds) {
        Cars cars = new Cars(carNamesForTest);

        assertThatThrownBy(() -> new RacingGame(cars, numberOfRounds)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UNAVAILABLE_NUMBER_OF_ROUNDS_MESSAGE);
    }

    @DisplayName("라운드가 진행되는지 확인")
    @Test
    void playRound_playOneRound_currentRoundShouldIncreaseByOne() {
        RacingGame racingGame = createRacingGame();

        int beforeRound = racingGame.getCurrentRound();
        racingGame.playAnotherRound();
        int afterRound = racingGame.getCurrentRound();

        assertThat(beforeRound + 1).isEqualTo(afterRound);
    }

    @DisplayName("라운드 횟수에 맞게 경기가 수행되는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void isFinished_numberOfRounds_true(int numberOfRounds) {
        RacingGame racingGame = createRacingGame(numberOfRounds);

        for (int currentRound = 0; currentRound < numberOfRounds; currentRound++) {
            racingGame.playAnotherRound();
        }

        assertThat(racingGame.isFinished()).isTrue();
    }

    private RacingGame createRacingGame() {
        Cars cars = new Cars(carNamesForTest);
        return new RacingGame(cars, NUMBER_OF_ROUNDS_FOR_TEST);
    }

    private RacingGame createRacingGame(int numberOfRounds) {
        Cars cars = new Cars(carNamesForTest);
        return new RacingGame(cars, numberOfRounds);
    }
}