package racingcar.view.input.provider;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class RoundInputTestProvider {

    public static Stream<Arguments> provideValuesForNotNumericException() {
        return Stream.of(
                Arguments.of("1a"),
                Arguments.of(""),
                Arguments.of("  "),
                Arguments.of(" b")
        );
    }

    public static Stream<Arguments> provideValuesForNormalInput() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("22", 22),
                Arguments.of(" 2", 2),
                Arguments.of("-3", -3)
        );
    }

}
