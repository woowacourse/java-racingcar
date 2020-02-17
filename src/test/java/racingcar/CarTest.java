package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Name;

/**
 * 자동차 테스트 클래스
 *
 * @author K.S.KIM
 * @author HyoChan
 * @version 1.0.0
 * @since 2020/02/13
 */
public class CarTest {
    @Test
    @DisplayName("생성자 테스트")
    void constructor() {
        Assertions.assertThat(new Car(new Name("pobi")))
                .isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("생성자에 null이 들어온 경우")
    void constructor_이름이_null로_들어온_경우() {
        Assertions.assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("움직이는 move 테스트")
    void move_움직이는_경우() {
        Car car = new Car(new Name("pobi"), new MovableNumberGeneratorStrategy());
        car.move();
        Assertions.assertThat(car.isPositionOf(2))
                .isTrue();
    }

    @Test
    @DisplayName("움직이지 않는 move 테스트")
    void move_움직이지_않는_경우() {
        Car car = new Car(new Name("pobi"), new UnmovableNumberGeneratorStrategy());
        car.move();
        Assertions.assertThat(car.isPositionOf(1))
                .isTrue();
    }
}
