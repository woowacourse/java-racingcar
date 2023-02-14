package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @Test
    void 차량_이름이_1자_이하일시_오류를_던진다() {
        assertThatThrownBy(() -> {
            new CarName("");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("자동차 이름 길이는 1자 이상, 5자 이하여야합니다.");
    }

    @Test
    void 차량_이름이_5자_초과일시_오류를_던진다() {
        assertThatThrownBy(() -> {
            new CarName("123456");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("자동차 이름 길이는 1자 이상, 5자 이하여야합니다.");
    }

    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    @ParameterizedTest
    void 차량_이름은_1자이상_5자이하여야한다(String name) {
        // when
        CarName carName = new CarName(name);
        // then
        assertThat(carName.getName()).isEqualTo(name);
    }
}
