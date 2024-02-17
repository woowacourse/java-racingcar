package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.NumericGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    class ValidateInput {
        @ParameterizedTest
        @ValueSource(strings = { ",포케", "폭포," })
        @DisplayName("콤마가 맨 앞 또는 맨 뒤에 위치하면 에러 발생")
        void testNameUnderFive(String given) {
            assertThatThrownBy(() -> new Cars(given))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class Feature {
        @Test
        @DisplayName("차를 2개 추가")
        void testSplit() {
            Cars cars = new Cars("차,2개");
            String actual = cars.toString();
            assertThat(actual).contains("차", "2개");
        }

        @Test
        @DisplayName("랜덤 넘버가 4 이상인 경우 차 위치 이동")
        void testMoveCarsMove() {
            Cars cars = new Cars("차,2개");
            NumericGenerator generator = new TestNumericGenerator(4);
            cars.moveCars(generator);
            String actual = cars.toString();
            assertThat(actual).isEqualTo("차 : -\n2개 : -");
        }

        @Test
        @DisplayName("랜덤 넘버가 3 이하인 경우 차 정지")
        void testMoveCarsStop() {
            Cars cars = new Cars("차,2개");
            NumericGenerator generator = new TestNumericGenerator(3);
            cars.moveCars(generator);
            String actual = cars.toString();
            assertThat(actual).isEqualTo("차 : \n2개 : ");
        }

        @Test
        @DisplayName("폭포가 4 포케가 3이 나오면 우승자는 폭포여야 함")
        void testCalculatorWinner() {
            Cars cars = new Cars("폭포,포케");
            NumericGenerator generator = new TestNumericGenerator(4, 3);
            cars.moveCars(generator);
            String actual = cars.calculateWinner();
            assertThat(actual).isEqualTo("폭포");
        }

        @Test
        @DisplayName("폭포가 4 포케가 4, 무빈이 3이 나오면 우승자는 폭포와 포케여야 함")
        void testCalculatorMultiWinner() {
            Cars cars = new Cars("폭포,포케,무빈");
            NumericGenerator generator = new TestNumericGenerator(4, 4, 3);
            cars.moveCars(generator);
            String actual = cars.calculateWinner();
            assertThat(actual).isEqualTo("폭포, 포케");
        }
    }
}
