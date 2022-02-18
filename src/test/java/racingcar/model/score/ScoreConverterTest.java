package racingcar.model.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.CarDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreConverterTest {
    @Test
    @DisplayName("CarDtos를 입력 받아 Scores로 변환한다.")
    void ofCar() {
        String name = "범고래";
        List<Score> scores = ScoreConverter.of(List.of(new CarDto(name)));
        Score score = scores.get(0);
        assertThat(score.getName()).isEqualTo(name);
    }
}
