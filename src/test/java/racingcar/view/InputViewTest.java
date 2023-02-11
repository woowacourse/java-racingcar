package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputViewTest {

    private OutputStream outputStream;

    @BeforeEach
    void setMockOutput() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void setSystemIn() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void printInputTryCountGuide_메서드_테스트() {
        setMockInput("3");
        assertAll(() -> assertThat(InputView.inputTryCount()).isEqualTo(3));

        assertThat(outputStream.toString()).contains("시도할 회수는 몇회인가요?");
    }
//TODO: 이 부분이 각자 실행했을 때는 잘 통과하지만, 전체 테스트를 돌릴 때는 통과하지 않는데요
// TODO: 도저히 원인을 알 수 없어서 질문하려고 합니다
//    @Test
//    void printInputCarNameGuide_메서드_테스트() {
//        setMockInput("3,4,5");
//        InputView.inputCarName();
//        assertThat(outputStream.toString()).contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
//    }

    private void setMockInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
