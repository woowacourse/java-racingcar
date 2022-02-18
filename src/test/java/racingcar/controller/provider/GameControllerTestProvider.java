package racingcar.controller.provider;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class GameControllerTestProvider {

    public static Stream<Arguments> provideForInitGameTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("hello, poby, ifif, hanul", "3"),
                        Arrays.asList("hello", "poby", "ifif", "hanul"), 3),
                Arguments.of(
                        Arrays.asList("hanul, poby, ifif", "2"),
                        Arrays.asList("hanul", "poby", "ifif"), 2)
        );
    }

}
