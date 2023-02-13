package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.FixedNumberGenerator;
import racingCar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @ParameterizedTest
    @DisplayName("RacingGame에서 0-3의 숫자로 play()하면 차들은 움직이지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void play_notMove_if0to3(int fixedNumber) {
        RacingGame racingGame = new RacingGame(List.of("aa", "bb", "cc"), 3);

        List<CarDto> carStatuses = racingGame.play(new FixedNumberGenerator(fixedNumber));
        List<Integer> positions = carStatuses.stream().map(CarDto::getPosition).collect(Collectors.toList());

        assertThat(positions).containsOnly(0);
    }

    @ParameterizedTest
    @DisplayName("RacingGame에서 4-9의 숫자로 play()하면 차들은 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void play_move_if4to9(int fixedNumber) {
        RacingGame racingGame = new RacingGame(List.of("aa", "bb", "cc"), 6);

        List<CarDto> carStatuses = racingGame.play(new FixedNumberGenerator(fixedNumber));
        List<Integer> positions = carStatuses.stream().map(CarDto::getPosition).collect(Collectors.toList());

        assertThat(positions).containsOnly(1);
    }

    @Test
    @DisplayName("racingGame의 시도횟수가 0인 상태에서 또 play 하면 예외가 발생한다")
    void play_fail_if_tryCount_is_0() {
        RacingGame racingGame = new RacingGame(List.of("aa", "bb", "cc"), 0);

        assertThatThrownBy(() -> {
            racingGame.play(new FixedNumberGenerator(3));
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("게임의 시도횟수를 모두 소진했습니다.");
    }
}
