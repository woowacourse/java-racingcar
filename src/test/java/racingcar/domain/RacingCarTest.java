package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domian.RacingCar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("예외 케이스 테스트: 입력 횟수가 null 혹은 empty인 경우")
    @ParameterizedTest
    @NullAndEmptySource
    void 입력횟수가_Null_Or_Empty(String count) {
        assertThatThrownBy(() -> {
            new RacingCar("user", count);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("경주 Round 카운트가 숫자가 아닌 경우")
    @Test
    void 횟수가_숫자가_아닌_경우() {
        assertThatThrownBy(() -> {
            new RacingCar("user", "a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 횟수 입력");
    }

    @DisplayName("예외 케이스 테스트: 경주 Round 카운트가 10초과 혹은 1보다 작은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "11"})
    void 횟수가_10초과_및_1보다작은_경우(String count) {
        assertThatThrownBy(() -> {
            new RacingCar("user", count);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("횟수가 1보다 작거나 10번 초과");
    }
}
