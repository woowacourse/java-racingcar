package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MockRandomNumberGenerator;

class CarsTest {

    public static final String CAR_1_NAME = "pobi";
    public static final String CAR_2_NAME = "jason";

    @Test
    @DisplayName("자동차들_이동")
    public void move() {
        Cars cars = new Cars(List.of(CAR_1_NAME, CAR_2_NAME));
        MockRandomNumberGenerator mockRandomNumberGenerator = new MockRandomNumberGenerator();
        cars.move(mockRandomNumberGenerator);
        cars.move(mockRandomNumberGenerator);
        assertThat(cars.getCars().stream()
                .filter(car -> car.getName() == CAR_1_NAME)
                .findFirst()
                .orElseThrow()
                .getPosition())
                .isEqualTo(2);
        assertThat(cars.getCars().stream()
                .filter(car -> car.getName() == CAR_2_NAME)
                .findFirst()
                .orElseThrow()
                .getPosition())
                .isEqualTo(0);
    }
}
