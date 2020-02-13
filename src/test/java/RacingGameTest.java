import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.controller.Output;
import racinggame.domain.Car;
import racinggame.controller.Input;
import racinggame.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {
    private static final List<Car> carList = new ArrayList<>();
    Input input;
    Output output;
    private final String NAMES = "pobi,crong,honux";
    private final String REPEAT = "5";

    void initList() {
        carList.clear();
        carList.add(new Car("pobi", 0));
        carList.add(new Car("kim", 0));
        carList.add(new Car("park", 0));

        carList.get(0).accelarate(4,4);
        carList.get(0).accelarate(4,4);
        carList.get(0).accelarate(4,4);

        carList.get(1).accelarate(4,4);
        carList.get(1).accelarate(4,4);
        carList.get(1).accelarate(4,4);

        carList.get(2).accelarate(4,4);
        carList.get(2).accelarate(2,4);
        carList.get(2).accelarate(1,4);
    }

    @BeforeEach
    void initInput() {
        input = new Input(NAMES, REPEAT);
        output = new Output();
        Car.initMaxPosition();
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
        boolean chkWinner = carList.get(0).isWinner();
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = carList.get(1).isWinner();
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = carList.get(2).isWinner();
        Assertions.assertThat(chkWinner).isEqualTo(false);
    }

    @RepeatedTest(value = 1000)
    void 레이싱게임_실행_결과_테스트() {
        RacingGame.play(input, output);
        boolean result1 = output.isContainName("pobi");
        boolean result2 = output.isContainName("crong");
        boolean result3 = output.isContainName("honux");

        Assertions.assertThat(result1 || result2 || result3).isTrue();
    }
}
