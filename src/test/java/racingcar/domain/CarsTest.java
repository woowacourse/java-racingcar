package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_DUPLICATE_NAME;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.StubMoveStrategy;

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

    @DisplayName("getWinners 메서드는 가장 position 값이 큰 car 객체들을 반환한다")
    @Test
    void getWinners() {
        // given
        String[] names = {"june", "pobi", "roma"};
        Cars cars = new Cars(names);
        Car pobiCar = new Car("pobi", 3);
        Car romaCar = new Car("roma", 3);
        // when
        for (int i = 0; i < 3; i++) {
            cars.race(new StubMoveStrategy(9, 1, 6, 6, 1, 6, 6, 1, 6, 6));
        }
        List<Car> winners = cars.findWinners();
        // then
        assertThat(winners).containsExactly(pobiCar, romaCar);
    }

    @DisplayName("findAllCars 메서드는 Cars 내부 리스트를 반환한다.")
    @Test
    void findAllCars() {
        // given
        String[] names = {"june", "pobi", "roma"};
        Cars cars = new Cars(names);
        // when
        List<Car> allCars = cars.findAllCars();
        // then
        assertThat(allCars).containsExactly(new Car("june"), new Car("pobi"), new Car("roma"));
    }

    @DisplayName("findAllCars 메서드로 받은 리스트는 수정이 불가능하다.")
    @Test
    void findAllCars_notModify() {
        // given
        String[] names = {"june", "pobi", "roma"};
        Cars cars = new Cars(names);
        // when
        List<Car> allCars = cars.findAllCars();
        Car chrisCar = new Car("chris");
        // then
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> allCars.add(chrisCar));
    }

    @DisplayName("findAllCars 메서드로 받은 리스트는 clear가 불가능하다.")
    @Test
    void findAllCars_notClear() {
        // given
        String[] names = {"june", "pobi", "roma"};
        Cars cars = new Cars(names);
        // when
        List<Car> allCars = cars.findAllCars();
        // then
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(allCars::clear);
    }
}

