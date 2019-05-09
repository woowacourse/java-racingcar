package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @Test
    void 이름이_잘_분리되는지_확인한다() {
        String userInput1 = "pobi,cony,whale";
        String userInput2 = " pobi, cony, whale ";
        String[] carNameArray = {"pobi", "cony", "whale"};

        assertThat(racingCar.splitUserCarNames(userInput1)).isEqualTo(carNameArray);
        assertThat(racingCar.splitUserCarNames(userInput2)).isEqualTo(carNameArray);
    }
}
