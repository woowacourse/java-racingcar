package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertUtilTest {
    @Test
    void 자동차_목록을_이름_목록으로_변환하는_기능을_검사() {
        List<String> actual = ConvertUtil.getNamesOfCars(Arrays.asList(new Car("red"), new Car("blue")));
        List<String> expected = Arrays.asList("red", "blue");

        assertEquals(expected, actual);
    }
}