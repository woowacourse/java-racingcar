package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TrialCount;
import racingcar.util.StringUtil;

public class TrialCountTest {

    @Test
    public void 시도_횟수_입력_테스트() {
        int gameCount = TrialCount.from("3").toInt();
        assertThat(gameCount).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource(value = "provideTrialCountLineAndExceptionMessage")
    public void 시도_횟수_생성_예외_테스트() {
        assertThatThrownBy(() -> TrialCount.from("이브"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("시도 횟수가 숫자가 아닙니다.");
    }

    private static Stream<Arguments> provideTrialCountLineAndExceptionMessage() {
        return Stream.of(
                Arguments.of("이브", "시도 횟수가 숫자가 아닙니다."),
                Arguments.of(-1, "시도 횟수가 음수나 0이 될 수 없습니다."),
                Arguments.of(0, "시도 횟수가 음수나 0이 될 수 없습니다.")
        );
    }
}
