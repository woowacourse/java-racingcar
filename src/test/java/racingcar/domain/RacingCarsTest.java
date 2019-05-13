package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    void 생성() {
        RacingCars racingCars = new RacingCars();
        RacingCars anotherRacingCars = new RacingCars();

        racingCars.add(new Car("pobi"));
        anotherRacingCars.add(new Car("pobi"));
        racingCars.add(new Car("cu"));
        anotherRacingCars.add(new Car("cu"));

        assertThat(racingCars).isEqualTo(anotherRacingCars);
    }

    @Test
    void 자동차가_일정_수_초과() {
        String[] carNames = {"pobi", "cu"};
        RacingCars racingCars = new RacingCars(carNames);

        assertThat(racingCars.isOver(1)).isTrue();
    }

    @Test
    void 자동차가_일정_수_이하() {
        String[] carNames = {"pobi", "cu"};
        RacingCars racingCars = new RacingCars(carNames);

        assertThat(racingCars.isOver(2)).isFalse();
    }

    @Test
    void 우승자_한명() {
        RacingCars racingCars = new RacingCars();
        racingCars.add(new Car("pobi", 5));
        racingCars.add(new Car("brown", 4));
        racingCars.add(new Car("jun", 3));
        racingCars.add(new Car("jason", 2));
        assertThat(racingCars.findWinningCars().get(0)).isEqualTo(new Car("pobi", 5));
    }

    @Test
    void 우승자_두명() {
        RacingCars racingCars = new RacingCars();
        racingCars.add(new Car("pobi", 5));
        racingCars.add(new Car("brown", 5));
        racingCars.add(new Car("jun", 3));
        racingCars.add(new Car("jason", 2));
        List<Car> winningCars = racingCars.findWinningCars();

        assertThat(winningCars.size()).isEqualTo(2);
        assertThat(winningCars.get(0)).isEqualTo(new Car("pobi", 5));
        assertThat(winningCars.get(1)).isEqualTo(new Car("brown", 5));
    }
}
