import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.Car;
import racinggame.domain.Names;
import racinggame.domain.RacingGame;
import racinggame.domain.Repeat;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {
    private static final List<Car> carList = new ArrayList<>();
    private static final int WINNER_POSITION = 3;
    private final String NAMES = "pobi,crong,honux";
    private final String REPEAT = "5";

    Names names = new Names(NAMES);
    Repeat repeat = new Repeat(REPEAT);

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

    @ParameterizedTest
    @CsvSource(value = {"3,true", "2,false"})
    void 이동_테스트(int position, boolean expected) {
        initList();
        boolean result = carList.get(0).isSamePosition(position);
        Assertions.assertThat(result).isEqualTo(expected);
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