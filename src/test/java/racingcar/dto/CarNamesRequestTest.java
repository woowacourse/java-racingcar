package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesRequestTest {
    @DisplayName("자동차 입력 후 DTO 바인딩 시 정상 테스트")
    @Test
    void carNamesRequestTest() {
        String inputCarNames = "썬샷,헤나,루카";
        assertThat(new CarNamesRequest(inputCarNames).getCarNames()).containsExactly("썬샷", "헤나", "루카");
    }

    @DisplayName("자동차 입력 후 DTO 바인딩 시 공백 및 빈 이름 실패 테스트")
    @ParameterizedTest(name = "inputCarNames = {0}")
    @ValueSource(strings = {"", ",,", " ,      , ", ""})
    void carNamesRequestNullOrBlankExceptionTest(String inputCarNames) {
        assertThatThrownBy(() -> new CarNamesRequest(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 입력 후 DTO 바인딩 시 다섯 글자 이상 이름 실패 테스트")
    @ParameterizedTest(name = "inputCarNames = {0}")
    @ValueSource(strings = {"123456", "1234567", "aaaaaa", "ㅁㅁㅁㅁㅁㅁㅁ"})
    void carNamesRequestOverLengthExceptionTest(String inputCarNames) {
        assertThatThrownBy(() -> new CarNamesRequest(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 갯수 0개거나 1개일 때 에러 발생 테스트")
    @ParameterizedTest(name = "inputCarNames = {0}")
    @ValueSource(strings = {"", "12345"})
    void carNamesRequestOneOrZero(String inputCarNames) {
        assertThatThrownBy(() -> new CarNamesRequest(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
