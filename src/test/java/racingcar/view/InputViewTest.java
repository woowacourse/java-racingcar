package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.Car.BLANK_ERROR_MESSAGE;
import static racingcar.domain.Car.NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.domain.Cars.DUPLICATE_NAME_ERROR_MESSAGE;
import static racingcar.domain.RacingGame.NOT_NUMBER_ERROR_MESSAGE;
import static racingcar.domain.RacingGame.UNAVAILABLE_NUMBER_OF_ROUNDS_MESSAGE;

public class InputViewTest {
    private Scanner scanner;

    @DisplayName("name 입력 받을 떄 이름에 공백이 있는 것을 검증해주는지")
    @Test
    void takeNameInput_blankInName_throwIllegalArgumentException() {
        InputStream in = generateUserInput("포비 ");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(() -> InputView.takeNameInput(scanner)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_ERROR_MESSAGE);
    }

    @DisplayName("name 입력 받을 떄 이름 길이가 1 미만 혹은 5 초과인 것을 검증해주는지")
    @ParameterizedTest
    @ValueSource(strings = {"\n", "포비넌너무멋져남자가봐도반하겠어"})
    void takeNameInput_nameLengthOutOfBounds_throwIllegalArgumentException(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(() -> InputView.takeNameInput(scanner)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("name 입력 받을 떄 중복된 이름 있는 것을 검증해주는지")
    @Test
    void takeNameInput_duplicateNames_throwIllegalArgumentException() {
        InputStream in = generateUserInput("포비,포비,삭정,웨지");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(() -> InputView.takeNameInput(scanner)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NAME_ERROR_MESSAGE);
    }

    @DisplayName("총 라운드 횟수 입력 받을 떄 정수가 아닌 것을 검증해주는지")
    @Test
    void takeNumberOfRoundsInput_nonIntegerInput_throwIllegalArgumentException() {
        InputStream in = generateUserInput("라운드횟수:5");
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(() -> InputView.takeNumberOfRoundsInput(scanner)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER_ERROR_MESSAGE);
    }

    @DisplayName("총 라운드 횟수 입력 받을 떄 0이나 음수인 것을 검증해주는지")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-2"})
    void takeNumberOfRoundsInput_zeroOrNegativeInteger_throwIllegalArgumentException(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(() -> InputView.takeNumberOfRoundsInput(scanner)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UNAVAILABLE_NUMBER_OF_ROUNDS_MESSAGE);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @AfterEach
    void closeScanner() {
        scanner.close();
    }
}