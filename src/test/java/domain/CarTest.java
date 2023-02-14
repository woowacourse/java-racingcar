package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class CarTest {

    @Nested
    @DisplayName("자동차를 초기화할 때,")
    class InitializeTest {
        @ParameterizedTest(name = "{0} 일 때 IllegalArgumentException 발생")
        @DisplayName("유효하지 않은 길이의 이름")
        @ValueSource(strings = {"abcdef4", "adffdsd", "dadfewe"})
        void throwExceptionWhenInvalidNameLength(String name) {
            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차의 이름은 다섯 글자 이하여야합니다.");
        }

        @ParameterizedTest
        @DisplayName("이름이 빈 문자열일 때 IllegalArgumentException 발생")
        @ValueSource(strings = {"", " ", "   ", "\n", "\t"})
        void throwExceptionWhenNameIsEmpty(String name) {
            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 공백일 수 없습니다.");
        }

        @ParameterizedTest
        @DisplayName("조건에 만족하면 정상적으로 Car가 초기화")
        @ValueSource(strings = {"rosie", "hong", "neo", "Oz"})
        void initial_success(String name) {
            assertDoesNotThrow(() -> new Car(name));
        }
    }

    @Nested
    class MoveTest {
        @ParameterizedTest
        @DisplayName("1회 이동했을 때, 위치가 정상적으로 증가하는지 테스트")
        @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
        void moveOneStep(int pickedNumber, int expectedPosition) {
            Car car = new Car("hong");
            car.moveDependingOn(pickedNumber);
            assertThat(car).extracting("position")
                    .isEqualTo(expectedPosition);
        }
    }
}
