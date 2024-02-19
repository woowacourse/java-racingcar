package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Nested
    class ValidateInput {
        @ParameterizedTest
        @ValueSource(strings = {"이름이여섯자", "자동차이름일곱"})
        @DisplayName("이름이 5자 초과 시 예외 발생")
        void testNameUnderFive(String given) {
            assertThatThrownBy(() -> new Car(given, 0))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class Feature {
        @Test
        @DisplayName("차 1칸 이동")
        void testMove() {
            Car car = new Car("차", 0);
            car.move();

            int actual = car.getPosition();
            int expected = 1;
            
            assertThat(actual).isEqualTo(expected);
        }
    }
}
