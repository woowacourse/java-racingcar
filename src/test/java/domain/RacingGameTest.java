package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.PowerGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 자동차들 동작 테스트")
public class RacingGameTest {

    @Test
    @DisplayName("이름에 따라 자동차들이 정상적으로 생성되는가")
    void is_cars_correctly_made_by_name() {
        // given
        String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};

        // when
        RacingGame racingGame = new RacingGame(carNames);

        // then
        assertThat(racingGame.getAllCars()).extracting("name")
                .containsExactlyElementsOf(Arrays.stream(carNames).toList());
    }

    @Nested
    @DisplayName("우승자 반환 테스트")
    class WinnersReturnTest {

        @Test
        @DisplayName("단독 우승인 경우를 정상적으로 반환되는가")
        void return_single_winner_correctly_test() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            RacingGame racingGame = new RacingGame(carNames);

            // when
            List<Car> cars = racingGame.getAllCars();
            Car winner = cars.get(0);
            winner.move(9);

            // then
            List<Car> winners = racingGame.getWinners();
            assertThat(winners).containsExactly(winner);
        }

        @Test
        @DisplayName("복수 우승인 경우를 정상적으로 반환되는가")
        void return_multiple_winners_correctly_test() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            RacingGame racingGame = new RacingGame(carNames);

            // when
            List<Car> cars = racingGame.getAllCars();
            Car winnerA = cars.get(0);
            winnerA.move(9);
            Car winnerB = cars.get(1);
            winnerB.move(6);

            // then
            List<Car> winners = racingGame.getWinners();
            assertThat(winners).containsExactlyElementsOf(List.of(winnerA, winnerB));
        }

        @Test
        @DisplayName("우승자가 없는가")
        void no_winners_test() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            RacingGame racingGame = new RacingGame(carNames);

            // then
            List<Car> winners = racingGame.getWinners();
            assertThat(winners).isEmpty();
        }
    }


    @Test
    @DisplayName("자동차를 한 번 정상적으로 움직이는가")
    void move_cars_once_correctly_test() {
        // given
        final List<Integer> powers = List.of(3, 4);
        final PowerGenerator powerGenerator = new FixedPowerGenerator(powers);
        final RacingGame racingGame = new RacingGame(new String[]{"pobi", "weve"}, powerGenerator);

        // when
        racingGame.move();

        // then
        List<Car> cars = racingGame.getAllCars();
        Car pobiCar = cars.get(0);
        Car weveCar = cars.get(1);

        assertThat(pobiCar.getPosition()).isEqualTo(0);
        assertThat(weveCar.getPosition()).isEqualTo(1);
        assertThat(racingGame.getWinners()).containsExactly(weveCar);
    }

    @Test
    @DisplayName("자동차를 여러 번 정상적으로 움직이는가")
    void move_cars_multiply_times_correctly_test() {
        // given
        final List<Integer> powers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        final PowerGenerator powerGenerator = new FixedPowerGenerator(powers);
        final RacingGame racingGame = new RacingGame(new String[]{"pobi", "weve"}, powerGenerator);

        // when
        int numberOfAttempts = powers.size() / 2;
        IntStream.range(0, numberOfAttempts).forEach(ignore -> racingGame.move());

        // then
        List<Car> cars = racingGame.getAllCars();
        Car pobiCar = cars.get(0);
        Car weveCar = cars.get(1);

        assertThat(pobiCar.getPosition()).isEqualTo(2);
        assertThat(weveCar.getPosition()).isEqualTo(3);
        assertThat(racingGame.getWinners()).containsExactly(weveCar);
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
