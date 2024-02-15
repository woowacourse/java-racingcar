import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void moveAll() {

        List<Car> carList = List.of(
                Car.from("a", 0),
                Car.from("b", 0),
                Car.from("c", 0),
                Car.from("d", 0)
        );
        Cars cars = new Cars(carList);

        List<Integer> randomNumbers = List.of(0, 3, 6, 9);
        cars.moveAll(randomNumbers);

        List<Integer> expectedLocations = List.of(0, 0, 1, 1);
        List<Integer> actual = cars.getCarList().stream()
                .map(Car::getCarLocation)
                .toList();

        assertThat(actual).isEqualTo(expectedLocations);
    }

    @Test
    void getMaxLocation() {

        List<Car> carList = List.of(
                Car.from("a", 1),
                Car.from("b", 3),
                Car.from("c", 5),
                Car.from("d", 7)
        );
        Cars cars = new Cars(carList);

        assertThat(cars.getMaxLocation()).isEqualTo(7);
    }
}
