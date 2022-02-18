package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import racingcar.controller.MovingStrategy;
import racingcar.controller.RacingCarCommander;

class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름을 받아 자동차를 생성한다.")
    void createRacingCars() {
        RacingCars racingCars = new RacingCars(Arrays.asList(new String[]{"pobi", "crong", "honux"}), new RacingCarCommander());
        List<String> carNames = racingCars.getRacingCarDtoList()
            .stream()
            .map(racingCarDto -> racingCarDto.getName())
            .collect(Collectors.toList());
        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차 이름의 공백을 제거한다.")
    void trimBlank() {
        RacingCars racingCars = new RacingCars(Arrays.asList(new String[]{"pobi" , "cr ong" , "honux"}), new RacingCarCommander());
        List<String> carNames = racingCars.getRacingCarDtoList()
            .stream()
            .map(racingCarDto -> racingCarDto.getName())
            .collect(Collectors.toList());
        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차 우승자 이름을 계산한다.")
    void calculateWinnerNames() {
        RacingCars racingCars = new RacingCars(Arrays.asList(new String[]{"pobi", "crong", "honux"}), new RacingCarCommander());
        List<String> winnerNames = racingCars.searchWinnerNames();
        assertThat(winnerNames).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("움직일 수 있는 상황이면, 자동차가 움직인다.")
    void checkCanMove() {
        MovingStrategy movingStrategy = () -> true;
        RacingCars racingCars = new RacingCars(Arrays.asList(new String[]{"pobi", "crong", "honux"}), movingStrategy);
        racingCars.moveCars();
        racingCars.getRacingCarDtoList()
            .forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
    }

    @Test
    @DisplayName("움직일 수 없는 상황이면, 자동차가 움직이지 않는다.")
    void checkNotMove() {
        MovingStrategy movingStrategy = () -> false;
        RacingCars racingCars = new RacingCars(Arrays.asList(new String[]{"pobi", "crong", "honux"}), movingStrategy);
        racingCars.moveCars();
        racingCars.getRacingCarDtoList()
            .forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
    }
}