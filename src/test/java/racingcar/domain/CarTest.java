package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.CarsGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {
    private static final int PROCEED_FlAG_NUMBER = 4;

    private Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("Car");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef,def", "abc,abc", "a,,bc", "a,  ,bcd, "})
    void 생성자에서_검증이_되는지_검사(String input) {
        assertThatThrownBy(
            () -> CarsGenerator.checkCarNames(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전진_경우() {
        car.proceed(PROCEED_FlAG_NUMBER);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 전진_안하는_경우() {
        car.proceed(PROCEED_FlAG_NUMBER - 1);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
