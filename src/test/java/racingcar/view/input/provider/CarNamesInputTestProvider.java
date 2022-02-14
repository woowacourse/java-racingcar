package racingcar.view.input.provider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

public class CarNamesInputTestProvider {

    public static Stream<Arguments> provideValuesForNormalInput() {
        return Stream.of(
                Arguments.of("aaa,bbb,ccc", Arrays.asList("aaa", "bbb", "ccc")),
                Arguments.of("aaa   , bbb ,cc  c", Arrays.asList("aaa", "bbb", "cc  c")),
                Arguments.of("aaa,bb,,aa,a", Arrays.asList("aaa", "bb", "", "aa", "a")),
                Arguments.of("aaa,bb,,,", Arrays.asList("aaa", "bb", "", "", "")),
                Arguments.of("aaa,bb,-----,,df\\asf", Arrays.asList("aaa", "bb", "-----", "", "df\\asf"))
        );
    }

}
