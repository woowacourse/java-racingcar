package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름이 영문,숫자로만 이루어지고 , 기준으로 입력됐을때(정상작동하는 경우)")
    void cars_generation_test() {
        List<String> carNames = List.of("mangc", "weve", "pobi", "neo");

        RacingCars racingCars = new RacingCars(carNames);
        List<Car> expected = List.of(new Car("mangc"), new Car("weve"), new Car("pobi"),
                new Car("neo"));

        assertThat(racingCars.getAllCars()).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("자동차의 이름에 중복이 존재하는 경우는 예외를 발생시킨다.")
    void cars_generation_by_has_duplication() {
        List<String> carNames = List.of("weve", "weve", "pobi", "neo");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCars(carNames);
        });
    }

    @Test
    @DisplayName("Position이 가장 큰 Car 객체를 반환하는가")
    void get_winners_test() {
        List<String> carNames = List.of("mangc", "weve", "pobi", "neo");
        RacingCars racingCars = new RacingCars(carNames);

        List<Car> cars = racingCars.getAllCars();
        Car winner = cars.get(0);
        winner.execute(9);

        assertThat(racingCars.getMaxPositionCars()).containsExactly(winner);
    }
}
