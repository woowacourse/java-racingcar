package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("전진 조건 값이 4 이상이면 전진한다.")
    void moveTest() {
        //given
        Car car = new Car("name");
        int condition = 4;

        //when
        car.move(condition);

        //then
        assertEquals(1, car.getMovement());
    }

    @Test
    @DisplayName("전진 조건 값이 3 이하면 정지한다.")
    void dontMoveTest() {
        //given
        Car car = new Car("name");
        int condition = 3;

        //when
        car.move(condition);

        //then
        assertEquals(0, car.getMovement());
    }

    @Test
    @DisplayName("주어진 자동차의 전진 회수가 같은지 확인한다.")
    void isAlsoWinnerTest() {
        //given
        Car car1 = new Car("mason");
        Car car2 = new Car("pobi");
        int condition1 = 5;
        int condition2 = 6;
        car1.move(condition1);
        car2.move(condition2);

        //when & then
        assertTrue(car1.isAlsoWinner(car2));
    }
}
