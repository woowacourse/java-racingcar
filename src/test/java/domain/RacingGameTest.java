package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PowerGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTest {

    @DisplayName("레이스가 정상적으로 진행되는가")
    @Test
    void is_race_proceed_correctly_test() {
        // given
        final CarGroup carGroup = new CarGroup(new String[]{"pobi", "weve"});
        final Attempts attempts = new Attempts(4);
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        final PowerGenerator powerGenerator = new FixedPowerGenerator(numbers);

        // when
        final RacingGame racingGame = new RacingGame(carGroup, attempts, powerGenerator);
        racingGame.race();

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
