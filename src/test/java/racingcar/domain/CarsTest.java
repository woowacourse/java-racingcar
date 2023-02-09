package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.provider.TestProvider;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"} )
    @DisplayName("정상적인 차량 이름이 들어오면 예외가 발생하지 않는다.")
    void givenNormalCarNames_thenSuccess(String carNames) {
        assertThatCode(() -> Cars.of(carNames))
                .doesNotThrowAnyException();

        assertThat(Cars.of(carNames))
                .isEqualTo(TestProvider.createTestCars());
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("차량 이름에 null값이 들어오면 split 시 에외가 발생한다.")
    void givenNullCarNames_thenFail(String carNames) {
        assertThatThrownBy(() -> Cars.of(carNames))
                .isInstanceOf(NullPointerException.class);
    }
}