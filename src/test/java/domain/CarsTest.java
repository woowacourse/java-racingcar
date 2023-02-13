package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {
    @ParameterizedTest
    @DisplayName("각 자동차들이 예상된 목표치만큼 이동하는지 알아본다")
    @CsvSource(value = {"0,0", "1,1", "2,2"})
    void checkAddDistance(int i, int expected) {
        List<String> names = List.of("aa", "bb", "cc");
        Cars cars = new Cars(names);
        cars.addDistance(List.of(2, 5, 7));
        cars.addDistance(List.of(1, 2, 7));
        assertThat(cars.getCar(i).getDistance()).isEqualTo(expected);
    }
}
