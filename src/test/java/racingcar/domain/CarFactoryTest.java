package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFactoryTest {

    @Nested
    @DisplayName("자동차 이름에 대한 예외 테스트")
    class CarNameTest {
        @Test
        @DisplayName("5자를 초과하는 자동차 이름이 있으면 예외가 발생한다.")
        void overLengthCarNameTest() {
            String carNames = "pobi, crong, abcdefghijk";
            assertThatThrownBy(() -> CarFactory.generate(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름의 길이는 1이상 5이하여야 합니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"pobi, crong,   ", "pobi,,crong",",pobi,honux"})
        @DisplayName("이름이 1자 미만이나 빈칸으로만 이루어진 자동차 이름이 있으면 예외가 발생한다.")
        void underLengthCarNameTest(String carNames) {
            assertThatThrownBy(() -> CarFactory.generate(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름의 길이는 1이상 5이하여야 합니다.");
        }

        @ParameterizedTest
        @CsvSource(value = {",,,:0" , "pobi,crong,,:2"}, delimiter= ':')
        @DisplayName("구분자\",\" 다음의 자동차 이름이 1자 미만이면 해당 문자열이 생성되지 않는다.")
        void BlankCarNameTest(String carNames, int carsCount) {
            List<Car> cars = CarFactory.generate(carNames);
            assertThat(cars.size()).isEqualTo(carsCount);
        }

        @Test
        @DisplayName("차 이름이 중복되는 경우 예외가 발생한다.")
        void duplicatedCarNameTest() {
            String duplicatedCarNames = "pobi, crong, pobi";

            assertThatThrownBy(() -> CarFactory.generate(duplicatedCarNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 중복되지 않아야 합니다.");
        }
    }
}
