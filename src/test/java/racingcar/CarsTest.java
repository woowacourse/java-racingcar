package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.Cars;
import racingcar.domain.numbergenerator.MovableNumberGenerator;
import racingcar.domain.numbergenerator.NonMovableNumberGenerator;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnerCarsDto;

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

        cars.move(numberGenerator);

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

        cars.move(numberGenerator);

        assertThat(cars.getSamePositionCar(position).size()).isEqualTo(2);
    }

    @Test
    public void Cars_전진_1() {
        Car car1 = new Car("forky");
        Car car2 = new Car("kun");
        Cars cars = new Cars(Arrays.asList(car1, car2));

        CarsDto carsDto = cars.move(new MovableNumberGenerator());

        assertThat(carsDto.getCarPositions().get(0)).isEqualTo(1);
    }

    @Test
    public void 우승자_판정_1명() {
        Car car1 = new Car("forky");
        Car car2 = new Car("kun");
        Cars cars = new Cars(Arrays.asList(car1, car2));

        car1.move(new MovableNumberGenerator());
        car2.move(new NonMovableNumberGenerator());

        WinnerCarsDto winnerCarsDto = cars.judgeWinner();
        assertThat(winnerCarsDto.getWinnerCarNames().get(0)).isEqualTo(car1.getName());
    }

    @Test
    public void 우승자_여러명() {
        Car car1 = new Car("forky");
        Car car2 = new Car("kun");
        Cars cars = new Cars(Arrays.asList(car1, car2));

        cars.move(new MovableNumberGenerator());

        assertThat(cars.judgeWinner().getWinnerCarNames().size()).isEqualTo(2);
    }
}
