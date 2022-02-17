package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OutputViewTest {

    private static OutputStream generateStream() {
        return new ByteArrayOutputStream();
    }

    private static Stream<Arguments> printResultMethodSourceProvider() {
        return Stream.of(
            Arguments.arguments(List.of("pobi", "woni", "jun"), "pobi, woni, jun가 최종 우승했습니다.\n"),
            Arguments.arguments(List.of("pobi", "woni"), "pobi, woni가 최종 우승했습니다.\n"),
            Arguments.arguments(List.of("pobi"), "pobi가 최종 우승했습니다.\n")
        );
    }

    @DisplayName("우승자 이름 리스트가 주어지면 ,로 연결하여 메시지를 출력한다.")
    @ParameterizedTest
    @MethodSource("printResultMethodSourceProvider")
    void printResult_정상(List<String> winners, String resultMessage) {
        // given
        OutputStream outputStream = generateStream();
        System.setOut(new PrintStream(outputStream));
        OutputView outputView = new OutputView();

        // when
        outputView.printResult(winners);

        // then
        assertThat(outputStream.toString()).isEqualTo(resultMessage);
    }
}