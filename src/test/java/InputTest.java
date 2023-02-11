import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.Input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTest {
    Input input;

    @BeforeEach
    void setup() {
        input = new Input();
    }

    @Test
    void getCarNamesTest() {
        String names = "포비,제나,제리";
        assertThat(input.getCarNames(names)).containsExactly("포비", "제나", "제리");
    }

    @Test
    void getCarNamesBlankTest() {
        String names = ",";
        assertThatThrownBy(() -> input.getCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 빈 ");
    }

    @Test
    void getCarNamesLengthTest() {
        String names = "";
        assertThatThrownBy(() -> input.getCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 이름 길이");
    }

    @Test
    void getCarNamesDuplicateTest() {
        String names = "포비,제리,제리";
        assertThatThrownBy(() -> input.getCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : ", "중복");

    }

    @Test
    void getTryCountTest() {
        String n = "123";
        assertThat(input.getTryCount(n)).isEqualTo(123);
    }

    @Test
    void getTryCountNegativeTest() {
        String n = "-123";
        assertThatThrownBy(() -> input.getTryCount(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", "숫자");
    }

    @Test
    void getTryCountZeroTest() {
        String n = "0";
        assertThatThrownBy(() -> input.getTryCount(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", "1이상");
    }

    @Test
    void getTryCountNonDigitTest() {
        String n = "abc";
        assertThatThrownBy(() -> input.getTryCount(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", "숫자");
    }
}
