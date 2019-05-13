package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void 자동차생성() {
        Car car = new Car("pobi");
        assertThat(car).isEqualTo(new Car("pobi"));
    }

    @Test
    void 이름글자수제한(){
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("abcdee");
        });
    }

    @Test
    void 전진(){
        Car car =new Car("brown");
        car.tryGoForward(3);
        assertThat(car).isEqualTo(new Car("brown",0));

        car.tryGoForward(4);
        assertThat(car).isEqualTo(new Car("brown",1));
    }

    @Test
    void 자동차비교(){
        Car car1 = new Car ("a",1);
        Car car2 = new Car ("a",2);
        Car car3 = new Car ("a",1);
        assertThat(car1.compareTo(car2) == -1).isTrue();
        assertThat(car2.compareTo(car1) == 1).isTrue();
        assertThat(car1.compareTo(car3) == 0).isTrue();

    }
}
