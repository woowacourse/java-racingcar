package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Generator.CarMoveValueGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Name name = new Name("pobi");
    Car car = new Car(name);

    @Test
    void 전진하기() {
        CarMoveValueGenerator carMoveValueGenerator = () -> 5;
        assertThat(car.movePosition()).isEqualTo(1);
    }

    @Test
    void 최대_위치인지_비교_테스트() {
        Names names = new Names("pobi,elly,rutgo");
        Cars cars = new Cars(names);
        Car firstCar = cars.getCars().get(0);
        Car secondCar = cars.getCars().get(1);

        assertThat(firstCar.isMaxPosition(secondCar)).isTrue();
    }
}
