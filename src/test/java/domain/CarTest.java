package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("이름이 5글자 초과면 예외가 발생하는가")
    void car_created_by_more_than_5_name_test() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("abccccc");
        });
    }

    @Test
    @DisplayName("이름이 1글자 미만이면 예외가 발생하는가")
    void car_created_by_less_than_1_name_test() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("");
        });
    }
}