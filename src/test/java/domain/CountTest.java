package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CountTest {


    @Nested
    @DisplayName("실행 회수 생성 테스트")
    class CountConstructorTest {

        @ParameterizedTest
        @ValueSource(ints = {1, 100, 45})
        @DisplayName("실행 회수는 1이상 100이하 이다")
        void validateCount(int count) {
            assertThatCode(() -> new Count(count))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 101})
        @DisplayName("실행 회수가 0이하 100초과라면 예외가 발생한다")
        void invalidateCount(int count) {
            assertThatThrownBy(() -> new Count(count))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("실행 회수가 1 이상이면 참이다.")
    void isRemain() {
        Count count = new Count(1);

        assertThat(count.hasRemain()).isTrue();
    }

    @Test
    @DisplayName("실행 회수가 감소한다")
    void down() {
        Count count = new Count(1);

        count.down();

        assertThat(count.hasRemain()).isFalse();
    }
}