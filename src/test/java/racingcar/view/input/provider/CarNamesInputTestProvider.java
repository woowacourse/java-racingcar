package racingcar.view.input.provider;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

class CarNamesInputTestProvider {

    public static Stream<Arguments> provideValuesForNormalInput() {
        return Stream.of(
                Arguments.of("aaa,bbb,ccc", List.of("aaa", "bbb", "ccc")),
                Arguments.of("aaa   , bbb ,cc  c", List.of("aaa", "bbb", "cc  c")),
                Arguments.of("aaa,bb,,aa,a", List.of("aaa", "bb", "", "aa", "a")),
                Arguments.of("aaa,bb,,,", List.of("aaa", "bb", "", "", "")),
                Arguments.of("aaa,bb,-----,,df\\asf", List.of("aaa", "bb", "-----", "", "df\\asf"))
        );
    }

}
