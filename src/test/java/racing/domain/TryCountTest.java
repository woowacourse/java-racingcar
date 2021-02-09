package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.number.TryCount;

import static org.assertj.core.api.Assertions.*;

public class TryCountTest {
    @DisplayName("보장된 시도 횟수를 생성한다.")
    @Test
    void tryCountSave() {
        assertThatCode(() -> new TryCount(5))
                .doesNotThrowAnyException();
    }

    @DisplayName("보장된 시도 횟수가 아니면 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void tryCountSaveError(int tryCount){
        assertThatThrownBy(() -> new TryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("시도횟수는 1회 이상이어야 합니다. 현재 입력값: %d", tryCount));
    }

    @DisplayName("시도횟수가 0 일때 reduce를 호출하면, false를 반환한다.")
    @Test
    void tyrCountZeroTest() {
        //given
        int count = 1;
        TryCount tryCount = new TryCount(count);

        //when
        tryCount.reduce();

        //then
        assertThat(tryCount.reduce()).isEqualTo(false);
    }
}
