package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void name_공백으로_들어온경우() {
        assertThatThrownBy(() -> {
            new Name(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("이름으로 공백을 입력할 수 없습니다.");
    }

    @Test
    public void name_자동차이름은_5자이하() {
        assertThatThrownBy(() -> {
            new Name("joanne");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("이름은 1자 이상, 5자 이내만 가능합니다.");
    }

}
