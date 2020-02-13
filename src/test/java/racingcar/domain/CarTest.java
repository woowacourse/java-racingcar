package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Name name = new Name("pobi");
    Car car = new Car(name);

    @Test
    void 전진하기() {
        assertThat(car.movePosition(4)).isEqualTo(1);
    }

    @Test
    void 멈추기() {
        assertThat(car.movePosition(3)).isEqualTo(0);
    }

    @Test
    void 현재_위치_가져오기() {
        car.movePosition(5);
        assertThat(car.getCurrentPosition()).isEqualTo("pobi : -");
    }

    @Test
    void 최대_위치인지_비교_테스트() {
        Names names = new Names("pobi,elly,rutgo");
        Cars cars = new Cars(names);
        Car firstCar = cars.getCars().get(0);
        Car secondCar = cars.getCars().get(1);
        firstCar.movePosition(5);
        firstCar.movePosition(5);
        secondCar.movePosition(5);

        assertThat(firstCar.isMaxPosition(secondCar)).isTrue();
    }
}
