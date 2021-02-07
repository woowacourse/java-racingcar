package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameDuplicateException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarNamesInputTest {
    @ParameterizedTest
    @DisplayName("자동차 이름은 쉼표로 구분한다")
    @MethodSource("provideInputsFor_자동차_이름_리스트_반환")
    public void getCarNames_자동차_이름은_쉼표로_구분한다(String input, List<String> expected) {
        CarNamesInput carNamesInput =  CarNamesInput.valueOf(input);
        assertEquals(expected, carNamesInput.getCarNames());
    }

    private static Stream<Arguments> provideInputsFor_자동차_이름_리스트_반환() {
        return Stream.of(
                Arguments.of("포비,로이드,워니", Arrays.asList("포비", "로이드", "워니")),
                Arguments.of("a,d", Arrays.asList("a", "d")),
                Arguments.of("q,d,e,g,c,s", Arrays.asList("q", "d", "e", "g", "c", "s"))
        );
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 중복이 있으면 예외")
    @ValueSource(strings = {"a,a,a", "a,b,c,a", "a,b,c,d,e,f,f"})
    public void getCarNames_자동차_이름에_중복이_있으면_예외(String input) {
        assertThatExceptionOfType(CarNameDuplicateException.class)
                .isThrownBy(() -> CarNamesInput.valueOf(input))
                .withMessageContaining(new CarNameDuplicateException().getMessage());
    }
}