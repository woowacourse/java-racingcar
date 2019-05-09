package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {
    Winner winner;

    @BeforeEach
    void setUp() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");

        pobi.judgeMove(4);
        pobi.judgeMove(4);

        crong.judgeMove(4);

        honux.judgeMove(4);
        honux.judgeMove(4);

        List<Car> carList = Arrays.asList(pobi, crong, honux);

        winner = new Winner(carList);
    }

    @Test
    void 우승자구하기() {
        List<String> result = Arrays.asList("pobi", "honux");
        assertThat(winner.getWinnerList()).isEqualTo(result);
    }

    @AfterEach
    void tearDown() {
        winner = null;
    }
}
