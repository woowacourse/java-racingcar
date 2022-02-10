package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    @DisplayName("자동차의 이름이 5자가 초과될 경우 예외가 발생해야 한다.")
    void checkRacingCarNameLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCar("abcede"))
            .withMessageMatching("자동차 이름은 5자를 초과할 수 없다.");
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이 되어야 한다.")
    void racingCarDefaultPosition() {
        RacingCar car = new RacingCar("name");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 4이상 입력되면 움직여야 한다.")
   void racingCarMove() {
        RacingCar car = new RacingCar("name");
        RandomGenerator randomGenerator = new RandomGenerator();
        int position = car.move(randomGenerator.generateRandomNumber());
        assertThat(position).isEqualTo(1);
    }
}
