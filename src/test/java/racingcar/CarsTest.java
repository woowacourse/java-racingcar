package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.Cars;
import racingcar.domain.numbergenerator.MovableNumberGenerator;
import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";

    @Test
    public void Car_2개일때_Cars_객체_생성_테스트() {
        List<Car> carList = CarFactory.from("kun,forky");
        Cars cars = new Cars(carList);
        assertThat(cars.getNumberOfCar()).isEqualTo(2);
    }

    @Test
    public void Car_3개일때_Cars_객체_생성_테스트() {
        List<Car> carList = CarFactory.from("kun,forky,pobi");
        Cars cars = new Cars(carList);
        assertThat(cars.getNumberOfCar()).isEqualTo(3);
    }

    @Test
    public void 중복된_이름() {
        assertThatThrownBy(() -> new Cars(CarFactory.from("kun,kun")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NAME_ERROR);
    }

    @Test
    public void Car_집합에서_최대_position_값_찾기() {
        Cars cars = new Cars(CarFactory.from("kun,forky"));
        String name = "kun";
        NumberGenerator numberGenerator = new MovableNumberGenerator();

        for (Car car : cars.getCars()) {
            if (name.equals(car.getName())) {
                car.move(numberGenerator);

            }
        }
        assertThat(cars.getMaxPosition()).isEqualTo(1);
    }

    @Test
    public void Car_리스트에서_position이_같은_Car_찾기() {
        Car car1 = new Car("forky");
        Car car2 = new Car("kun");
        Cars cars = new Cars(Arrays.asList(car1, car2));
        int position = 1;

        car2.move(new MovableNumberGenerator());

        assertThat(cars.getSamePositionCar(position).get(0)).isEqualTo(car2);
    }

    @Test
    public void Car_리스트에서_position이_같은_Car_2개인경우() {
        Car car1 = new Car("forky");
        Car car2 = new Car("kun");
        Cars cars = new Cars(Arrays.asList(car1, car2));
        int position = 1;
        NumberGenerator numberGenerator = new MovableNumberGenerator();

        car1.move(numberGenerator);
        car2.move(numberGenerator);

        assertThat(cars.getSamePositionCar(position).size()).isEqualTo(2);
    }
}
