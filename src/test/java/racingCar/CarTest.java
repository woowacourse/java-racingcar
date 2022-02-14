package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final RacingCar racingCar = new RacingCar();

    @DisplayName("자동차 위치 출력 정상 확인")
    @Test
    void 자동차_위치_출력_정상() {
        Car car = new Car("woowahan");
        car.moveCar(true);
        assertThat(car.toString()).isEqualTo("woowahan : -");
        car.moveCar(false);
        assertThat(car.toString()).isEqualTo("woowahan : -");
        car.moveCar(true);
        assertThat(car.toString()).isEqualTo("woowahan : --");
    }

    @DisplayName("최종 출력 결과 확인")
    @Test
    void 최종_결과_출력_정상() {
        List<Car> cars = new ArrayList<>();
        List<Car> winners = new ArrayList<>();

        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        cars.get(0).moveCar(true);
        cars.get(0).moveCar(true);
        cars.get(1).moveCar(true);
        cars.get(1).moveCar(true);
        cars.get(2).moveCar(false);

        winners.add(car1);
        winners.add(car2);

        List<Car> result = racingCar.findWinner(cars);
        assertThat(result).isEqualTo(winners);
    }
}
