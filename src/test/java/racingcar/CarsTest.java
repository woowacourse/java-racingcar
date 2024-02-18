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

            List<Integer> actual = List.of(1, 1);
            List<Integer> expected = cars.getCarPositions();

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("랜덤 넘버가 3 이하인 경우 차 정지")
        void testMoveCarsStop() {
            Cars cars = new Cars(new TestNumericGenerator(3), List.of("차1", "차2"));
            cars.move();

            List<Integer> actual = List.of(0, 0);
            List<Integer> expected = cars.getCarPositions();

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("제일 높은 값을 갖는 객체가 하나인 경우, 해당 객체를 제대로 리턴하는지 확인")
        void testCalculatorWinner() {
            Cars cars = new Cars(new TestNumericGenerator(4, 3), List.of("폭포", "포케"));
            cars.move();

            List<String> actual = cars.calculateWinner();
            List<String> expected = List.of("폭포");

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("제일 높은 값을 갖는 객체가 둘인 경우, 두 객체를 모두 제대로 리턴하는지 확인")
        void testCalculatorMultiWinner() {
            Cars cars = new Cars(new TestNumericGenerator(4, 4, 3), List.of("폭포", "포케", "무빈"));
            cars.move();

            List<String> actual = cars.calculateWinner();
            List<String> expected = List.of("폭포", "포케");

            assertThat(actual).isEqualTo(expected);
        }
    }
}
