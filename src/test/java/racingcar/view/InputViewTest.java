package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.GameCount;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InputViewTest {
    @Test
    void 자동차_리스트가_올바르게_만들어지는지_테스트_같을_경우() {
        List<Car> expected = InputView.getCars("red, blue, green");
        List<Car> actual = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));

        assertEquals(expected, actual);
    }

    @Test
    void 자동차_리스트가_올바르게_만들어지는지_테스트_다를_경우() {
        List<Car> expected = InputView.getCars("red, blue, black");
        List<Car> actual = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));

        assertNotEquals(expected, actual);
    }

    @Test
    void 게임_횟수_객체가_올바르게_만들어지는지_테스트() {
        GameCount expected = InputView.getGameCount("3");
        GameCount actual = new GameCount(3);

        assertEquals(expected, actual);
    }
}