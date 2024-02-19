package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.powergenerator.PowerGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
    PowerGenerator powerGenerator;

    @BeforeEach
    void setUp() {
        powerGenerator = () -> 1;
    }

    @Test
    void 자동차_이름이_공백을_포함한_5자_초과면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("pobibi", powerGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"pobi, 4, 1", "pobi, 3, 0"})
    void 주어진_값이_4_이상인_경우_전진한다(String name, int number, int forwardCount) {
        Car car = new Car(name, () -> number);
        car.tryForward();
        assertThat(car.getForwardCount()).isEqualTo(forwardCount);
    }
}
