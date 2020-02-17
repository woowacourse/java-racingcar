package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.Name;

/**
 * 자동차 테스트 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
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

    @ParameterizedTest
    @DisplayName("move 테스트")
    void move(int position) {
        Car car = new Car(new Name("pobi"));
        car.move();
        Assertions.assertThat(car.isPositionOf(position))
                .isEqualTo(2);
    }
}
