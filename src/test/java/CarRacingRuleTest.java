import domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRacingRuleTest {
    Car car;

    @Test
    void getRandomNumber() {
        assertThat((0 <= CarRacingRule.getRandomNumber())
                && (CarRacingRule.getRandomNumber() <= 9)).isTrue();
    }

    @Test
    void judgeMove() {
        car = new Car("car");
        assertThat(CarRacingRule.judgeMove(car, 4)).isEqualTo("Go");
        assertThat(CarRacingRule.judgeMove(car, 3)).isEqualTo("Stop");
    }
}
