package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCar racingCar;
    private static final int ONE_STEP = 1;

    @BeforeEach
    public void setUp() {
        racingCar = RacingCar.generateRacingCar("pobi");
    }

    @Test
    @DisplayName("랜덤 값이 4이상이면 전진하는 기능 테스트")
    public void moveTest() {
        int beforePosition = racingCar.getPosition();
        racingCar.goOrStay(5);
        int afterPosition = racingCar.getPosition();

        assertThat(beforePosition + ONE_STEP).isEqualTo(afterPosition);

    }
}
