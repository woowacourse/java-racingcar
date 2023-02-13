package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"ㄱ", "a", "0", "!"})
    @DisplayName("Round가 생성될 때 시도 횟수가 숫자가 아니고 1보다 작은 값이 입력되면 에러를 발생시킨다.")
    void roundGenerateTest(String input) {
        //When + Then
        assertThatThrownBy(() -> new Round(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수가 0보다 크면 true를 반환한다.")
    void isPossibleToRacingTestReturnTrue() {
        //Given
        Round round = new Round("1");

        //When
        boolean result = round.isPossibleToRacing();

        //Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("시도횟수가 0이하 였으면 false를 반환한다.")
    void isPossibleToRacingTestReturnFalse() {
        //Given
        Round round = new Round("1");

        //When
        round.minusTrialCount();
        boolean result = round.isPossibleToRacing();

        //Then
        assertThat(result).isFalse();
    }

}
