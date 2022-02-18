package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_DUPLICATE_NAME;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("생성자는 String 배열을 입력받아 Car를 생성하고 Cars 내부 리스트에 추가한다.")
    @Test
    void constructor_carNames() {
        // given
        String[] strings = {"hi", "roma", "jason"};
        Cars cars = new Cars(strings);

        List<Car> allCars = cars.findAllCars();
        // then
        assertThat(allCars).containsExactly(new Car("hi"), new Car("roma"), new Car("jason"));
    }

    @DisplayName("생성자는 String 배열에 중복된 원소가 있을 경우 예외를 발생시킨다.")
    @Test
    void constructor_errorOnDuplication() {
        // given
        String[] strings = {"hi", "hi", "jason"};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Cars(strings))
                .withMessageMatching(ERROR_DUPLICATE_NAME);
    }

//    @DisplayName("getWinners 메서드는 가장 position 값이 큰 car 객체들을 반환한다")
//    @Test
//    void getWinners() {
//        List<Car> carList = new ArrayList<>();
//
//        Car juneCar = new Car("june", 0);
//        Car pobiCar = new Car("pobi", 5);
//        Car romaCar = new Car("roma", 5);
//
//        carList.add(juneCar);
//        carList.add(pobiCar);
//        carList.add(romaCar);
//
//        Cars cars = new Cars(carList);
//
//        List<Car> winners = cars.findWinners();
//        assertThat(winners).containsExactly(pobiCar, romaCar);
//    }

}

