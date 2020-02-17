import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racinggame.domain.*;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {
    private static final List<Car> carList = new ArrayList<>();
    private static final int WINNER_POSITION = 3;
    private final String NAMES = "pobi,crong,honux";
    private Names names = new Names(NAMES);

    void initList() {
        carList.clear();
        carList.add(new Car("pobi", 0));
        carList.add(new Car("kim", 0));
        carList.add(new Car("park", 0));

        carList.get(0).move(4);
        carList.get(0).move(4);
        carList.get(0).move(4);

        carList.get(1).move(4);
        carList.get(1).move(4);
        carList.get(1).move(4);

        carList.get(2).move(4);
        carList.get(2).move(2);
        carList.get(2).move(1);
    }

    @Test
    void moveCarsOnlyTrueTest() {
        int maxPosition = 0;
        Cars cars = new Cars(names);
        Strategy racingGame = new MoveCarsOnlyTrue();

        for (int i = 1; i <= 10; i++) {
            Assertions.assertThat(racingGame.moveCars(cars, maxPosition)).isEqualTo(i);
        }
    }

    @Test
    void moveCarsOnlyFalseTest() {
        int maxPosition = 0;
        Cars cars = new Cars(names);
        Strategy racingGame = new MoveCarsOnlyFalse();

        for (int i = 1; i <= 10; i++) {
            Assertions.assertThat(racingGame.moveCars(cars, maxPosition)).isEqualTo(0);
        }
    }


    @RepeatedTest(value = 50)
    void 랜덤_테스트() {
        int result = RacingGame.generateRandom();

        Assertions.assertThat(result).isBetween(0, 9);
    }

    @Test
    void 우승자_확인_테스트() {
        initList();
        boolean chkWinner = carList.get(0).isSamePosition(WINNER_POSITION);
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = carList.get(1).isSamePosition(WINNER_POSITION);
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = carList.get(2).isSamePosition(WINNER_POSITION);
        Assertions.assertThat(chkWinner).isEqualTo(false);
    }
}