package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("시도횟수가 문자열이 아닌지 검증한다.")
    void checkTryCountIsDigit() {
        InputStream customInputStream = new ByteArrayInputStream("123a".getBytes());
        System.setIn(customInputStream);
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> inputView.inputTryCount())
            .withMessageMatching("시도횟수는 숫자이어야 합니다.");
    }
}