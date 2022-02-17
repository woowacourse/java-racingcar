package racingcar.service.provider;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class GameServiceTestProvider {

    public static Stream<Arguments> provideForInitCarNamesTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("ifif", "poby", "hanul", "hello")),
                Arguments.of(Arrays.asList("hanul", "hello", "poby", "ifif"))
        );
    }

}
