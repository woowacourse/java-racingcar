package racingcar.service.provider;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class GameServiceTestProvider {

    public static Stream<Arguments> provideForPlayRoundTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(true, true, false, false),
                        1, Arrays.asList(1, 1, 0, 0)
                ),
                Arguments.of(
                        Arrays.asList(
                                false, true, true, false,
                                false, true, false, true
                        ),
                        2, Arrays.asList(0, 2, 1, 1)
                )
        );
    }

    public static Stream<Arguments> provideForGetWinnerNamesTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(true, true, false, false),
                        1, Arrays.asList("hello", "poby")

                ),
                Arguments.of(
                        Arrays.asList(
                                false, true, true, false,
                                false, true, false, true
                        ),
                        2, Arrays.asList("poby")
                )
        );
    }

}
