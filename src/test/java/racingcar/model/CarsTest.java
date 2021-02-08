package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    @Test
    public void Cars_객체_생성자_빈_배열_매개변수_예외_테스트() {
        String[] carNames = {};
        assertThatThrownBy(() ->  new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 최소 하나의 자동차 이름을 입력하세요.");
    }

    @Test
    public void Cars_객체_생성자_중복_예외_테스트() {
        String[] carNames = {"test1", "test2", "test3", "test4", "test1"};
        assertThatThrownBy(() ->  new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 자동차 이름이 중복됩니다.");
    }

    @Test
    public void Cars_getWinner_동작_테스트() {
        String[] carNames = {"test1", "test2", "test3"};
        int distance[] = {8, 1, 3};
        Cars cars = new Cars(carNames, distance);
        assertThat(cars.getWinner()).isEqualTo("test1");
    }
}