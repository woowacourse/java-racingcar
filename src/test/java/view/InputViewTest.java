package view;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest extends IOTest {

    @Test
    @DisplayName("차의 이름들이 정상적으로 입력되었을때 반복문을 돌지않고, 오류도 발생하지 않는다")
    void checkSuccess() {
        assertDoesNotThrow(() -> {
            systemIn("aa,bb,cc");
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        });
    }

    @ParameterizedTest
    @DisplayName("차의 이름들에 대해 빈 값이나 공백이 들어왔을때 반복문을 돈다")
    @ValueSource(strings = {"", " "})
    void checkBlank(String input) {
        assertThatThrownBy(() -> {
            systemIn(input);
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isExactlyInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("한 대의 차의 이름만 입력되었을때 반복문을 돈다")
    void checkCommaExist() {
        assertThatThrownBy(() -> {
            systemIn("aa");
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("중복된 차 이름 입력 됐을때 반복문을 돈다")
    void checkDuplication() {
        assertThatThrownBy(() -> {
            systemIn("aa,bb,bb");
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("차 이름 앞 뒤의 공백이 있을 때 지워진다")
    void checkTrim() {
        systemIn(" aa ,bb ");
        InputView inputView = new InputView(new Scanner(System.in));
        List<String> list = inputView.askCarNames();
        assertThat(list.containsAll(List.of("aa", "bb"))).isTrue();
    }

    @DisplayName("차 이름이 길이에 맞지 않거나, 공백일때 반복문을 돈다")
    @ParameterizedTest
    @ValueSource(strings = {"asdafg", "qwerfds", "", "    "})
    void checkCarNameLength(String input) {
        assertThatThrownBy(() -> {
            systemIn(input);
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @DisplayName("시도 횟수에, 숫자가 아닌 값들이 들어오면 오류가 발생하는지 확인한다")
    @ValueSource(strings = {"3ge", "~45", "2!9", "d"})
    void checkCharTrial(String input) {
        assertThatThrownBy(() -> {
            systemIn(input);
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @DisplayName("시도 횟수에 int가 아닌 숫자값들이 들어오면 오류가 발생하는지 확인한다")
    @ValueSource(strings = {"78.4", "37.26787"})
    void checkTrialNotInt(String input) {
        assertThatThrownBy(() -> {
            systemIn(input);
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @DisplayName("시도 횟수에 범위에 맞지 않는 값이 들어오면 오류가 발생하는지 알아본다")
    @ValueSource(strings = {"0", "-33"})
    void checkTrialOutOfRange(String input) {
        assertThatThrownBy(() -> {
            systemIn(input);
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("시도횟수의 입력값이 int 범위를 넘어가면 오류가 발생하는지 알아본다")
    void checkTrialExtreme() {
        assertThatThrownBy(() -> {
            systemIn("496574567843567");
            InputView inputView = new InputView(new Scanner(System.in));
            inputView.askCarNames();
        }).isInstanceOf(NoSuchElementException.class);
    }
}
