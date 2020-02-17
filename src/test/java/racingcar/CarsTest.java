package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

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
        DefaultNumberGeneratorStrategy numberGeneratorStrategy = new DefaultNumberGeneratorStrategy();
        cars.add(new Car(new Name("pobi"), numberGeneratorStrategy));
        cars.add(new Car(new Name("alt"), numberGeneratorStrategy));
        cars.add(new Car(new Name("habi"), numberGeneratorStrategy));
        cars.add(new Car(new Name("honux"), numberGeneratorStrategy));
        cars.add(new Car(new Name("tony"), numberGeneratorStrategy));
        cars.add(new Car(new Name("sth"), numberGeneratorStrategy));
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
        List<Integer> expectingPositions = Arrays.asList(1, 1, 1, 1, 1, 1);
        Cars carsObject = new Cars(cars);
        carsObject.moveAll();
        Assertions.assertThat(carsObject.isPostionsOf(expectingPositions))
                .isTrue();
    }
}
