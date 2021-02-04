package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @Test
    void Cars_쉼표로_구분된_문저열_받으면_객체가_생성된() {
        String carNames = "pobi,brown";
        assertThatCode( () -> Cars.generate(input))
                .doesNotThrowAnyException();
    }

    static class Cars {
        private static final String DELIMITER = ",";
        private static final int SPLIT_THRESHOLD = -1;

        private final List<Car> cars;

        private Cars(List<Car> cars){
            this.cars = new ArrayList<>(cars);
        }

        public static Cars generate(String carNames) {
            String[] splitCarNames = splitCarNames(carNames);
            List<Car> cars = Arrays.stream(splitCarNames)
                    .map(Car::new)
                    .collect(Collectors.toList());
            return new Cars(cars);
        }

        private static String[] splitCarNames(String carNames) {
            return carNames.split(DELIMITER, SPLIT_THRESHOLD);
        }
    }
}