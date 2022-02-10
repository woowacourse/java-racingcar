package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MidtermResultTest {

    static final String CAR_1_NAME = "pobi";
    static final String CAR_2_NAME = "crong";
    static final String CAR_3_NAME = "honux";

    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setUp() {
        car1 = Car.from(CAR_1_NAME);
        car2 = Car.from(CAR_2_NAME);
        car3 = Car.from(CAR_3_NAME);
    }

    @Test
    public void 중간_결과_자동차_이름_리스트_반환() {
        MidtermResult midtermResult = new MidtermResult(
            Arrays.asList(car1, car2, car3));
        assertThat(midtermResult.getCarNames()).contains(CAR_1_NAME, CAR_2_NAME, CAR_3_NAME);
    }
}
