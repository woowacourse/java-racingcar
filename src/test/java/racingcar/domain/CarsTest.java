package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {
    @ParameterizedTest
    @CsvSource(value = {"코니:is2js"}, delimiter = ':')
    @DisplayName("자동차 게임 라운드별 기록을 가져오는 기능")
    public void drive_round_record(String name1, String name2) {
        Car car1 = Car.fromName(Name.from(name1));
        Car car2 = Car.fromName(Name.from(name2));

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Cars cars = Cars.from(carList);

        assertThat(cars.getCurrentCars().size()).isEqualTo(2);
        assertThat(cars.getCurrentCars().get(0).getName().toString()).isEqualTo(name1);
        assertThat(cars.getCurrentCars().get(1).getName().toString()).isEqualTo(name2);
    }

    @ParameterizedTest
    @CsvSource(value = {"코니:is2js"}, delimiter = ':')
    @DisplayName("자동차 경주 후 가장 많이 전진한 자동차를 구하는 기능")
    public void drive_result_maxPositionCar(String name1, String name2) {
        Car car1 = Car.fromName(Name.from(name1));
        Car car2 = Car.fromName(Name.from(name2));

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Cars cars = Cars.from(carList);
        car1.drive(5);
        Car findMaxCar = cars.findMaxPositionCar();

        assertThat(findMaxCar).isEqualTo(car1);
    }

    @ParameterizedTest
    @CsvSource(value = {"코니:is2js"}, delimiter = ':')
    @DisplayName("우승 자동차(들) 정상 추출 확인 테스트")
    public void drive_winners(String name1, String name2) {
        Car car1 = Car.fromName(Name.from(name1));
        Car car2 = Car.fromName(Name.from(name2));

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Cars cars = Cars.from(carList);
        car1.drive(5);
        car2.drive(4);

        assertThat(cars.getWinners().size()).isEqualTo(2);
    }
}
