package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.MockController.extractCarNames;

class CarFactoryTest {

    private static final int START_POINT = 0;

    private static Stream<Arguments> provideUnderLengthNames_Or_BlankNames() {
        return Stream.of(
                Arguments.of(extractCarNames("pobi, crong,   ")),
                Arguments.of(extractCarNames("pobi,,crong")),
                Arguments.of(extractCarNames(",pobi,honux"))
        );
    }

    private static Stream<Arguments> provideBlankNamesAfterDelimiter_And_SizeOfList() {
        return Stream.of(
                Arguments.of(extractCarNames(",,,"), 0), //구분자 뒤에 아무것도 없으면 문자열이 생성되지 않는다.
                Arguments.of(extractCarNames("pobi,crong,"), 2)
        );
    }

    @Nested
    @DisplayName("자동차 이름에 대한 예외 테스트")
    class CarNameTest {

        @Test
        @DisplayName("5자를 초과하는 자동차 이름이 있으면 예외가 발생한다.")
        void overLengthCarNameTest() {
            List<String> carNames = List.of("pobi, crong, abcdefghijk");

            assertThatThrownBy(() -> CarFactory.generate(carNames, START_POINT))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름의 길이는 1이상 5이하여야 합니다.");
        }

        @ParameterizedTest
        @MethodSource("racingcar.domain.CarFactoryTest#provideUnderLengthNames_Or_BlankNames")
        @DisplayName("이름이 1자 미만이나 빈칸으로만 이루어진 자동차 이름이 있으면 예외가 발생한다.")
        void underLengthCarNameTest(List<String> carNames) {
            assertThatThrownBy(() -> CarFactory.generate(carNames, START_POINT))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름의 길이는 1이상 5이하여야 합니다.");
        }

        @ParameterizedTest
        @MethodSource("racingcar.domain.CarFactoryTest#provideBlankNamesAfterDelimiter_And_SizeOfList")
        @DisplayName("구분자\",\" 다음의 자동차 이름이 1자 미만이면 해당 문자열이 생성되지 않는다.")
        void BlankCarNameTest(List<String> carNames, int carsCount) {
            List<Car> cars = CarFactory.generate(carNames, START_POINT);
            assertThat(cars.size()).isEqualTo(carsCount);
        }

        @Test
        @DisplayName("차 이름이 중복되는 경우 예외가 발생한다.")
        void duplicatedCarNameTest() {
            List<String> duplicatedCarNames = extractCarNames("pobi, crong, pobi");

            assertThatThrownBy(() -> CarFactory.generate(duplicatedCarNames, START_POINT))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 중복되지 않아야 합니다.");
        }
    }
}
