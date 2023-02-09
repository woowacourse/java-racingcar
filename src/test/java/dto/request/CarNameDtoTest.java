package dto.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class CarNameDtoTest {

    @DisplayName("Car의 이름이 검증을 통과하면 예외를 발생시키지 않는다.")
    @Test
    void test1() {
        assertThatNoException().isThrownBy(() -> new CarNameDto("자동차"));
    }

    @DisplayName("Car의 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    void test2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarNameDto("잘못된자동차이름"));
    }

    @DisplayName("Car의 이름에 공백이 포함되면 예외를 발생시킨다.")
    @Test
    void test3() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarNameDto(" bad"));
    }
}