package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RetryHelperTest {

    @Test
    void retry() {
        final int[] retryCount = {0};
        RetryHelper retryHelper = new RetryHelper(2);
        retryHelper.retry(() -> {
            if (retryCount[0] > 0) {
                return "test";
            }
            retryCount[0]++;
            throw new RuntimeException("재시도");
        });
    }

    @Test
    void retryTimeOver() {
        final int[] retryCount = {0};
        RetryHelper retryHelper = new RetryHelper(2);
        Assertions.assertThatThrownBy(() -> retryHelper.retry(() -> {
                    if (retryCount[0] > 4) {
                        return "test";
                    }
                    retryCount[0]++;
                    throw new RuntimeException("재시도");
                }))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("프로그램이 비정상 종료되었습니다.");

    }
}