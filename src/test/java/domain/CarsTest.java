package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {
    @Test
    void checkSuccess() {
        assertThatThrownBy(() ->
                new Cars("aa,bb,cc")
        ).isNotInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void checkBlank(String input) {
        assertThatThrownBy(() ->
                new Cars(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa,bb,ccdddd", "aa, ,bb", "aa,,bb"})
    void carNameLength(String input) {
        assertThatThrownBy(() ->
                new Cars(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkCommaExist() {
        assertThatThrownBy(() ->
                new Cars("aa")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkDuplication() {
        assertThatThrownBy(() ->
                new Cars("aa,aa,ff")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,2"})
    void checkAddDistance(int i, int expected) {
        Cars cars = new Cars("aa,bb,ff");
        cars.addDistance(List.of(2, 5, 7));
        cars.addDistance(List.of(1, 2, 7));
        assertThat(cars.getCar(i).getDistance()).isEqualTo(expected);
    }
}