package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.result.MidtermResult;

public class MidtermResultTest {

    private static final int FORWARDING_RANDOM_NUMBER = 4;
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

        car1.move(FORWARDING_RANDOM_NUMBER);
        car1.move(FORWARDING_RANDOM_NUMBER);
    }

    @Test
    public void 중간_결과_자동차_이름_리스트_반환() {
        MidtermResult midtermResult = new MidtermResult(Arrays.asList(car1, car2, car3));
        assertThat(midtermResult.getCarNames()).contains(CAR_1_NAME, CAR_2_NAME, CAR_3_NAME);
    }

    @Test
    public void 중간_결과_자동차_위치_이름으로_조회() {
        MidtermResult midtermResult = new MidtermResult(Arrays.asList(car1, car2, car3));
        assertThat(midtermResult.getPositionByName(CAR_1_NAME)).isEqualTo(car1.getPosition());
    }
}
