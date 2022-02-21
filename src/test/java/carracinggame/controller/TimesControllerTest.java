package carracinggame.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TimesControllerTest {

    TimesController timesController = new TimesController();
    @DisplayName("경기 횟수가 정상적으로 입력됨")
    @Test
    void testTimes() {
        int times = timesController.makeTimes("5");
        assertThat(times).isEqualTo(5);
    }

    @DisplayName("경기 횟수가 올바르지 않을 값일 때 에러 확인")
    @ParameterizedTest
    @ValueSource(strings = {"--", "a", ":", "woowahan"})
    void testInvalidTimes(String times) {
        assertThatThrownBy(() -> timesController.makeTimes(times))
                .isInstanceOf(RuntimeException.class);

    }

    @DisplayName("시도 횟수가 실수일 떄 에러 확인")
    @Test
    void testTimesRealNumberError() {
        assertThatThrownBy(() -> timesController.makeTimes("1.5"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("시도 횟수가 음수일 떄 에러 확인")
    @Test
    void testTimesNegativeNumberError() {
        assertThatThrownBy(() -> timesController.makeTimes("-2"))
                .isInstanceOf(RuntimeException.class);
    }
}
