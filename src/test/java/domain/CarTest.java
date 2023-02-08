package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Nested
    class InitializeTest {
        @ParameterizedTest(name = "{0} 일 때 IllegalArgumentException 발생")
        @DisplayName("유효하지 않은 길이의 이름")
        @ValueSource(strings = {"abcdef4", "adffdsd", "dadfewe"})
        void throwExceptionWhenInvalidNameLength(String name) {
            Assertions.assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("이름이 빈 문자열일 때 IllegalArgumentException 발생")
        void throwExceptionWhenNameIsEmpty() {
            Assertions.assertThatThrownBy(() -> new Car(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class MoveTest {
        @Test
        @DisplayName("1회 이동했을 때, 위치가 정상적으로 증가하는지 테스트")
        void moveOneStep() {
            Car car = new Car("hong");
            car.move();
            Assertions.assertThat(car).extracting("position")
                    .isEqualTo(1);
        }
    }
}
