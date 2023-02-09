package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = InputView.getInstance();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void readCarNamesTest() {
        String carNames = "성하,이오,제이";
        InputStream in = generateUserInput(carNames);
        System.setIn(in);

        Assertions.assertThat(inputView.readCarNames()).containsExactly("성하", "이오", "제이");
    }

    @Test
    @DisplayName("자동차 이름이 빈 값인 경우 예외 처리")
    void carNamesBlankTest() {
        String carNames = "\n";
        InputStream in = generateUserInput(carNames);
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"이오,이오,성하\n", "이오,성하,성하\n"})
    @DisplayName("구분한 자동차 이름이 중복된 경우")
    void carNamesDuplicateTest(String carNames) {
        InputStream in = generateUserInput(carNames);
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"이오이오이오, 성하\n", "재이재이재이,이오이오이오이\n"})
    @DisplayName("구분한 자동차 이름이 5글자 초과인 경우")
    void eachCarNameLengthTest(String carNames) {
        InputStream in = generateUserInput(carNames);
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"이오이오,,\n", ",,성하\n"})
    @DisplayName("구분한 자동차 이름이 빈 값인 경우")
    void eachCarNameBlankTest(String carNames) {
        InputStream in = generateUserInput(carNames);
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수 입력 테스트")
    void readTryNumTest() {
        String tryNum = "5";
        InputStream in = generateUserInput(tryNum);
        System.setIn(in);

        Assertions.assertThat(inputView.readTryNum()).isEqualTo(5);
    }

    @Test
    @DisplayName("시도할 횟수가 빈 값인 경우 예외 테스트")
    void readTryNumBlankTest() {
        String tryNum = "\n";
        InputStream in = generateUserInput(tryNum);
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> inputView.readTryNum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.5\n", "-0.5\n"})
    @DisplayName("시도할 횟수가 정수가 아닌 경우 예외 테스트")
    void readTryNumIntegerTest(String tryNum) {
        InputStream in = generateUserInput(tryNum);
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> inputView.readTryNum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1\n", "0\n"})
    @DisplayName("시도할 횟수가 0 이하인 경우 예외 테스트")
    void readTryNumNotPositiveTest(String tryNum) {
        InputStream in = generateUserInput(tryNum);
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> inputView.readTryNum())
                .isInstanceOf(IllegalArgumentException.class);
    }
}