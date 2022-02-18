import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.enums.DomainErrorMessage;
import racingcar.view.enums.ViewErrorMessage;

public class ApplicationTest {

    @ParameterizedTest(name = "main() 테스트 : {0}")
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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainErrorMessage.EMPTY_CAR_NAME_ERROR_MESSAGE.get());
    }

    private static Stream<Arguments> emptyInputExceptionTestSet() {
        return Stream.of(
                Arguments.of((Object) new String[]{"", "5"}),
                Arguments.of((Object) new String[]{",name2,name3", "5"}),
                Arguments.of((Object) new String[]{"name1,,name3", "5"}),
                Arguments.of((Object) new String[]{"name1,name2,", "5"})
        );
    }

    @ParameterizedTest(name = "입력 길이 초과 예외 테스트 : {0}")
    @MethodSource("lengthOverInputExceptionTestSet")
    public void length_over_input_exception_test(String[] input) throws Exception {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> Application.main(new String[0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainErrorMessage.TOO_LONG_CAR_NAME_ERROR_MESSAGE.get());
    }

    private static Stream<Arguments> lengthOverInputExceptionTestSet() {
        return Stream.of(
                Arguments.of((Object) new String[]{"abcdef", "5"}),
                Arguments.of((Object) new String[]{"abcdef,name2,name3", "5"}),
                Arguments.of((Object) new String[]{"name1,abcdef,name3", "5"}),
                Arguments.of((Object) new String[]{"name1,name2,abcdef", "5"})
        );
    }

    @ParameterizedTest(name = "중복 입력 예외 테스트 : {0}")
    @MethodSource("duplicateInputExceptionTestSet")
    public void duplicate_car_name_input_exception_test(String[] input) throws Exception {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> Application.main(new String[0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainErrorMessage.DUPLICATE_CAR_NAME_ERROR_MESSAGE.get());
    }

    private static Stream<Arguments> duplicateInputExceptionTestSet() {
        return Stream.of(
                Arguments.of((Object) new String[]{"name1,name2,name1", "5"}),
                Arguments.of((Object) new String[]{"name1,name1,name1", "3"}),
                Arguments.of((Object) new String[]{"name1,name2,name2", "1"})
        );
    }

    @ParameterizedTest(name = "시도 횟수 공백 입력 예외 테스트 : {0}")
    @MethodSource("emptyAttemptExceptionTestSet")
    public void empty_exception_test(String[] input) throws Exception {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> Application.main(new String[0]))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining(ViewErrorMessage.EMPTY_INPUT_ERROR_MESSAGE.get());
    }

    private static Stream<Arguments> emptyAttemptExceptionTestSet() {
        return Stream.of(
                Arguments.of((Object) new String[]{"네오,제이슨,공원", ""})
        );
    }

    @ParameterizedTest(name = "시도 횟수 음수 입력 예외 테스트 : {0}")
    @MethodSource("negativeNumberInputExceptionTestSet")
    public void negative_number_input_exception_test(String[] input) throws Exception {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> Application.main(new String[0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainErrorMessage.NUMBER_NEGATIVE_ERROR_MESSAGE.get());
    }

    private static Stream<Arguments> negativeNumberInputExceptionTestSet() {
        return Stream.of(
                Arguments.of((Object) new String[]{"name1,name2,name3", "-5"}),
                Arguments.of((Object) new String[]{"포비,알린,티키", "-3"}),
                Arguments.of((Object) new String[]{"네오,제이슨,공원", "-1"})
        );
    }

    @ParameterizedTest(name = "시도 횟수 문자 입력 예외 테스트 : {0}")
    @MethodSource("numberFormatExceptionTestSet")
    public void number_format_exception_test(String[] input) throws Exception {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> Application.main(new String[0]))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(DomainErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.get());
    }

    private static Stream<Arguments> numberFormatExceptionTestSet() {
        return Stream.of(
                Arguments.of((Object) new String[]{"name1,name2,name3", "a"}),
                Arguments.of((Object) new String[]{"포비,알린,티키", "가"}),
                Arguments.of((Object) new String[]{"네오,제이슨,공원", " "})
        );
    }
}
