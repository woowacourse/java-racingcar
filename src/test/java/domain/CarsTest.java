package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import java.util.Arrays;

import calculator.StringCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarsTest {
    private static final int EXPECTED_MAX_POSITION = 7;
    private static final int EXPECTED_SIZE = 4;

    private static Car car1;
    private static Car car2;
    private static Car winnerCar1;
    private static Car winnerCar2;
    private static Cars cars;

    @BeforeAll
    static void setup() {
        car1 = new Car("타미", 1);
        car2 = new Car("유안", 2);
        winnerCar1 = new Car("라면", EXPECTED_MAX_POSITION);
        winnerCar2 = new Car("둔덩", EXPECTED_MAX_POSITION);
        cars = new Cars(Arrays.asList(car1, car2, winnerCar1, winnerCar2));
    }

    @Test
    void duplicatedNameTest() {
        Car duplicatedCar1 = new Car("던둥");
        Car duplicatedCar2 = new Car("던둥");
        assertThatThrownBy(() -> new Cars(Arrays.asList(duplicatedCar1, duplicatedCar2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getSizeTest() {
        assertThat(cars.getSize()).isEqualTo(EXPECTED_SIZE);
    }

    @Test
    void getMaxPositionTest() {
        int maxPosition = cars.getMaxPosition();
        assertThat(maxPosition).isEqualTo(EXPECTED_MAX_POSITION);
    }

    @Test
    void findByPositionTest() {
        List<Car> expectedWinners = Arrays.asList(winnerCar1, winnerCar2);
        int maxPosition = cars.getMaxPosition();
        List<Car> actualWinners = cars.findByPosition(maxPosition);
        assertThat(actualWinners.equals(expectedWinners)).isTrue();
    }
}
