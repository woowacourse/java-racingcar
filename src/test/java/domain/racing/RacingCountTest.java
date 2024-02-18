package domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCountTest {

    @DisplayName("0이상의 정수가 입력되면 객체가 생성된다.")
    @Test
    void createRacingCount() throws Exception {
        // Given
        int count = 2;

        // When
        RacingCount racingCount = new RacingCount(count);

        // Then
        assertThat(racingCount).isNotNull();
    }

    @DisplayName("1미만의 정수가 입력되면 예외가 발생한다.")
    @Test
    void createRacingCountThrowExceptionWithInvalidInput() throws Exception {
        // Given
        int count = 0;

        // When & Then
        assertThatThrownBy(() -> new RacingCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 숫자가 입력되어야 합니다.");
    }

    @DisplayName("내부에 가지고 있는 레이싱 카운트 정수값 보다 큰 수가 입력되면 true를 반환한다.")
    @Test
    void isCountEndReturnFalse() throws Exception {
        // Given
        RacingCount racingCount = new RacingCount(4);
        int biggerCount = 5;

        // When
        boolean isEnd = racingCount.isCountEnd(biggerCount);

        // Then
        assertThat(isEnd).isTrue();
    }

    @DisplayName("내부에 가지고 있는 레이싱 카운트 정수값 보다 작거나 같은 수가 입력되면 false를 반환한다.")
    @Test
    void isCountEndReturnTrue() throws Exception {
        // Given
        RacingCount racingCount = new RacingCount(4);
        int lowerOrEqualCount = 4;

        // When
        boolean isEnd = racingCount.isCountEnd(lowerOrEqualCount);

        // Then
        assertThat(isEnd).isFalse();
    }
}
