package racingcar.service.provider;

import java.util.Arrays;
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
                Arguments.of(Arrays.asList("", "poby", "hanul", "hello")),
                Arguments.of(Arrays.asList("hanul", "", "poby", "ifif"))
        );
    }

    public static Stream<Arguments> provideForInitCarNamesTooLongExceptionTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("abcdef", "poby", "hanul", "hello")),
                Arguments.of(Arrays.asList("hanul", "poby", "ififif"))
        );
    }

    public static Stream<Arguments> provideForInitCarNamesDuplicatedExceptionTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("ifif", "poby", "poby", "hello")),
                Arguments.of(Arrays.asList("hanul", "hello", "hanul", "ifif"))
        );
    }

    public static Stream<Arguments> provideForInitCarNamesTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("ifif", "poby", "hanul", "hello")),
                Arguments.of(Arrays.asList("hanul", "hello", "poby", "ifif"))
        );
    }

}
