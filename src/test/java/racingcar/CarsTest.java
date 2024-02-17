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
        private List<Integer> numbers = new ArrayList<>();
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
            Cars cars = new Cars(new TestNumericGenerator(4), List.of("차", "2개"));
            cars.moveCars();
            String actual = cars.toString();
            assertThat(actual).isEqualTo("차 : -\n2개 : -");
        }

        @Test
        @DisplayName("랜덤 넘버가 3 이하인 경우 차 정지")
        void testMoveCarsStop() {
            Cars cars = new Cars(new TestNumericGenerator(3), List.of("차", "2개"));
            cars.moveCars();
            String actual = cars.toString();
            assertThat(actual).isEqualTo("차 : \n2개 : ");
        }

        @Test
        @DisplayName("폭포가 4 포케가 3이 나오면 우승자는 폭포여야 함")
        void testCalculatorWinner() {
            Cars cars = new Cars(new TestNumericGenerator(4, 3), List.of("폭포", "포케"));
            cars.moveCars();
            String actual = cars.calculateWinner();
            assertThat(actual).isEqualTo("폭포");
        }

        @Test
        @DisplayName("폭포가 4 포케가 4, 무빈이 3이 나오면 우승자는 폭포와 포케여야 함")
        void testCalculatorMultiWinner() {
            Cars cars = new Cars(new TestNumericGenerator(4, 4, 3), List.of("폭포", "포케", "무빈"));
            cars.moveCars();
            String actual = cars.calculateWinner();
            assertThat(actual).isEqualTo("폭포, 포케");
        }
    }
}
