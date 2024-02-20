package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    @DisplayName("시도 횟수가 1 이상이면 객체 생성에 성공한다")
    void createTryCountSuccess() {
        Assertions.assertThatCode(() -> new TryCount(1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수가 1 미만이면 객체 생성에 실패한다")
    void createTryCountFail() {
        Assertions.assertThatThrownBy(() -> new TryCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}