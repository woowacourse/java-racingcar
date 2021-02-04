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

    @BeforeEach
    void setUp(){
        racingGame = new RacingGame();
    }

    @DisplayName("주어진 이름대로 자동차 생성되는지 테스트")
    @Test
    void 자동차_생성되는지() {
        List<String> names = Arrays.asList("a","b","c");
        racingGame.makeCars(names);
        CarsResponseDto cars = racingGame.getCarsResponseDto();
        for (int i = 0; i < names.size(); i++) {
            assertThat(cars.getCarResponseDtoList().get(i).getName()).isEqualTo(names.get(i));
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
        Car testCar1 = new Car("똘이");
        Car testCar2 = new Car("멍이");
        Car testCar3 = new Car("순이");

        testCar1.move(4);
        testCar2.move(4);

        racingGame.addCar(testCar1);
        racingGame.addCar(testCar2);
        racingGame.addCar(testCar3);

        String result = racingGame.decideWinner();
        assertThat(result).isEqualTo("똘이, 멍이");
    }
}