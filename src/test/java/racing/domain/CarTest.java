package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 이름예외처리아무것도입력되지않았을때() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void 이름예외처리5글자초과시() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("abcdef");
        });
    }

    @Test
    void 포지션게터메서드() {
        assertThat(new Car("aaa").getPosition()).isEqualTo(0);
    }

    @Test
    void 포지션을스트링으로겟하면맞나요() {
        assertThat(new Car("aaa", 4).getStringPosition()).isEqualTo("----");
    }
}