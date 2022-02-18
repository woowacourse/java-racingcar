package racingcar.controller.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class GameControllerTestProvider {

    public static Stream<Arguments> provideForInitGameTest() {
        return Stream.of(
                Arguments.of(
                        List.of("hello, poby, ifif, hanul", "3"),
                        List.of("hello", "poby", "ifif", "hanul"), 3),
                Arguments.of(
                        List.of("hanul, poby, ifif", "2"),
                        List.of("hanul", "poby", "ifif"), 2)
        );
    }

    public static Stream<Arguments> provideForGetCarStatusesTest() {
        return Stream.of(
                Arguments.of(
                        List.of("hello, poby, ifif, hanul", "1"),
                        List.of(true, true, false, false),
                        List.of(1, 1, 0, 0)),
                Arguments.of(
                        List.of("hanul, poby, ifif", "2"),
                        List.of(
                                true, true, false,
                                false, true, false),
                        List.of(1, 2, 0))
        );
    }

    public static Stream<Arguments> provideForGetWinnerNamesTest() {
        return Stream.of(
                Arguments.of(
                        List.of("hello, poby, ifif, hanul", "1"),
                        List.of(true, true, false, false),
                        List.of("hello", "poby")),
                Arguments.of(
                        List.of("hanul, poby, ifif", "2"),
                        List.of(
                                true, true, false,
                                false, true, false),
                        List.of("poby"))
        );
    }

}
