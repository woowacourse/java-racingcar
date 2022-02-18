package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.enums.DomainErrorMessage;

public class CarNameTest {

    @DisplayName("CarName() 테스트")
    @Test
    public void constructor_test() throws Exception {
        String carName = "name1";
        CarName name = new CarName(carName);
        assertThat(name.get()).isEqualTo(carName);
    }

    @ParameterizedTest(name = "CarName() 공백 입력 예외 테스트")
    @EmptySource
    public void empty_input_test(String input) throws Exception {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainErrorMessage.EMPTY_CAR_NAME_ERROR_MESSAGE.get());
    }

    @ParameterizedTest(name = "CarName() 글자 수 초과 입력 예외 테스트")
    @ValueSource(strings = {"abcdef", "1234567890"})
    public void over_length_input_test(String input) throws Exception {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainErrorMessage.TOO_LONG_CAR_NAME_ERROR_MESSAGE.get());
    }
}
