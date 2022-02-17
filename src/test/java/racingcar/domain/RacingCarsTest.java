package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름을 받아 자동차를 생성한다.")
    void createRacingCars() {
        final RacingCars racingCars = RacingCars.from("pobi,crong,honux");
        assertThat(racingCars.getCarNames()).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차의 이름이 중복되어 입력될 경우 예외가 발생한다.")
    void createExceptionByDuplicateName() {
        final Name name = new Name("pobi");
        final RacingCar racingCar = new RacingCar(name, () -> true);
        final List<RacingCar> racingCars = Arrays.asList(racingCar, racingCar);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCars(racingCars))
            .withMessageMatching("자동차 이름은 중복되어 입력될 수 없다.");
    }

    @Test
    @DisplayName("자동차 이름의 공백을 제거한다.")
    void trimBlank() {
        final RacingCars racingCars = RacingCars.from("pobi , cr ong , honux");
        assertThat(racingCars.getCarNames()).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("다수 우승자이름을 계산한다.")
    void calculateMultiWinnerNames() {
        final RacingCars racingCars = RacingCars.from("pobi,crong,honux");
        final List<String> winnerNames = racingCars.calculateWinnerNames();
        assertThat(winnerNames).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("단일 우승자이름을 계산한다.")
    void calculateSingleWinnerName() {
        // given
        final RacingCar pobi = new RacingCar(new Name("pobi"), () -> true);
        pobi.move();
        final RacingCar crong = new RacingCar(new Name("crong"), () -> false);
        final RacingCar honux = new RacingCar(new Name("honux"), () -> false);
        final RacingCars racingCars = new RacingCars(Arrays.asList(pobi, crong, honux));

        // when
        final List<String> winnerName = racingCars.calculateWinnerNames();

        assertAll(
            () -> assertThat(winnerName.size()).isEqualTo(1),
            () -> assertThat(winnerName).containsExactly("pobi")
        );
    }
}