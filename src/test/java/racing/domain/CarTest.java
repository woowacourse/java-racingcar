package racing.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    @Test(expected = IllegalArgumentException.class)
    public void 이름_길이_체크_1() {
        Car car = new Car("abcdef");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름_길이_체크_2() {
        Car car = new Car("abcdef", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름_공백_체크() {
        Car car = new Car("");
    }

    @Test(expected = NullPointerException.class)
    public void 이름_NULL_체크3() {
        Car car = new Car(null);
    }

    @Test
    public void 이동_제어_테스트() {
        Car car = new Car("abc");
        assertEquals(2, car.move(Rules.MIN_MOVABLE_NUMBER));
        assertEquals(2, car.move(Rules.MIN_MOVABLE_NUMBER - 1));
    }

    @Test
    public void 상태_문자_테스트() {
        Car car = new Car("abc", 3);

        assertEquals("abc : ---", car.getStatus());
    }


}
