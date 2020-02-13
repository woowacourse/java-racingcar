package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import java.util.Arrays;

import calculator.StringCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class CarsTest {
    private static Car car1;
    private static Car car2;
    private static Car car3;
    private static Car car4;
    private static Cars cars;

    @BeforeAll
    static void setup() {
        car1 = new Car("타미", 1);
        car2 = new Car("둔덩", 7);
        car3 = new Car("라면", 2);
        car4 = new Car("유안", 7);
        cars = new Cars(Arrays.asList(car1, car2, car3, car4));
    }


    @Test
    void getCarTest() {
        assertThat(cars.getCar(0)).isEqualTo(car1);
        assertThat(cars.getCar(1)).isEqualTo(car2);
    }

    @Test
    void getMaxPositionTest() {
        int maxPosition = cars.getMaxPosition();
        assertThat(maxPosition).isEqualTo(7);
    }

    @Test
    void getWinnersTest() {
        int maxPosition = cars.getMaxPosition();
        List<Car> expectedWinners = Arrays.asList(car2, car4);
        List<Car> actualWinners = cars.findWinners(maxPosition);
        assertThat(actualWinners.equals(expectedWinners)).isTrue();
    }

    @Test
    void duplicatedNameTest() {
        Car duplicatedCar1 = new Car("던둥");
        Car duplicatedCar2 = new Car("던둥");
        assertThatThrownBy(() -> new Cars(Arrays.asList(duplicatedCar1, duplicatedCar2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
