package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private static final int ONE_STEP = 1;

    @Test
    @DisplayName("랜덤 값이 4이상이면 전진하는 기능 테스트")
    public void moveTest() {

        RacingCar racingCar1 = RacingCar.generateRacingCar("pobi");

        int beforePosition = racingCar1.getPosition();
        racingCar1.goOrStay(5);
        int afterPosition = racingCar1.getPosition();

        assertThat(beforePosition + ONE_STEP).isEqualTo(afterPosition);
    }

}
