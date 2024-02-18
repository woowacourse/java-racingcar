import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.Car;
import model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("랜덤으로 주어지는 숫자에 따라 정상적으로 이동하는지 확인")
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

    @DisplayName("자동차 중 가장 큰 위치를 가지는 자동차 이름을 반환한다")
    @Test
    void getMaxLocation() {

        List<Car> carList = List.of(
                Car.from("a", 1),
                Car.from("b", 3),
                Car.from("c", 5),
                Car.from("d", 7)
        );
        Cars cars = new Cars(carList);

        assertThat(cars.getMaxLocationCarNames()).isEqualTo(List.of("d"));
    }
}
