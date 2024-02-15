package application;

import static fixture.CarFixture.자동차들;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import model.Cars;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;

class RaceServiceTest {
    @Test
    void 모든_자동차가_멈추지_않고_전진한다() {
        // given
        Cars cars = 자동차들(2);
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(4, 4));
        RaceService raceService = new RaceService(numberGenerator);

        // when
        raceService.moveCars(cars);

        // then
        cars.getCars().forEach(car ->
                assertThat(car.getPosition()).isEqualTo(1)
        );
    }

    @Test
    void 전진_임계값_이상인_자동차만_전진한다() {
        // given
        Cars cars = 자동차들(3);
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(3, 4, 5));
        RaceService raceService = new RaceService(numberGenerator);

        // when
        raceService.moveCars(cars);

        // then
        assertAll(
                () -> assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0),
                () -> assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1),
                () -> assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1)
        );
    }

    class TestNumberGenerator implements NumberGenerator {
        private final List<Integer> numbers;
        private int index = 0;

        private TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generateNumber() {
            return this.numbers.get(index++);
        }
    }
}