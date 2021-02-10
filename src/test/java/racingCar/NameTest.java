package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    public void name_equals() {
        Name name = new Name("aaa");

        assertThat(name).isEqualTo(new Name("aaa"));
    }

    @Test
    @DisplayName("자동차 이름 유효성 검사")
    public void name_length() {
        assertThatThrownBy(()->{
            new Name("abcdefg");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}