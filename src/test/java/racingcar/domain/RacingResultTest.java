package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingResultTest {

    @DisplayName("레이싱 결과를 보관하고 있는지 확인")
    @Test
    void checkResult() {
        Map<Car, Integer> racingCarResult = new LinkedHashMap<>();
        Car car1 = new Car(new CarName("하나"));
        Car car2 = new Car(new CarName("두울"));
        car1.forward();
        racingCarResult.put(car1, car1.getPosition());
        racingCarResult.put(car2, car2.getPosition());
        RacingResult racingResult = new RacingResult(racingCarResult);
        Map<Car, Integer> carIntegerMap = racingResult.getRacingResult();
        assertThat(carIntegerMap.get(car1)).isEqualTo(1);
        assertThat(carIntegerMap.get(car2)).isEqualTo(0);
    }
}
