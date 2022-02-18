package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MockRandomNumberGenerator;

class CarsTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    private Cars cars;
    private MockRandomNumberGenerator mockRandomNumberGenerator;

    @BeforeEach
    public void setUp() {
        cars = new Cars(List.of(CAR_1_NAME, CAR_2_NAME));
        mockRandomNumberGenerator = new MockRandomNumberGenerator();
        cars.move(mockRandomNumberGenerator);
        cars.move(mockRandomNumberGenerator);
        cars.move(mockRandomNumberGenerator);
    }

    @Test
    @DisplayName("게임에_참여한_자동차들_이동")
    public void move() {
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
                .isEqualTo(1);
    }
}
