package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

class RacingGameTest {

    private static final int TEST_GAME_ROUND = 3;

    private Car pobi;
    private Car neo;
    private Cars cars;
    private RacingGame racingGame;

    @Test
    @BeforeEach
    void beforeTest() {
        pobi = new Car("pobi", new TestNumberGenerator(new ArrayList<>(List.of(3, 4, 5))));
        neo = new Car("neo", new TestNumberGenerator(new ArrayList<>(List.of(3, 4, 5))));
        cars = new Cars(new ArrayList<>(List.of(pobi, neo)));

        racingGame = new RacingGame(cars, TEST_GAME_ROUND);
    }

    @Test
    @Disabled("Cars의 moveEachCar 기능만을 수행하므로 테스트 하지 않습니다.")
    void playOneRound() {
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:true"}, delimiter = ':')
    @DisplayName("입력된 round 수만큼 게임이 진행된 이후에 게임 종료 여부를 알 수 있어야 한다.")
    void isGameEnded(int inputRound, boolean result) {
        //Given
        for (int i = 0; i < inputRound; i++) {
            racingGame.playOneRound();
        }

        //When
        boolean isGameEnded = racingGame.isGameEnded();

        //Then
        assertThat(isGameEnded).isEqualTo(result);
    }

    @Test
    @Disabled("Cars의 findAllWinner 기능만을 수행하므로 테스트 하지 않습니다.")
    void findWinnerCars(){}

}
