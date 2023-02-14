package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "jay", "jamie", "odo"})
    @DisplayName("생성자 이름 예외 테스트 : 성공 경우)")
    void test_name_constructor_success(String input) {
        // when
        CarName carName = new CarName(input);

        // then
        assertThat(carName.getName()).isEqualTo(carName.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"kokodak", "sunghaa"})
    @DisplayName("생성자 이름 예외 테스트 : 실패 경우 (이름이 5자 이상)")
    void test_name_constructor_fail_over_length_name(String carName) {
        // given
        String expectedMessage = "자동차 이름은 5자 이하로 작성해주세요.";

        // when & then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    @DisplayName("생성자 이름 예외 테스트 : 실패 경우 (이름이 null)")
    void test_name_constructor_fail_empty_name() {
        // given
        String carName = null;
        String expectedMessage = "자동차 이름을 입력해주세요.";

        // when & then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
