package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("이름 입력받는 기능")
    void carName_create() {
        final CarName carName1 = new CarName("샐리");
        final CarName carName2 = new CarName("현구막");
        assertThat(carName1.getName()).isEqualTo("샐리");
        assertThat(carName2.getName()).isEqualTo("현구막");
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