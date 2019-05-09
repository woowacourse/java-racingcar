package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InputViewTest {

    @Test
    void 자동차_리스트가_제대로_만들어지는_테스트_같을_경우() {
        List<Car> actual = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));
        List<Car> expected = InputView.getCars("red, blue, green");

        assertEquals(expected, actual);
    }

    @Test
    void 자동차_리스트가_제대로_만들어지는지_테스트_다를_경우() {
        List<Car> actual = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));
        List<Car> expected = InputView.getCars("red, blue, black");

        assertNotEquals(expected, actual);
    }
}