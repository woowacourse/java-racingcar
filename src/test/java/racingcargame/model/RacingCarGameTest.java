package racingcargame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.dto.CarDto;

class RacingCarGameTest {

    @DisplayName("경주횟수가 남아서 경주가 종료되지 않는다.")
    @Test
    void isNotOverRace() {
        final RacingCarGame racingCarGame = new RacingCarGame(List.of("마크", "애니"), "4");
        assertThat(racingCarGame.isNotOverRace()).isEqualTo(true);
    }

    @DisplayName("자동차 정보(이름, 위치)가 View에게 전달된다.")
    @Test
    void sendRacingCarsInformation() {
        final RacingCarGame racingCarGame = new RacingCarGame(List.of("마크", "애니"), "4");
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