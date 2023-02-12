package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;

import java.util.List;

class CarsTest {

    @Test
    @DisplayName("3 이하의 숫자가 나온 자동차들은 전진하지 않는다.")
    void progressRound_all_stop() {
        Cars cars = new Cars(List.of("pobi", "crong", "hunox"));
        int startNumber = 1;
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(startNumber);

        cars.progressRound(testNumberGenerator, new MovementManager());

        for (Car car : cars.getCars()) {
            Assertions.assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("4 이상의 숫자가 나온 자동차들은 전진한다.")
    void progressRound_all_move() {
        Cars cars = new Cars(List.of("pobi", "crong", "hunox"));
        int startNumber = 4;
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(startNumber);

        cars.progressRound(testNumberGenerator, new MovementManager());

        for (Car car : cars.getCars()) {
            Assertions.assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    public static class TestNumberGenerator implements NumberGenerator {

        public int testNumber;

        public TestNumberGenerator(Integer number) {
            this.testNumber = number;
        }

        @Override
        public Integer generateNumber() {
            return testNumber++;
        }
    }

}