package domain.racing;

import domain.racing.RacingCount;
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
                .isInstanceOf(RuntimeException.class)
                .hasMessage("1이상의 숫자가 입력되어야 합니다.");
    }
}
