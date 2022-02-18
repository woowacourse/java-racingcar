package racingcar.domain.car.provider;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

class CarsTestProvider {

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
                        1, Arrays.asList(false, true, true),
                        Arrays.asList("slow : ", "if : -", "poby : -")),
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        2, Arrays.asList(false, true, true, true, false, true),
                        Arrays.asList(
                                "slow : ", "if : -", "poby : -",
                                "slow : -", "if : -", "poby : --"))
        );
    }

    public static Stream<Arguments> provideForGetWinnerNamesTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        1, Arrays.asList(false, true, true),
                        Arrays.asList("if", "poby")),
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        2, Arrays.asList(false, true, true, true, false, true),
                        Arrays.asList("poby"))
        );
    }

}
