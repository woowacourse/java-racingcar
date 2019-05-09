package racing.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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

    @Test
    public void 이동_제어_테스트() {
        Car car = new Car("abc");
        assertEquals(true, car.isMove(4));
        assertEquals(false, car.isMove(0));
    }

    @Test
    public void 상태_문자_테스트() {
        Car car = new Car("abc", 3);

        assertEquals("abc : ---", car.getStatus());
    }


}
