package racing.domain;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CarTest{
    @Test(expected = IllegalArgumentException.class)
    public void 이름_길이_체크() {
        Car car = new Car("abcdef");
    }
}
