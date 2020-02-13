package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void validateName_적합한_이름() {
        new Car("타미");
    }

    @Test
    void validateName_부적합한_이름길이() {
        assertThatThrownBy(() ->  new Car("우아한 형제들"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateName_빈문자열() {
        assertThatThrownBy(() ->  new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
