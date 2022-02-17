package racingcargame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.dto.CarDto;

class RacingCarGameTest {
    private final RacingCarGame racingCarGame = new RacingCarGame(List.of("마크", "애니"), "4");

    @DisplayName("경주 종료여부 확인 테스트")
    @Test
    void isNotOverRace() {
        assertThat(racingCarGame.isNotOverRace()).isEqualTo(true);
    }

    @DisplayName("자동차 정보가 정상적으로 전달되는지 테스트")
    @Test
    void sendRacingCarsInformation() {
        final List<CarDto> actual = racingCarGame.sendRacingCarsInformation();
        final CarDto first = new CarDto("마크", 0);
        final CarDto second = new CarDto("애니", 0);
        final List<CarDto> expected = List.of(first, second);

        IntStream.range(0, actual.size()).forEach(index -> {
            assertThat(actual.get(index).getName()).isEqualTo(expected.get(index).getName());
            assertThat(actual.get(index).getPosition()).isEqualTo(expected.get(index).getPosition());
        });
    }
}