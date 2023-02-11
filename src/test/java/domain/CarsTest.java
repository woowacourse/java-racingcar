package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class CarsTest {
    @Test
    @DisplayName("정상적인 자동차 이름들을 입력받으면 오류가 발생하지 않는지 확인한다")
    void checkSuccess() {
        assertThatCode(() ->
            new Cars("aa,bb,cc")
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("빈 값이나 공백이 들어왔을때 오류가 발생하지 확인한다")
    @ValueSource(strings = {"", " "})
    void checkBlank(String input) {
        assertThatThrownBy(() ->
                new Cars(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이름 규칙에 맞지않는 값이 들어왔을때 오류가 발생하지 않는지 확인한다")
    @ValueSource(strings = {"aa,bb,ccdddd", "aa, ,bb", "aa,,bb"})
    void carNameLength(String input) {
        assertThatThrownBy(() ->
                new Cars(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("한 대의 차만 입력되었을때 오류가 발생하는지 확인한다")
    void checkCommaExist() {
        assertThatThrownBy(() ->
                new Cars("aa")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 차 이름을 입력 받았을때 오류가 발생하는지 확인한다")
    void checkDuplication() {
        assertThatThrownBy(() ->
                new Cars("aa,aa,ff")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("각 자동차들이 예상된 목표치만큼 이동하는지 알아본다")
    @CsvSource(value = {"0,0", "1,1", "2,2"})
    void checkAddDistance(int i, int expected) {
        Cars cars = new Cars("aa,bb,ff");
        cars.addDistance(List.of(2, 5, 7));
        cars.addDistance(List.of(1, 2, 7));
        assertThat(cars.getCar(i).getDistance()).isEqualTo(expected);
    }
}
