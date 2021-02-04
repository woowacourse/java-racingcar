package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarsResponseDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {
    private RacingGame racingGame;
    private List<String> testCases = Arrays.asList("똘이","멍이","순이");
    @BeforeEach
    void setUp(){
        racingGame = new RacingGame(testCases);
    }

    @DisplayName("주어진 이름대로 자동차 생성되는지 테스트")
    @Test
    void 자동차_생성되는지() {
        CarsResponseDto cars = racingGame.getCarsResponseDto();
        for (int i = 0; i < testCases.size(); i++) {
            assertThat(cars.getCarResponseDtoList().get(i).getName()).isEqualTo(testCases.get(i));
        }
    }

    @DisplayName("라운드가 진행되는지 확인")
    @Test
    void 레이싱게임_라운드_진행(){
        int beforeRound = racingGame.getRound();
        racingGame.playRound();
        int afterRound = racingGame.getRound();

        assertThat(beforeRound + 1).isEqualTo(afterRound);
    }

    @DisplayName("우승자 확인 테스트")
    @Test
    void 우승자_확인_테스트(){

    }
}