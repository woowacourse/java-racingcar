package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.assertj.core.condition.Negative;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;

public class CarTest {

    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void carGenerateTest(String name) {
        //When
        Throwable result = catchThrowable(() -> {
            new Car(name, numberGenerator);
        });

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

}
