package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameTest {
    @ParameterizedTest
    @DisplayName("이름 입력받는 기능")
    @ValueSource(strings = {"샐리", "현구"})
    void carName_create(String value) {
        final CarName carName1 = new CarName(value);
        assertThat(carName1.getName()).isEqualTo(value);
    }

    @Test
    @DisplayName("이름이 5자 초과인 경우")
    void carName_length() {
        assertThatThrownBy(() -> new CarName("샐리와현구막")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름에 공백이 존재하는 경우")
    void carName_space_in_name() {
        assertThatThrownBy(() -> new CarName("샐리 와")).isInstanceOf(IllegalArgumentException.class);
    }
}