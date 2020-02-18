package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.car.Cars;
import racinggame.domain.data.Names;
import racinggame.domain.data.GameStatus;
import racinggame.domain.car.Car;
import racinggame.domain.data.Repeat;
import racinggame.domain.game.RacingGame;

import java.util.List;

public class RacingGameTest {
    private Cars cars = new Cars(new TestMovableStrategy());

    @ParameterizedTest
    @CsvSource(value = {"pobi,true", "kim,false"})
    void 이동_테스트(String name, boolean expected) {
        GameStatus gameStatus = new GameStatus(new Names("pobi,kim").splitNamesByComma());
        cars.add(new Car("pobi", 0));
        cars.moveCars(gameStatus);
        cars.add(new Car("kim", 0));
        cars.moveCars(gameStatus);
        cars.moveCars(gameStatus);
        gameStatus.makeWinnerNames();
        //boolean result = cars.get(0).match(position);
        boolean result = gameStatus.makeWinnerNames().contains(name);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @RepeatedTest(value = 100)
    void 레이싱게임_실행_결과_테스트() {
        Names names = new Names("pobi,crong,honux");
        Repeat repeat = new Repeat("5");
        RacingGame racingGame = new RacingGame(names, new TestMovableStrategy());
        for (int repeatIterator = 0; repeat.isLoopDone(repeatIterator); repeatIterator++) {
            racingGame.moveCars();
        }
        List<String> winners = racingGame.getWinners();
        /**
         * 임의로 모든 차가 전진만 100% 하도록 인터페이스를 변경하여 생성하였다.
         * 그렇기 떄문에, 실제 이 게임의 경우 세 플레이어 모두 전진하여, 셋 모두 우승자임이 분명해진다.
         */
        Assertions.assertThat(winners.contains("pobi")).isTrue();
        Assertions.assertThat(winners.contains("crong")).isTrue();
        Assertions.assertThat(winners.contains("honux")).isTrue();

    }
}
