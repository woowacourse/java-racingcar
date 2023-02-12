package racinggame.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTest {
    private static Input input;

    @BeforeAll
    static void setup() {
        input = new Input();
    }

    @Test
    @DisplayName("car 객체들이 names 를 , 로 구분하여 각각 잘 생성되는지 확인하는 테스트")
    void create_success() {
        String names = "포비,제나,제리";
        assertThat(input.getCarNames(names)).containsExactly("포비", "제나", "제리");
    }

    @Test
    @DisplayName("names 에 빈문자가 들어갔을 때 에러 확인하는 테스트")
    void blank_name() {
        String names = ",";
        assertThatThrownBy(() -> input.getCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 빈 ");
    }

    @Test
    @DisplayName("이름 길이가 1~5 자가 아닐 때 에러 확인하는 테스트")
    void name_length() {
        String names = "";
        assertThatThrownBy(() -> input.getCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 이름 길이");
    }

    @Test
    @DisplayName("이름 중복 에러 확인 테스트")
    void name_duplicate() {
        String names = "포비,제리,제리";
        assertThatThrownBy(() -> input.getCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : ", "중복");

    }

    @Test
    void trycount_success() {
        String n = "123";
        assertThat(input.getTryCount(n)).isEqualTo(123);
    }

    @Test
    @DisplayName("시도 횟수가 음수로 들어왔을 때 에러를 확인하는 테스트")
    void trycount_negative() {
        String n = "-123";
        assertThatThrownBy(() -> input.getTryCount(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", "숫자");
    }

    @Test
    @DisplayName("시도 횟수가 0일 때 에러를 확인하는 테스트")
    void trycount_zero() {
        String n = "0";
        assertThatThrownBy(() -> input.getTryCount(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", "1이상");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 때 에러를 확인하는 테스트")
    void trycount_nondigit() {
        String n = "abc";
        assertThatThrownBy(() -> input.getTryCount(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]", "숫자");
    }
}
