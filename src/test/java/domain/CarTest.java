package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final Car car = new Car("abc");

    @Test
    @DisplayName("이름을 반환한다")
    void getName() {
        assertThat(car.getName()).isEqualTo("abc");
    }

    @ParameterizedTest
    @DisplayName("인자로 받은 수가 4 이상이면 이동하고 3이하면 이동하지 않는다")
    @CsvSource(value = {"4,1", "3,0"}, delimiter = ',')
    void move(int randomNumber, int expect) {
        car.move(randomNumber);
        assertThat(car.getLocation()).isEqualTo(expect);
    }

    @Test
    @DisplayName("현재 위치를 반환한다")
    void getLocation() {
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Nested
    @DisplayName("자동차 이름 테스트")
    class CarNameTest {

        @ParameterizedTest
        @ValueSource(strings = {"abc", "ABCDE", "ABC가나", "가나다", "가나다라마"})
        @DisplayName("이름은 영어, 한글 5자 이내이다")
        void validateCarName(String name) {
            Assertions.assertThatCode(() -> new Car(name))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"a!", "a b", " ", "ABC가나k"})
        @DisplayName("이름은 영어, 한글 5자 이내가 아니면 예외가 발생한다.")
        void invalidateCarName(String name) {
            Assertions.assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
