package racingcar.domain.provider;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

class CarsTestProvider {

    public static Stream<Arguments> provideForNullExceptionTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("if", null, "hanul")),
                Arguments.of(Arrays.asList("if", "hanul", null))
        );
    }

    public static Stream<Arguments> provideForEmptyExceptionTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("")),
                Arguments.of(Arrays.asList("if", "hanul", ""))
        );
    }

    public static Stream<Arguments> provideForLengthExceptionTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("slow", "if", "hanull")),
                Arguments.of(Arrays.asList("sinb57", "slow", "if")),
                Arguments.of(Arrays.asList("sinb57", "slow", "if", "hanull"))
        );
    }

    public static Stream<Arguments> provideForDuplicateExceptionTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("slow", "if", "slow")),
                Arguments.of(Arrays.asList("slow", "if", "test", "test"))
        );
    }

    public static Stream<Arguments> provideForConstructorTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("slow", "if", "poby", "hello")),
                Arguments.of(Arrays.asList("poby", "sinb", "slow", "hello")),
                Arguments.of(Arrays.asList("123", "a-bd", "cc sd", "a"))
        );
    }

    public static Stream<Arguments> provideForPlayRoundTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        1, Arrays.asList(3,4,5),
                        Arrays.asList("slow : ", "if : -", "poby : -")),
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        2, Arrays.asList(0,5,8, 7,3,4),
                        Arrays.asList(
                                "slow : ", "if : -", "poby : -",
                                "slow : -", "if : -", "poby : --"))
        );
    }

    public static Stream<Arguments> provideForGetWinnerNamesTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        1, Arrays.asList(0,5,8),
                        Arrays.asList("if", "poby")),
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        2, Arrays.asList(0,5,8, 7,3,4),
                        Arrays.asList("poby"))
        );
    }

}
