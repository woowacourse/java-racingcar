package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TryTimeTest {

    @ParameterizedTest
    @DisplayName("decrease 메서드를 이용하면, tryTime이 1감소한다.")
    @ValueSource(ints = {1, 2, 3, 4})
    void decreaseTest(int time) {
        TryTime tryTime = new TryTime(time);
        tryTime.decrease();
        Assertions.assertThat(tryTime)
                .extracting("tryTime")
                .isEqualTo(time - 1);
    }

    @ParameterizedTest
    @DisplayName("tryTime이 0 이하면 false를 1이상이면 true를 반환한다.")
    @CsvSource(value = {"0:false", "1:true", "2:true"}, delimiter = ':')
    void isRemainTest(int time, boolean expected) {
        TryTime tryTime = new TryTime(time);

        Assertions.assertThat(tryTime.isRemain())
                .isEqualTo(expected);
    }

    @Nested
    class initializeTest {
        @ParameterizedTest
        @DisplayName("0이상인 int형으로 TryTime을 객체를 잘 초기화하는 확인")
        @ValueSource(ints = {0, 1, 2, 3, 4, 5})
        void initializeSuccess(int time) {
            assertDoesNotThrow(() -> new TryTime(time));
        }

        @ParameterizedTest
        @DisplayName("음수로 TryTime을 초기화할 시 Exception 반환")
        @ValueSource(ints = {-1, -2, -3, -4})
        void initializeFail(int time) {
            Assertions.assertThatThrownBy(() -> new TryTime(time))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도 횟수는 음수일 수 없습니다.");
        }
    }
}
