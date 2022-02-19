package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

class CarNameTest {

    @DisplayName("new CarName() 테스트")
    @Test
    void constructor_test() throws Exception {
        String carName = "name1";
        CarName name = new CarName(carName);
        assertThat(name.getName()).isEqualTo(carName);
    }

    @DisplayName("new CarName() 공백이 입력되었을 때 예외 테스트")
    @Test
    void constructor_empty_test() throws Exception {
        String carName = "";
        assertThatThrownBy(() -> new CarName(carName))
                .hasMessageContaining(ErrorMessage.CAR_NAME_EMPTY.getMessage());
    }

    @DisplayName("new CarName() 글자 수 초과 값이 입력되었을 때 예외 테스트")
    @Test
    void constructor_long_name_test() throws Exception {
        String carName = "abcdef";
        assertThatThrownBy(() -> new CarName(carName))
                .hasMessageContaining(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
    }
}
