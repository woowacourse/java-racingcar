package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.car.Cars;
import racinggame.domain.car.generatenumber.GenerateNumberService;
import racinggame.domain.car.generatenumber.GenerateRandomNumber;
import racinggame.domain.data.Names;
import racinggame.domain.data.GameStatus;
import racinggame.domain.car.Car;
import racinggame.domain.data.Repeat;
import racinggame.domain.game.RacingGame;

public class RacingGameTest {
    private Cars cars = new Cars(new GenerateTestNumber());
    private GameStatus gameStatus;

    @ParameterizedTest
    @CsvSource(value = {"pobi,true", "kim,false"})
    void 이동_테스트(String name, boolean expected) {
        gameStatus = new GameStatus(new Names("pobi,kim").splitNamesByComma());
        cars.add(new Car("pobi", 0));
        cars.moveCars(gameStatus);
        cars.add(new Car("kim", 0));
        cars.moveCars(gameStatus);
        cars.moveCars(gameStatus);
        gameStatus.makeWinnerNames();
        //boolean result = cars.get(0).match(position);
        boolean result = gameStatus.isContainName(name);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @RepeatedTest(value = 50)
    void 랜덤_테스트() {
        GenerateNumberService generateNumberService = new GenerateRandomNumber();
        int result = generateNumberService.generateNumber(10);

        Assertions.assertThat(result).isBetween(0, 9);
    }

    @RepeatedTest(value = 100)
    void 레이싱게임_실행_결과_테스트() {
        Names names = new Names("pobi,crong,honux");
        Repeat repeat = new Repeat("5");
        gameStatus = new GameStatus(names.splitNamesByComma());
        RacingGame racingGame = new RacingGame(names, new GenerateTestNumber());
        for (int repeatIterator = 0; repeat.isLoopDone(repeatIterator); repeatIterator++) {
            racingGame.moveCars(gameStatus);
        }
        gameStatus.makeWinnerNames();
        /**
         * 임의로 모든 차가 전진만 100% 하도록 인터페이스를 변경하여 생성하였다.
         * 그렇기 떄문에, 실제 이 게임의 경우 세 플레이어 모두 전진하여, 셋 모두 우승자임이 분명해진다.
         */
        Assertions.assertThat(gameStatus.isContainName("pobi")).isTrue();
        Assertions.assertThat(gameStatus.isContainName("crong")).isTrue();
        Assertions.assertThat(gameStatus.isContainName("honux")).isTrue();

    }
}
