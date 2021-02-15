package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름 생성 확인")
    public void name_equals() {
        CarName carName = new CarName("aaa");

        assertThat(carName).isEqualTo(new CarName("aaa"));
    }

    @Test
    @DisplayName("자동차 이름 유효성 검사")
    public void name_length() {
        assertThatThrownBy(() -> {
            new CarName("abcdefg");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new CarName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}