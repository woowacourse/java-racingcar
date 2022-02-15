package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingCarTest {

    @ParameterizedTest(name = "play() 공백 입력 예외 테스트 : {0}")
    @MethodSource("playEmptyInputExceptionTestSet")
    public void play_middle_empty_input_exception_test(String[] input) throws Exception {
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        RacingCar racingCar = new RacingCar();
        assertThatThrownBy(() -> racingCar.play())
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> playEmptyInputExceptionTestSet() {
        return Stream.of(
                Arguments.of((Object) new String[]{",name2,name3", "5"}),
                Arguments.of((Object) new String[]{"name1,,name3", "5"}),
                Arguments.of((Object) new String[]{"name1,name2,", "5"})
        );
    }
}
