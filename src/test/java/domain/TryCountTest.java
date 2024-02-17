package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidateException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("시도 횟수가 1 이상이면 객체 생성에 성공한다")
    void createTryCountSuccess(int value) {
        Assertions.assertThatCode(() -> new TryCount(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    @DisplayName("시도 횟수가 1 미만, 5 초과이면 객체 생성에 실패한다")
    void createTryCountFail(int value) {
        Assertions.assertThatThrownBy(() -> new TryCount(value))
                .isInstanceOf(ValidateException.class)
                .hasMessage(ExceptionMessage.TRY_COUNT_RANGE_ERROR_MESSAGE);
    }
}