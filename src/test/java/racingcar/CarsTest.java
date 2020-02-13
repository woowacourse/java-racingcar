package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 자동차 목록 테스트 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class CarsTest {
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void initialize() {
        cars.add(new Car(new Name("pobi")));
        cars.add(new Car(new Name("alt")));
        cars.add(new Car(new Name("habi")));
        cars.add(new Car(new Name("honux")));
        cars.add(new Car(new Name("tony")));
        cars.add(new Car(new Name("sth")));
    }

    @Test
    @DisplayName("생성자 테스트")
    void constructor() {
        Assertions.assertThat(new Cars(cars))
                .isInstanceOf(Cars.class);
    }

    @Test
    @DisplayName("생성자에 중복된 이름이 있는 경우")
    void constructor_중복된_이름이_있는_경우() {
        cars.add(new Car(new Name("pobi")));
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주어진 차 리스트가 null인 경우")
    void constructor_주어진_차_리스트가_null인_경우() {
        Assertions.assertThatThrownBy(() -> new Cars(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("주어진 차의 수가 범위 밖인 경우")
    void constructor_주어진_차의_수가_범위_밖인_경우() {
        cars.add(new Car(new Name("1")));
        cars.add(new Car(new Name("2")));
        cars.add(new Car(new Name("3")));
        cars.add(new Car(new Name("4")));
        cars.add(new Car(new Name("5")));
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("moveAll 테스트")
    void moveAll() {
        List<Integer> powers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expectingPositions = Arrays.asList(1, 1, 1, 2, 2, 2);
        Cars carsObject = new Cars(cars);
        carsObject.moveAll(powers);
        Assertions.assertThat(carsObject.isPostionsOf(expectingPositions))
                .isTrue();
    }

    @Test
    @DisplayName("moveAll에 일치하지 않는 크기의 powers를 입력한 경우")
    void moveAll_일치하지_않는_크기의_리스트를_입력한_경우() {
        List<Integer> powers = Arrays.asList(1, 2, 3, 4, 5);
        Cars carsObject = new Cars(cars);
        Assertions.assertThatThrownBy(() -> carsObject.moveAll(powers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car 리스트와 입력 리스트의 사이즈가 같지 않습니다.");
    }
}
