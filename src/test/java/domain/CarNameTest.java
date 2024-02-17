package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 이름 테스트")
class CarNameTest {
    
    @DisplayName("이름이 5자가 넘어가면 생성에 검증에 실패한다")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567", "9999999999999"})
    void testCreateCarWithInvalidLengthName(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름의 길이는 1 이상 5 이하여야 합니다");
    }

    @DisplayName("이름이 5자가 넘어가지 않으면 생성 검증에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "123", "12"})
    void testCreateCarWithValidLengthName(String carName) {
        assertThatCode(() -> new CarName(carName)).doesNotThrowAnyException();
    }
}