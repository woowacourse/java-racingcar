package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.ConsoleTest;
import racingcar.config.ViewConfig;

class InputViewTest extends ConsoleTest {

    private InputView inputView;

    @Test
    void inputCarNameSingle() {
        changeInput("pobi");
        changeOutput();
        inputView = ViewConfig.getInputView();
        String carName = inputView.inputCarNames();

        Assertions.assertThat(outputStream.toString())
            .contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Assertions.assertThat(carName).isEqualTo("pobi");
    }

    @Test
    void inputRoundNumber() {
        changeOutput();
        changeInput("5");
        inputView = ViewConfig.getInputView();
        String inputNumber = inputView.inputRoundNumber();

        Assertions.assertThat(outputStream.toString()).contains("시도할 회수는 몇회인가요?");
        Assertions.assertThat(inputNumber).isEqualTo("5");
    }
}
