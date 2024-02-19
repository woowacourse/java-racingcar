package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private final Car car = new Car("abc");

    @Nested
    @DisplayName("자동차 생성 테스트")
    class CarNameTest {

        @ParameterizedTest
        @ValueSource(strings = {"abc", "ABCDE", "ABC가나", "가나다", "가나다라마"})
        @DisplayName("이름은 영어, 한글 5자 이내이다")
        void validateCarName(String name) {
            assertThatCode(() -> new Car(name))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"a!", "a b", " ", "ABC가나k"})
        @DisplayName("이름은 영어, 한글 5자 이내가 아니면 예외가 발생한다.")
        void invalidateCarName(String name) {
            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("자동차의 가져온다.")
    void getName() {
        assertThat(car.getName()).isEqualTo("abc");
    }

    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"}, delimiter = ',')
    @DisplayName("4 이상이면 이동, 미만이면 이동하지 않는다.")
    void move(int randomNumber, int expect) {
        car.move(randomNumber);
        assertThat(car.getLastLocation()).isEqualTo(expect);
    }

    @Test
    @DisplayName("자동차의 마지막 위치를 가져온다.")
    void getLastLocation() {
        assertThat(car.getLastLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("라운드별 자동차의 위치를 가져온다.")
    void getLocation() {
        car.move(4);

        assertThat(car.getRoundLocation(1)).isEqualTo(1);
    }
}