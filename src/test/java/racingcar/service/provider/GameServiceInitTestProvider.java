package racingcar.service.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class GameServiceInitTestProvider {

    public static Stream<Arguments> provideForInitCarNamesNullExceptionTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(null, "poby", "hanul", "hello")),
                Arguments.of(Arrays.asList("hanul", "hello", null, "ifif"))
        );
    }

    public static Stream<Arguments> provideForInitCarNamesEmptyExceptionTest() {
        return Stream.of(
                Arguments.of(List.of("", "poby", "hanul", "hello")),
                Arguments.of(List.of("hanul", "", "poby", "ifif"))
        );
    }

    public static Stream<Arguments> provideForInitCarNamesTooLongExceptionTest() {
        return Stream.of(
                Arguments.of(List.of("abcdef", "poby", "hanul", "hello")),
                Arguments.of(List.of("hanul", "", "poby", "ififif"))
        );
    }

    public static Stream<Arguments> provideForInitCarNamesDuplicatedExceptionTest() {
        return Stream.of(
                Arguments.of(List.of("ifif", "poby", "poby", "hello")),
                Arguments.of(List.of("hanul", "hello", "hanul", "ifif"))
        );
    }

    public static Stream<Arguments> provideForInitCarNamesTest() {
        return Stream.of(
                Arguments.of(List.of("ifif", "poby", "hanul", "hello")),
                Arguments.of(List.of("hanul", "hello", "poby", "ifif"))
        );
    }

}
