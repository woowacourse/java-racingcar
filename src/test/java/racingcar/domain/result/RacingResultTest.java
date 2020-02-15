package racingcar.domain.result;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {
    @Test
    void 레이싱_결과를_출력() {
        Car car1 = new Car("무늬", 4);
        Car car2 = new Car("두강", 1);
        Car car3 = new Car("쿨라임", 3);
        Car car4 = new Car("코일", 2);
        List<Car> cars = Arrays.asList(car1, car2, car3, car4);

        RacingResult racingResult = new RacingResult(cars);
        String result = racingResult.getResult();
        String expected = "무늬 : ----\n" +
                "두강 : -\n" +
                "쿨라임 : ---\n" +
                "코일 : --\n";

        assertThat(result).isEqualTo(expected);
    }
}
