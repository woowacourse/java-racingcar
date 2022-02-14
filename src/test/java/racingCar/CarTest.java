package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final CarRacingGame racingCar = new CarRacingGame();

    @DisplayName("자동차 위치 출력 정상 확인")
    @Test
    void 자동차_위치_출력_정상() {
        Car car = new Car("woowahan");
        car.moveCar(true);
        assertThat(car.toString()).isEqualTo("woowahan : -");
        car.moveCar(false);
        assertThat(car.toString()).isEqualTo("woowahan : -");
        car.moveCar(true);
        assertThat(car.toString()).isEqualTo("woowahan : --");
    }

}
