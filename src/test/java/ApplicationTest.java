import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ApplicationTest {

    @ParameterizedTest(name = "main() 테스트 : {0},[1]")
    @MethodSource("correctInputTestSet")
    public void main_test(String[] input) throws Exception {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Application.main(new String[0]);

        String out = output.toString();
        String[] names = input[0].split(",");
        assertThat(out).contains("시도할 회수는 몇회인가요?", "실행 결과");
        assertThat(out).contains(names);
        assertThat(out.startsWith("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")).isTrue();
        assertThat(out.endsWith("최종 우승했습니다.")).isTrue();
    }

    private static Stream<Arguments> correctInputTestSet() {
        return Stream.of(
                Arguments.of((Object) new String[]{"name1,name2,name3", "5"}),
                Arguments.of((Object) new String[]{"포비,알린,티키", "3"}),
                Arguments.of((Object) new String[]{"네오,제이슨,공원", "1"})
        );
    }

    @ParameterizedTest(name = "공백 입력 예외 테스트 : {0}")
    @MethodSource("emptyInputExceptionTestSet")
    public void empty_input_exception_test(String[] input) throws Exception {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> Application.main(new String[0]))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> emptyInputExceptionTestSet() {
        return Stream.of(
                Arguments.of((Object) new String[]{",name2,name3", "5"}),
                Arguments.of((Object) new String[]{"name1,,name3", "5"}),
                Arguments.of((Object) new String[]{"name1,name2,", "5"})
        );
    }
}
