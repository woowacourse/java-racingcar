package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MockRandomNumberGenerator;
import racingcar.domain.log.CarForLog;

class CarsTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    @Test
    @DisplayName("게임에_참여한_자동차들_이동")
    public void move() {
        Cars cars = new Cars(List.of(CAR_1_NAME, CAR_2_NAME));
        MockRandomNumberGenerator mockRandomNumberGenerator = new MockRandomNumberGenerator();
        cars.move(mockRandomNumberGenerator);
        cars.move(mockRandomNumberGenerator);
        cars.move(mockRandomNumberGenerator);
        assertAll(() -> assertThat(cars.generateCarForLogList().stream()
                        .filter(car -> car.getName() == CAR_1_NAME)
                        .findFirst()
                        .orElseThrow()
                        .getPosition())
                        .isEqualTo(2),
                () -> assertThat(cars.generateCarForLogList().stream()
                        .filter(car -> car.getName() == CAR_2_NAME)
                        .findFirst()
                        .orElseThrow()
                        .getPosition())
                        .isEqualTo(1));
    }
}
