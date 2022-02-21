package racingcar.service.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.score.Score;
import racingcar.service.CarDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreConverterTest {

    @Test
    @DisplayName("CarDto리스트를 입력하면 Score리스트로 변환한다.")
    void of() {
        List<CarDto> carDtos = List.of(new CarDto("범고래", 1));
        List<Score> scores = ScoreConverter.of(carDtos);
        assertThat(scores.size()).isEqualTo(1);
    }
}