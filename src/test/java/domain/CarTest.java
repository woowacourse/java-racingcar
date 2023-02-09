package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.assertj.core.condition.Negative;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;

public class CarTest {

    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("자동차의 이름의 길이가 1이상 5이하가 아니면 오류가 발생한다.")
    void carGenerateTest(String name) {
        //When
        Throwable result = catchThrowable(() -> {
            new Car(name, numberGenerator);
        });

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

}
