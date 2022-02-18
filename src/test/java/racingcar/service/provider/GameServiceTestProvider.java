package racingcar.service.provider;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class GameServiceTestProvider {

    public static Stream<Arguments> provideForPlayRoundTest() {
        return Stream.of(
                Arguments.of(
                        List.of(true, true, false, false),
                        1, List.of(1, 1, 0, 0)
                ),
                Arguments.of(
                        List.of(
                                false, true, true, false,
                                false, true, false, true
                        ),
                        2, List.of(0, 2, 1, 1)
                )
        );
    }

    public static Stream<Arguments> provideForGetWinnerNamesTest() {
        return Stream.of(
                Arguments.of(
                        List.of(true, true, false, false),
                        1, List.of("hello", "poby")

                ),
                Arguments.of(
                        List.of(
                                false, true, true, false,
                                false, true, false, true
                        ),
                        2, List.of("poby")
                )
        );
    }

}
