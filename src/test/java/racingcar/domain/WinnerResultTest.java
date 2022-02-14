package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.result.WinnerResult;

public class WinnerResultTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "crong";
    private static final String CAR_3_NAME = "honux";

    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        car1 = Car.createByName(CAR_1_NAME);
        car2 = Car.createByName(CAR_2_NAME);
        car3 = Car.createByName(CAR_3_NAME);
    }

    @Test
    public void 우승자_이름_반환() {
        WinnerResult winnerResult = new WinnerResult(Arrays.asList(car1, car2, car3));
        assertThat(winnerResult.getWinnerNames()).contains(CAR_1_NAME, CAR_2_NAME, CAR_3_NAME);
    }

}
