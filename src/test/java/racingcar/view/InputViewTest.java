package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    public static InputStream generateStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    static Stream<Arguments> getNamesMethodSourceProvider() {
        return Stream.of(
            Arguments.arguments("pobi,woni,jun", 3),
            Arguments.arguments(",,,,", 5),
            Arguments.arguments(",pobi,", 3),
            Arguments.arguments(" , ,, , ", 5),
            Arguments.arguments("pobi", 1)
        );
    }

    @DisplayName("경주할 자동차 이름을 입력 받으면 쉼표를 기준으로 나눠 리스트를 반환한다.")
    @ParameterizedTest
    @MethodSource("getNamesMethodSourceProvider")
    void getNames_정상(String inputNames, int size) {
        // given
        System.setIn(generateStream(inputNames));
        InputView inputView = new InputView();

        // when
        String[] names = inputView.getCarNames();

        // then
        assertThat(names.length).isEqualTo(size);
    }

    @DisplayName("시도할 회수를 입력하면 시도 회수를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void getCount_정상(String inputCount) {
        // given
        System.setIn(generateStream(inputCount));
        InputView inputView = new InputView();

        // when
        String count = inputView.getCount();

        // then
        assertThat(count).isEqualTo(inputCount);
    }
}