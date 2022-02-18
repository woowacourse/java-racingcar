package racingcar.domain.car.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

class CarsTestProvider {

    public static Stream<Arguments> provideForDuplicateExceptionTest() {
        return Stream.of(
                Arguments.of(List.of("slow", "if", "slow")),
                Arguments.of(List.of("slow", "if", "test", "test"))
        );
    }

    public static Stream<Arguments> provideForConstructorTest() {
        return Stream.of(
                Arguments.of(List.of("slow", "if", "poby", "hello")),
                Arguments.of(List.of("poby", "sinb", "slow", "hello")),
                Arguments.of(List.of("123", "a-bd", "cc sd", "a"))
        );
    }

    public static Stream<Arguments> provideForPlayRoundTest() {
        return Stream.of(
                Arguments.of(
                        List.of("slow", "if", "poby"),
                        1, List.of(false, true, true),
                        List.of("slow : ", "if : -", "poby : -")),
                Arguments.of(
                        List.of("slow", "if", "poby"),
                        2, List.of(false, true, true, true, false, true),
                        List.of(
                                "slow : ", "if : -", "poby : -",
                                "slow : -", "if : -", "poby : --"))
        );
    }

    public static Stream<Arguments> provideForGetWinnerNamesTest() {
        return Stream.of(
                Arguments.of(
                        List.of("slow", "if", "poby"),
                        1, List.of(false, true, true),
                        List.of("if", "poby")),
                Arguments.of(
                        List.of("slow", "if", "poby"),
                        2, List.of(false, true, true, true, false, true),
                        List.of("poby"))
        );
    }

}
