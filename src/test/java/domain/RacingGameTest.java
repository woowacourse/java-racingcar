package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PowerGenerator;

import java.util.List;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTest {

    @DisplayName("자동차를 한 번 정상적으로 움직이는가")
    @Test
    void move_cars_once_correctly_test() {
        // given
        final CarGroup carGroup = new CarGroup(new String[]{"pobi", "weve"});
        final List<Integer> powers = List.of(3, 4);
        final PowerGenerator powerGenerator = new FixedPowerGenerator(powers);
        final RacingGame racingGame = new RacingGame(carGroup, powerGenerator);

        // when
        racingGame.moveCars();

        // then
        List<Car> cars = carGroup.getAllCars();
        Car pobiCar = cars.get(0);
        Car weveCar = cars.get(1);

        assertThat(pobiCar.getPosition()).isEqualTo(0);
        assertThat(weveCar.getPosition()).isEqualTo(1);
        assertThat(carGroup.getWinners()).containsExactly(weveCar);
    }

    @DisplayName("자동차를 여러 번 정상적으로 움직이는가")
    @Test
    void move_cars_multiply_times_correctly_test() {
        // given
        final CarGroup carGroup = new CarGroup(new String[]{"pobi", "weve"});
        final List<Integer> powers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        final PowerGenerator powerGenerator = new FixedPowerGenerator(powers);
        final RacingGame racingGame = new RacingGame(carGroup, powerGenerator);

        // when
        int numberOfAttempts = powers.size() / 2;
        range(0, numberOfAttempts).forEach(x ->
                racingGame.moveCars()
        );

        // then
        List<Car> cars = carGroup.getAllCars();
        Car pobiCar = cars.get(0);
        Car weveCar = cars.get(1);

        assertThat(pobiCar.getPosition()).isEqualTo(2);
        assertThat(weveCar.getPosition()).isEqualTo(3);
        assertThat(carGroup.getWinners()).containsExactly(weveCar);
    }

    static class FixedPowerGenerator implements PowerGenerator {
        private final List<Integer> numbers;
        private Integer index = 0;

        FixedPowerGenerator(final List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int getNumber() {
            return numbers.get(index++);
        }
    }

}
