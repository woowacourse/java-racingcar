package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TryCount;

class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("시도 횟수가 1 이상이면 객체 생성에 성공한다")
    void createTryCountSuccess(int value) {
        Assertions.assertThatCode(() -> new TryCount(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    @DisplayName("시도 횟수가 1 미만이면 객체 생성에 실패한다")
    void createTryCountFail(int value) {
        Assertions.assertThatThrownBy(() -> new TryCount(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}