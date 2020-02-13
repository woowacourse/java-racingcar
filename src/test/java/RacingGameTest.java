import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingGame.controller.Output;
import racingGame.domain.Car;
import racingGame.controller.Input;
import racingGame.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {
    private static final List<Car> carList = new ArrayList<>();
    Input input;
    Output output;
    private final String NAMES = "pobi,crong,honux";
    private final String REPEAT = "5";

    @BeforeAll
    static void initList(){
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
    @BeforeEach
    void initInput() {
        input = new Input(NAMES, REPEAT);
        output = new Output();
    }

    @ParameterizedTest
    @CsvSource(value = {"3,true","2,false"})
    void 이동_테스트(int position, boolean expected) {
        boolean result = carList.get(0).isSamePosition(position);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @RepeatedTest(value = 50)
    void 랜덤_테스트() {
        int result = RacingGame.generateRandom();

        Assertions.assertThat(result).isBetween(0, 9);
    }

    @Test
    void 우승자_확인_테스트(){
        boolean chkWinner = carList.get(0).isWinner();
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = carList.get(1).isWinner();
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = carList.get(2).isWinner();
        Assertions.assertThat(chkWinner).isEqualTo(false);
    }
/*
    @Test
    void 게임_진행_테스트(){
        RacingGame.play(input, output);
        Assertions.assertThat().containsAnyOf("pobi", "crong", "honux");
    }*/
}
