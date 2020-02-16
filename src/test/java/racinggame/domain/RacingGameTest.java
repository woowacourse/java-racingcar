package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.data.Names;
import racinggame.domain.data.GameStatus;
import racinggame.domain.car.Car;
import racinggame.domain.data.Repeat;
import racinggame.domain.game.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {
    private List<Car> carList = new ArrayList<>();
    Names names;
    Repeat repeat;
    GameStatus gameStatus;
    private final String NAMES = "pobi,crong,honux";
    private final String REPEAT = "5";

    void initList() {
        carList.add(new Car("pobi", 0));
        carList.add(new Car("kim", 0));
        carList.add(new Car("park", 0));

        carList.get(0).accelerate(4, 4);
        carList.get(0).accelerate(4, 4);
        carList.get(0).accelerate(4, 4);

        carList.get(1).accelerate(4, 4);
        carList.get(1).accelerate(4, 4);
        carList.get(1).accelerate(4, 4);

        carList.get(2).accelerate(4, 4);
        carList.get(2).accelerate(2, 4);
        carList.get(2).accelerate(1, 4);
    }

    @BeforeEach
    void initInput() {
        names = new Names(NAMES);
        repeat = new Repeat(REPEAT);
        gameStatus = new GameStatus(names.splitNamesByComma());
    }

    @ParameterizedTest
    @CsvSource(value = {"3,true", "2,false"})
    void 이동_테스트(int position, boolean expected) {
        initList();
        boolean result = carList.get(0).match(position);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @RepeatedTest(value = 50)
    void 랜덤_테스트() {
        int result = RacingGame.generateRandomNumber();

        Assertions.assertThat(result).isBetween(0, 9);
    }

    @Test
    void 우승자_확인_테스트() {
        initList();
        for(Car car : carList){
            car.passingLog(gameStatus);
        }
        gameStatus.makeWinnerNames();
        boolean chkWinner = gameStatus.isContainName("pobi");
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = gameStatus.isContainName("kim");
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = gameStatus.isContainName("park");
        Assertions.assertThat(chkWinner).isEqualTo(false);
    }

    @RepeatedTest(value = 100)
    void 레이싱게임_실행_결과_테스트() {
        for(int repeatIterator = 0; repeat.isLoopDone(repeatIterator); repeatIterator++){
            RacingGame.moveCars(gameStatus, carList);
        }
        gameStatus.makeWinnerNames();
        boolean result1 = gameStatus.isContainName("pobi");
        boolean result2 = gameStatus.isContainName("crong");
        boolean result3 = gameStatus.isContainName("honux");

        Assertions.assertThat(result1 || result2 || result3).isTrue();
    }
}
