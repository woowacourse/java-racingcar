package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.DuplicateException;
import racingcar.exception.GlobalException;
import racingcar.mock.MockNumberGenerator;
import racingcar.provider.TestProvider;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.enumType.ExceptionMessage.DUPLICATE_MESSAGE;

class CarsTest {

    private Cars testCars;

    private MockNumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        String testCarNames = "pobi,crong,honux";
        numberGenerator = TestProvider.createMockNumberGenerator(false);
        testCars = TestProvider.createTestCars(testCarNames, numberGenerator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("정상적인 자동차 이름이 들어오면 예외가 발생하지 않는다.")
    void givenNormalCarNames_thenSuccess(final String carNames) {
        // when & then
        assertThatCode(() -> Cars.create(carNames, numberGenerator))
                .doesNotThrowAnyException();

        assertThat(Cars.create(carNames, numberGenerator))
                .isEqualTo(testCars);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("자동차 이름에 null 값이 들어오면 split 시 예외가 발생한다.")
    void givenNullCarNames_thenFail(final String carNames) {
        assertThatThrownBy(() -> Cars.create(carNames, numberGenerator))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi", "pobi, pobi"})
    @DisplayName("자동차 이름에 중복값이 들어오면 예외가 발생한다.")
    void givenDuplicateCarNames_thenFail(final String carNames) {
        assertThatThrownBy(() -> Cars.create(carNames, numberGenerator))
                .isInstanceOf(GlobalException.class)
                .isExactlyInstanceOf(DuplicateException.class)
                .hasMessageContaining(DUPLICATE_MESSAGE.getValue());
    }
}