package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void 자동차생성테스트() {
        Car car = new Car("pobi");
        assertThat(car).isEqualTo(new Car("pobi"));
    }

    @Test
    void 이름글자수제한테스트(){
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("abcdee");
        });
    }

    @Test
    void 전진테스트(){
        Car car =new Car("brown");
        car.tryGoForward(3);
        assertThat(car).isEqualTo(new Car("brown",0));

        car.tryGoForward(4);
        assertThat(car).isEqualTo(new Car("brown",1));
    }

}
