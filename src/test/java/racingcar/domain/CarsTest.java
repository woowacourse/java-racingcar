package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {
    @ParameterizedTest
    @CsvSource(value = {"hoon:is2js"}, delimiter = ':')
    @DisplayName("자동차 게임 라운드별 기록을 가져오는 기능")
    public void drive_round_record(String name1, String name2) {
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Cars cars = Cars.from(carList);

        assertThat(cars.getDriveRecord().size()).isEqualTo(2);
        assertThat(cars.getDriveRecord().get(0).getName()).isEqualTo(name1);
        assertThat(cars.getDriveRecord().get(1).getName()).isEqualTo(name2);
    }

    @ParameterizedTest
    @CsvSource(value = {"hoon:is2js"}, delimiter = ':')
    @DisplayName("자동차 경주 후 가장 많이 전진한 자동차를 구하는 기능")
    public void drive_result_maxPositionCar(String name1, String name2) {
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Cars cars = Cars.from(carList);
        car1.drive(5);
        Car findMaxCar = cars.findMaxPositionCar();

        assertThat(findMaxCar).isEqualTo(car1);
    }

    @ParameterizedTest
    @CsvSource(value = {"hoon:is2js"}, delimiter = ':')
    @DisplayName("자동차 경주 우승자 판별 기능")
    public void drive_winners(String name1, String name2) {
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Cars cars = Cars.from(carList);
        car1.drive(5);
        car2.drive(4);

        assertThat(cars.getWinners().size()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"hoon:hoon"}, delimiter = ':')
    @DisplayName("자동차들의 이름이 중복된 경우 예외처리 기능")
    public void cars_name_invalid_duplicated(String name1, String name2) {
        assertThatThrownBy(() -> Cars.fromNames(Arrays.asList(name1, name2)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
