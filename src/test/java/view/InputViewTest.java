package view;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사용자의 입력값은")
class InputViewTest extends IOTest {

    @Test
    @DisplayName("정상적일때 반복문을 돌지않고, 오류도 발생하지 않는다")
    void checkSuccess() {
        assertThatCode(() -> {
            systemIn("aa,bb,cc");
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("빈 값이나 공백이 들어왔을때 반복문을 돈다")
    @ValueSource(strings = {"", " "})
    void checkBlank(String input) {
        assertThatThrownBy(() -> {
            systemIn(input);
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isExactlyInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @DisplayName("이름 규칙에 맞지않는 값이 들어왔을때 반복문을 돈다")
    @ValueSource(strings = {"aa,bb,ccdddd", "aa, ,bb", "aa,,bb"})
    void carNameLength(String input) {
        assertThatThrownBy(() -> {
            systemIn(input);
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("한 대의 차만 입력되었을때 반복문을 돈다")
    void checkCommaExist() {
        assertThatThrownBy(() -> {
            systemIn("aa");
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("중복된 차 이름 일때 반복문을 돈다")
    void checkDuplication() {
        assertThatThrownBy(() -> {
            systemIn("aa,bb,bb");
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName(" 차 이름 앞 뒤의 공백이 있을 때 지워진다")
    void checkTrim() {
        systemIn(" aa ,bb ");
        InputView inputView = new InputView(new Scanner(System.in));
        List<String> list = inputView.askCarNames();
        assertThat(list.containsAll(List.of("aa", "bb"))).isTrue();
    }

    @DisplayName(" 차 이름이 길이에 맞지 않거나, 공백일때 반복문을 돈다")
    @ParameterizedTest
    @ValueSource(strings = {"asdafg", "qwerfds", "", "    "})
    void checkLength(String input) {
        assertThatThrownBy(() -> {
            systemIn(input);
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }
}
