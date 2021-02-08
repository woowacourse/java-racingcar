package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarsDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {
    private static final int NUMBER_OF_ROUNDS = 5;

    private RacingGame racingGame;
    private final List<String> carNamesForTest = Arrays.asList("똘이","멍이","순이");

    @BeforeEach
    void setUp(){
        this.racingGame = new RacingGame(new Cars(carNamesForTest), NUMBER_OF_ROUNDS);
    }

    @DisplayName("주어진 이름대로 자동차 생성되는지 테스트")
    @Test
    void racingGameConstructor_givenCarNames_createCarsByGivenCarNames() {
        CarsDto cars = new CarsDto(racingGame.getCars());
        for (int i = 0; i < carNamesForTest.size(); i++) {
            assertThat(cars.getCarsDto().get(i).getName()).isEqualTo(carNamesForTest.get(i));
        }
    }

    @DisplayName("라운드가 진행되는지 확인")
    @Test
    void playRound_playOneRound_currentRoundShouldIncreaseByOne(){
        int beforeRound = racingGame.getCurrentRound();
        racingGame.playAnotherRound();
        int afterRound = racingGame.getCurrentRound();

        assertThat(beforeRound + 1).isEqualTo(afterRound);
    }
}