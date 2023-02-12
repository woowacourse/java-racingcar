package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.FixedNumberGenerator;
import racingCar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @ParameterizedTest
    @DisplayName("RacingGame에서 0-3의 숫자로 play()하면 차들은 움직이지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void play_notMove_if0to3(int fixedNumber) {
        RacingGame racingGame = new RacingGame(List.of("aa", "bb", "cc"), 3);

        List<CarDto> carStatuses = racingGame.play(new FixedNumberGenerator(fixedNumber));

        Assertions.assertThat(carStatuses.stream().map(CarDto::getPosition).collect(Collectors.toList())).containsOnly(0);
    }

    @ParameterizedTest
    @DisplayName("RacingGame에서 4-9의 숫자로 play()하면 차들은 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void play_move_if4to9(int fixedNumber) {
        RacingGame racingGame = new RacingGame(List.of("aa", "bb", "cc"), 6);

        List<CarDto> carStatuses = racingGame.play(new FixedNumberGenerator(fixedNumber));

        Assertions.assertThat(carStatuses.stream().map(CarDto::getPosition).collect(Collectors.toList())).containsOnly(1);
    }
}
