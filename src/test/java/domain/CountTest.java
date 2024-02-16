package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 101, 102})
    @DisplayName("1이상 ~ 100이하 범위를 벗어날시 예외가 발생한다.")
    void validateCountTest(int countInput) {
        Assertions.assertThatThrownBy(() -> new Count(countInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("count 변수에서 1을 뺀다")
    void minusOneCountTest() {

        Count count = new Count(5);
        count.minusOneCount();
        count.minusOneCount();
        count.minusOneCount();

        Assertions.assertThat(count).extracting("count").isEqualTo(2);
    }

    @Test
    @DisplayName("count 변수가 1 이상이면 true를 반환한다.")
    void hasCountTrueTest() {
        Count count = new Count(1);
        Assertions.assertThat(count.hasCount()).isTrue();
    }

    @Test
    @DisplayName("count 변수가 0이면 false를 반환한다.")
    void hasCountFalseTest() {
        Count count = new Count(1);
        count.minusOneCount();
        Assertions.assertThat(count.hasCount()).isFalse();
    }
}
