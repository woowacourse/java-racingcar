package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름을 받아 자동차를 생성한다.")
    void createRacingCars() {
        RacingCars racingCars = RacingCars.from("pobi,crong,honux");
        assertThat(racingCars.getCarNames()).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차의 이름이 중복되어 입력될 경우 예외가 발생한다.")
    void createExceptionByDuplicateName() {
        Name name = new Name("pobi");
        RacingCar racingCar = new RacingCar(name, () -> true);
        List<RacingCar> racingCars = Arrays.asList(racingCar, racingCar);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCars(racingCars))
            .withMessageMatching("자동차 이름은 중복되어 입력될 수 없다.");
    }

    @Test
    @DisplayName("자동차 이름의 공백을 제거한다.")
    void trimBlank() {
        RacingCars racingCars = RacingCars.from("pobi , cr ong , honux");
        assertThat(racingCars.getCarNames()).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차 우승자 이름을 계산한다.")
    void calculateWinnerNames() {
        RacingCars racingCars = RacingCars.from("pobi,crong,honux");
        List<String> winnerNames = racingCars.calculateWinnerNames();
        assertThat(winnerNames).containsExactly("pobi", "crong", "honux");
    }
}