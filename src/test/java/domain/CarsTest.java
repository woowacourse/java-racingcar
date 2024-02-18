package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Car;
import domain.Cars;

class CarsTest {

    @DisplayName("모든 차량의 정상 이동 확인")
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

    @DisplayName("입력된 숫자 리스트의 갯수와 차량 갯수가 다를때 예외 처리 확인")
    @Test
    void moveAll_WithInvalidCount() {
        List<Car> carList = List.of(
            Car.from("a", 0),
            Car.from("b", 0),
            Car.from("c", 0),
            Car.from("d", 0)
        );
        Cars cars = new Cars(carList);

        List<Integer> randomNumbers = List.of(0, 3, 4, 5, 9);
        assertThatThrownBy(() -> cars.moveAll(randomNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("가장 많이 이동한 차량의 위치 확인")
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
