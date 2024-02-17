package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @Test
    @DisplayName("1글자 글자 이름은 정상인가")
    void car_created_by_1_name_test() {
        assertThatCode(() -> new Car("A"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("5글자 글자 이름은 정상인가")
    void car_created_by_5_name_test() {
        assertThatCode(() -> new Car("ABCDE"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름이 5글자 초과면 예외가 발생하는가")
    void car_created_by_more_than_5_name_test() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("ABCDEF"));
    }

    @Test
    @DisplayName("이름이 1글자 미만이면 예외가 발생하는가")
    void car_created_by_less_than_1_name_test() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(""));
    }
}
