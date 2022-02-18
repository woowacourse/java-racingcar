package racingcar.model.score;

import org.junit.jupiter.api.Test;
import racingcar.model.car.CarDto;
import racingcar.model.score.Score;
import racingcar.model.score.ScoreConverter;

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
