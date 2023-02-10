package dto.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Car.BLANK_CONTAIN_NAME_EXCEPTION_MESSAGE;
import static domain.Car.NAME_LENGTH_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class CarNameDtoTest {

    @DisplayName("CarNameDto의 이름이 검증을 통과하면 예외를 발생시키지 않는다.")
    @Test
    void create_success() {
        assertThatNoException().isThrownBy(() -> new CarNameDto("자동차"));
    }

    @DisplayName("CarNameDto의 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    void fail_by_name_length_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarNameDto("잘못된자동차이름"))
                .withMessageContaining(NAME_LENGTH_EXCEPTION_MESSAGE);
    }

    @DisplayName("CarNameDto의 이름에 공백이 포함되면 예외를 발생시킨다.")
    @Test
    void fail_by_contain_blank_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarNameDto(" bad"))
                .withMessageContaining(BLANK_CONTAIN_NAME_EXCEPTION_MESSAGE);
    }
}