import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.InputView;

class InputViewTest {
    InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView();
    }

    @Test
    void getCarNamesTest() {
        String names = "포비,제나,제리";
        assertThat(inputView.getCarNames(names)).containsExactly("포비", "제나", "제리");
    }

    @Test
    void getCarNamesBlankTest() {
        String name = " ";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 빈 ");
    }

    @Test
    void getCarNamesLengthTest() {
        String name = "";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 빈 이름은 들어올 수 없습니다");
    }

    @Test
    void getCarNamesDuplicateTest() {
        String names = "포비,제리,제리";
        assertThatThrownBy(() -> inputView.getCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : ", "중복");

    }

    @Test
    void getTryCountTest() {
        String n = "10";
        assertThat(inputView.getTryCount(n)).isEqualTo(10);
    }

    @Test
    void getTryCountNegativeTest() {
        String n = "-123";
        assertThatThrownBy(() -> inputView.getTryCount(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", "숫자");
    }

    @Test
    void getTryCountZeroTest() {
        String n = "0";
        assertThatThrownBy(() -> inputView.getTryCount(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", "1이상");
    }

    @Test
    void getTryCountNonDigitTest() {
        String n = "abc";
        assertThatThrownBy(() -> inputView.getTryCount(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", "숫자");
    }
}