package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    InputView inputView;
    InputStream inputStream;

    @AfterEach
    void close() throws Exception {
        inputStream.close();
    }

    @DisplayName("carNames 입력시 콤마를 기준으로 올바르게 분할하는지 확인하는 테스트")
    @ParameterizedTest(name = "자동차 이름 입력 = {0}ㅅ 자동차 개수 = {1}")
    @MethodSource("carNamesDummy")
    void splitCarsNamesInputSuccessTest(String carNamesInput, int expected) {
        inputStream = new ByteArrayInputStream(carNamesInput.getBytes());
        System.setIn(inputStream);

        inputView = new InputView();
        List<String> carNames = inputView.inputCarNames();
        assertThat(carNames).hasSize(expected);
    }

    static Stream<Arguments> carNamesDummy() {
        return Stream.of(
                Arguments.arguments("pobi, crong, honux", 3),
                Arguments.arguments("pobi, crong", 2),
                Arguments.arguments("pobi", 1)
        );
    }
}
