package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.controller.NumericGenerator;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    static class TestNumericGenerator implements NumericGenerator {
        private final List<Integer> numbers = new ArrayList<>();
        private int position = 0;

        public TestNumericGenerator(int arg, int... args) {
            numbers.add(arg);
            for (int item : args) {
                numbers.add(item);
            }
        }


        @Override
        public int generate() {
            int generatedNumber = numbers.get(position);
            if (position < numbers.size() - 1) {
                position++;
            }
            return generatedNumber;
        }
    }

    @Nested
    class Feature {
        @Test
        @DisplayName("랜덤 넘버가 4 이상인 경우 차 위치 이동")
        void testMoveCarsMove() {
            Cars cars = new Cars(new TestNumericGenerator(4), List.of("차1", "차2"));
            cars.move();

            List<Integer> actual = cars.getPositions();
            List<Integer> expected = List.of(1, 1);

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("랜덤 넘버가 3 이하인 경우 차 정지")
        void testMoveCarsStop() {
            Cars cars = new Cars(new TestNumericGenerator(3), List.of("차1", "차2"));
            cars.move();

            List<Integer> actual = cars.getPositions();
            List<Integer> expected = List.of(0, 0);

            assertThat(actual).isEqualTo(expected);
        }
    }
}
