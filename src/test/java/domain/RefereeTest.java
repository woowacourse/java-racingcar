package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RefereeTest {

    @Test
    @DisplayName("car1는 1번, car2는 3번, car3는 3번 움직였을 때 우승자는 car2와 car3")
    void judgment() {
        Referee referee = new Referee();
        CarRepository carRepository = new CarRepository();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(4);
        car2.move(4);
        car2.move(4);
        car2.move(4);
        car3.move(4);
        car3.move(4);
        car3.move(4);

        carRepository.addCar(car1);
        carRepository.addCar(car2);
        carRepository.addCar(car3);


        assertThat(referee.judgment(carRepository).getAll()).isEqualTo(List.of(car2, car3));
    }
}