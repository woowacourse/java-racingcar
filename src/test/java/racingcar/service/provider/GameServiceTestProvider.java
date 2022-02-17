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

    public static Stream<Arguments> provideForInitCarNamesDuplicatedExceptionTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("ifif", "poby", "poby", "hello")),
                Arguments.of(Arrays.asList("hanul", "hello", "hanul", "ifif"))
        );
    }


}
