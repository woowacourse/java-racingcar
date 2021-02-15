package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;

public class RacingCarGameTest {
    @DisplayName("laps: 음수나 숫자아닌 값 입력 예외테스트")
    @ParameterizedTest
    @CsvSource(value = {"-1", "asdf"})
    void racing(String value) {
        assertThatThrownBy(() -> {
            new RacingCarGame(Arrays.asList("pobi", "crong"), value);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("one lap: 한 바퀴 도는 테스트")
    @Test
    void raceOneLap() {
        //given
        Cars cars = new Cars(Arrays.asList("gold", "tobi", "nana"));
        List<Integer> randoms = Arrays.asList(1, 4, 3);
        //when
        cars.raceOneLap(randoms);
        //then
        List<String> movedCar = cars.getCars().stream()
            .filter(car -> car.getPosition() == 1)
            .map(car -> car.getCarName())
            .collect(Collectors.toList());
        assertThat(movedCar).isEqualTo(Arrays.asList("tobi"));
    }

}
