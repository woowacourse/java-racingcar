package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreConverterTest {
    @Test
    void ofCar() {
        String name = "범고래";
        CarDto car = new CarDto(name);

        Score score = ScoreConverter.of(car);
        assertThat(score.getName()).isEqualTo(car.getName());
    }
}
