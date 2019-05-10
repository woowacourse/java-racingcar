package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertUtilsTest {
    @Test
    void 자동차_목록이_이름_목록으로_올바르게_변환되는지_테스트() {
        List<String> expected = ConvertUtils.getNamesOfCars(Arrays.asList(new Car("red"), new Car("blue")));
        List<String> actual = Arrays.asList("red", "blue");

        assertEquals(expected, actual);
    }
}